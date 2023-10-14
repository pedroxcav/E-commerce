package com.Eletronics.model;

import com.Eletronics.repository.ClienteDAO;
import com.Eletronics.services.CarrinhoServices;
import com.Eletronics.services.ClienteServices;
import com.Eletronics.services.CompraServices;
import com.Eletronics.services.exceptions.Exception_Cadastro;
import com.Eletronics.services.tools.GeradorAleatorio;
import com.Eletronics.services.tools.Warning;
import java.sql.SQLException;

public class Cliente extends Usuario {
    
    public Cliente (String ID, String nome, String CPF, String senha) {
        super(ID, nome, CPF, senha);
    }
    
    public Cliente() {
        super();
    }
    
    @Override
    public void registar(Usuario cliente) {
        try {
            ClienteServices.verificar(cliente);
            ClienteDAO.regitsrar(cliente);
            Carrinho carrinho = new Carrinho(GeradorAleatorio.gerarCarrinhoID(), cliente.getID());
            CarrinhoServices.regitsrar(carrinho);
            Compra compra = new Compra(GeradorAleatorio.gerarCompraID(), cliente.getID());
            CompraServices.regitsrar(compra);
        } catch (Exception_Cadastro e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao cadastrar.");
            warning.setVisible(true);
        }
    }

    @Override
    public boolean entrar(String ID_Cliente, String senha) {
        try {
            return ClienteDAO.entrar(ID_Cliente, senha);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao acessar.");
            warning.setVisible(true);
            return false;
        }
    }
}
