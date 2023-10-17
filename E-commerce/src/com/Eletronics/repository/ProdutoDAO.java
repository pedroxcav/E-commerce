package com.Eletronics.repository;

import com.Eletronics.model.Produto;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;

public class ProdutoDAO {
    
    public static boolean verificar(String ID_Produto) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from produto where id_Produto = '"+ID_Produto+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
    
    public static void registrar(Produto produto) throws SQLException, IOException{
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "insert into produto (id_Produto, nome, descricao, valor, imagem) values (?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, produto.getID_Produto());
            ps.setString(2, produto.getNome());
            ps.setString(3, produto.getDescricao());
            ps.setDouble(4, produto.getValor());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(produto.getImagem(), "png", baos);
            Blob blob = new javax.sql.rowset.serial.SerialBlob(baos.toByteArray());
            ps.setBlob(5, blob);
            ps.execute();
        }
    }
    
    public static DefaultListModel trazerProdutos(String text) throws SQLException, IOException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){
            String sql = "select * from produto where nome like '"+text+"%' and ativo = true";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            DefaultListModel modelo = new DefaultListModel();
            while (rs.next()) {
                String ID_Produto = rs.getString("id_Produto");
                modelo.addElement(trazerProduto(ID_Produto));
            }
            return modelo;
        }
    }
    
    public static Produto trazerProduto(String ID_Produto) throws SQLException, IOException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "select * from produto where id_Produto = '"+ID_Produto+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                double valor = rs.getDouble("valor");
                BufferedImage imagem = ImageIO.read(new ByteArrayInputStream(rs.getBytes("imagem")));
                return new Produto(ID_Produto, nome, descricao, valor, imagem);
            } else
                return null;
        }
    }
    
    public static void atualizar(Produto produto) throws SQLException, IOException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "update produto set nome = ?, descricao = ?, valor = ?, imagem = ? where id_Produto = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, produto.getID_Produto());
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setDouble(3, produto.getValor());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(produto.getImagem(), "png", baos);
            Blob blob = new javax.sql.rowset.serial.SerialBlob(baos.toByteArray());
            ps.setBlob(4, blob);
            ps.setString(5, produto.getID_Produto());
            ps.execute();
        }
    }
    
    public static void excluir(Produto produto) throws SQLException {
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()) {
            String sql = "update produto set ativo = false where id_Produto = '"+produto.getID_Produto()+"'";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.execute();
        }
    }
}
