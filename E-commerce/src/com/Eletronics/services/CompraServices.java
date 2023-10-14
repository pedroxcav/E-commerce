package com.Eletronics.services;

import com.Eletronics.model.Compra;
import com.Eletronics.repository.CompraDAO;
import com.Eletronics.services.tools.Warning;
import java.sql.SQLException;

public class CompraServices {
    
    public static boolean verificar(String ID_Compra) {
        try {
            return CompraDAO.verificar(ID_Compra);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return true;
        }
    }
    
    public static void regitsrar(Compra compra) {
        try {
            CompraDAO.registar(compra);
        } catch (SQLException e) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
        }
    }
}
