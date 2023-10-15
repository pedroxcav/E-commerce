package com.Eletronics.repository;

import com.Eletronics.model.Cliente;
import com.Eletronics.model.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompraDAO {
    
    public static boolean verificar(String ID_Compra) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from compra where id_Compra = '"+ID_Compra+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
    
    public static void registar (Compra compra) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "insert into compra (id_Compra, id_Cliente) values (?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, compra.getID_Compra());
            ps.setString(2, compra.getID_Cliente());
            ps.execute();
        }
    }
    
    public static Compra trazerCompra(Cliente cliente) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            Compra compra = null;
            String sql = "select * from compra where id_Cliente = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, cliente.getID());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String ID_Compra = rs.getString("id_Compra");
                String ID_Cliente = rs.getString("id_Cliente");
                compra = new Compra(ID_Compra, ID_Cliente);
            }
            return compra;
        }
    }
}
