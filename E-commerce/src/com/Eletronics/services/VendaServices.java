package com.Eletronics.services;

import com.Eletronics.repository.VendaDAO;
import com.Eletronics.services.tools.Warning;
import java.sql.SQLException;

public class VendaServices {
    
    public static boolean verificar(String ID_Venda) {
        try {
            return VendaDAO.verificar(ID_Venda);
        } catch (SQLException ex) {
            Warning warning = new Warning("Erro desconhecido.");
            warning.setVisible(true);
            return true;
        }
    }
}
