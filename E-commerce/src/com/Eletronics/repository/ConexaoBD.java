package com.Eletronics.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private final String host = "localhost";
    private final String porta = "3306";
    private final String usuario = "root";
    private final String senha = "usjt";
    private final String bd = "db_eletronics";

    public Connection obtemConexao (){
        try {
            Connection c = DriverManager.getConnection ("jdbc:mysql://"+host+":"+porta+"/"+ bd,usuario,senha);
            return c;
        } catch (SQLException e){
            System.out.println("Banco de dados [ERRO]");
            return null;
        }
    }
}
