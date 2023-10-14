package com.Eletronics.model;

import com.Eletronics.repository.AdministradorDAO;
import com.Eletronics.services.AdministradorServices;
import com.Eletronics.services.exceptions.Exception_Cadastro;
import com.Eletronics.services.tools.Warning;
import java.sql.SQLException;

public class Administrador extends Usuario {
    
    public Administrador (String ID, String nome, String CPF, String senha) {
        super(ID, nome, CPF, senha);
    }
    
    public Administrador() {
        super();
    }

    @Override
    public void registar(Usuario administrador) {
        try {
            AdministradorServices.verificar(administrador);
            AdministradorDAO.regitsrar(administrador);
        } catch (Exception_Cadastro e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao cadastrar.");
            warning.setVisible(true);
        }
    }

    @Override
    public boolean entrar(String ID_Administrador, String senha) {
        try {
            return AdministradorDAO.entrar(ID_Administrador, senha);
        } catch (SQLException e) {
            e.printStackTrace();
            Warning warning = new Warning("Erro ao acessar.");
            warning.setVisible(true);
            return false;
        }
    }
}
