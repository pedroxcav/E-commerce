/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Eletronics.services;

/**
 *
 * @author pedro
 */
public class WarningServices {
    
    public void generateWarning(int function, String text, javax.swing.JLabel textOne, javax.swing.JTextField textTwo){
        if (function == 0)
            textTwo.setText(text);
        else {
            textOne.setText("INFORME SEU NOME:");
            textTwo.setEditable(true);
        }
    }
    
    public boolean closeWarning(int function, String text){
        if (function == 0)
            return true;
        else
            return text.length()<4 ? false : true;
    }
}
