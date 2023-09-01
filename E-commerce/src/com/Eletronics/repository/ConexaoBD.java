package com.Eletronics.repository;

import com.Eletronics.view.Warning;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {
    private static String host = "localhost";
    private static String porta = "3306";
    private static String usuario = "root";
    private static String senha = "usjt";
    private static String bd = "Eletronics";

    public Connection obtemConexao (){
        try {
            Connection c = DriverManager.getConnection ("jdbc:mysql://" + host + ":" + porta + "/" + bd,usuario,senha);
            return c;
        }
        catch (Exception e){
            Warning warning = new Warning(0,"[ERRO] Banco de dados.");
            warning.setVisible(true);
        }
        return null;
    }
}