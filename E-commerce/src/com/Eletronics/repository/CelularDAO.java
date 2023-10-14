package com.Eletronics.repository;

import com.Eletronics.model.Celular;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CelularDAO {
    
    public static boolean verificar(String ID_Cliente) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from celular where id_Cliente = '"+ID_Cliente+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
    
    public static Celular trazerCelular(String ID_Cliente) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from celular where id_Cliente = '"+ID_Cliente+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String DDD = rs.getString("DDD");
                String celular = rs.getString("celular");
                return new Celular(ID_Cliente, DDD, celular);
            } else
                return null;
        }
    }
    
    public static void excluir(Celular celular) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "delete from celular where id_Cliente = '"+celular.getID_Cliente()+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.execute();
        }
    }
    
    public static void registrar(Celular celular) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "insert into celular values (?,?,?);";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, celular.getID_Cliente());
            ps.setString(2, celular.getDDD());
            ps.setString(3, celular.getCelular());
            ps.execute();
        }
    }
    
    public static void atualizar(Celular celular) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "update celular set DDD = ?, celular = ? where id_Cliente = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, celular.getDDD());
            ps.setString(2, celular.getCelular());
            ps.setString(3, celular.getID_Cliente());
            ps.execute();
        }
    }
}
