/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

import com.Eletronics.repository.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author pedro
 */
public class Operations {
    public static void getProductsDatabase(JList list){
        ConexaoBD cbd = new ConexaoBD();
        DefaultListModel listModel = new DefaultListModel();
        listModel.clear();
        try (Connection c = cbd.obtemConexao()){
            String sql = "select * from products";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do {
                    byte[] imageBytes = rs.getBytes("imagem");
                    listModel.addElement(new Product(rs.getString("nome"), new ImageIcon(imageBytes), "descrição eitaa!"));
                } while (rs.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            list.setCellRenderer(new CustomRenderer());
            list.setModel(listModel);
        }
    }
    
    public static void getProduct(JList list){
        int index = list.getSelectedIndex();
        System.out.println(index);
    }
}
