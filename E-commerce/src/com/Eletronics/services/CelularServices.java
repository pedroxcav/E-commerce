package com.Eletronics.services;

import com.Eletronics.model.Celular;
import com.Eletronics.model.Cliente;
import com.Eletronics.repository.CelularDAO;
import com.Eletronics.services.tools.Warning;
import java.sql.SQLException;

public class CelularServices {
    
    public static boolean verificar(String ID_Cliente) {
        try {
            return CelularDAO.verificar(ID_Cliente);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return true;
        }
    }
    
    public static Celular trazerCelular(String ID_Cliente) {
        try {
            return CelularDAO.trazerCelular(ID_Cliente);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return null;
        }
    }
    
    public static void excluir(Celular celular) {
        try {
            CelularDAO.excluir(celular);
        } catch (SQLException ex) {
            Warning warning = new Warning("Erro ao excluir.");
            warning.setVisible(true);
        }
    }
    
    public static void registrar(Celular celular) {
        try {
            CelularDAO.registrar(celular);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao salvar.");
            warning.setVisible(true);
        }
    }
    
    public static void atualizar(Celular celular) {
        try {
            CelularDAO.atualizar(celular);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro ao salvar.");
            warning.setVisible(true);
        }
    }
    
    public static Celular formatarCelular(Cliente cliente, String text) {
        if (text.length() == 11) {
                String dados[] = text.split("");
                String DDD = "";
                String numero = "";
                for (int i=0; i < dados.length; i++) {
                    if (i<2)
                        DDD += dados[i];
                    else
                        numero += dados[i];
                }
                return new Celular(cliente.getID(), DDD, numero);
        } else
            return null;
    }
}
