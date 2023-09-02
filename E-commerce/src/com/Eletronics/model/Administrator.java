/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Eletronics.model;

import com.Eletronics.repository.ConexaoBD;
import com.Eletronics.view.Warning;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class Administrator extends User {
    
    public Administrator(){}
    
    @Override
    public void registerUser(User user) {

    }
    @Override
    public boolean logInto(String userId, String password) {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "select usuario,senha from administrators where usuario = ? and senha = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                return true;
        } catch (SQLException e) {
            Warning warning = new Warning("Não foi possível entrar.");
            warning.setVisible(true);
            e.printStackTrace();
        }
        Warning warning = new Warning("Acesso incorreto!");
        warning.setVisible(true);
        return false;
    }
    @Override
    protected boolean verifyUser(User user) throws Exception {
        return true;
    }
}
