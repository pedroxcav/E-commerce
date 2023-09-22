/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Eletronics.services;

import com.Eletronics.model.Administrator;
import com.Eletronics.model.User;
import com.Eletronics.repository.ConexaoBD;
import com.Eletronics.view.Warning;
import javax.swing.DefaultListModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class AdministratorServices {
    public static boolean verifyAdministrator(User administrator) throws SQLException, Exception_Data {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select usuario, CPF from administrators where usuario = ? or CPF = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, administrator.getUserId());
            ps.setString(2, administrator.getCPF());
            ResultSet rs = ps.executeQuery();
            if (rs.next() == false)
                return false;
            else {
                int errorType = 0;
                do {
                    String usuario = rs.getString("usuario");
                    String CPF = rs.getString("CPF");
                    if (usuario.equals(administrator.getUserId()))
                        errorType++;
                    if (CPF.equals(administrator.getCPF()))
                        errorType+=2;
                } while (rs.next());
                switch (errorType) {
                    case 1:
                        throw new Exception_Data("Usuário já utilizado!");
                    case 2:
                        throw new Exception_Data("Este CPF já foi utilizado!");
                    default:
                        throw new Exception_Data("Usuário e CPF já utilizados!");
                }
            }
        }
    }
    
    public static DefaultListModel getAdministratorDatabase(){
        ConexaoBD cbd = new ConexaoBD();
        DefaultListModel listModel = new DefaultListModel();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from administrators";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                do {
                    String name = rs.getString("nome");
                    String id = rs.getString("usuario");
                    String CPF = rs.getString("CPF");
                    String password = rs.getString("senha");
                    listModel.addElement(new Administrator(name, id, CPF, password));
                } while (rs.next());
            }
        } catch (Exception e) {
            Warning warning = new Warning("[ERRO]");
            warning.setVisible(true);
        }
        return listModel;
    }
    
    public static void deleteAdministrator(Administrator administrator) {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "delete from administrators where usuario  = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, administrator.getUserId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
