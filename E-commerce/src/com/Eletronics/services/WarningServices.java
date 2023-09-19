/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Eletronics.services;

import com.Eletronics.model.Customer;
import com.Eletronics.view.AdministratorManagement;
import com.Eletronics.view.CustomerMangement;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author pedro
 */
public class WarningServices {
    
    public static void generateWarning(String text, JTextField textTwo){
        textTwo.setText(text);
    }
    public static void generateInput(int function, JLabel textOne, JTextField textTwo){
        textOne.setText("INFORME SEU NOME:");
        textTwo.setEditable(true);
    }
    
    public static boolean closeWarning(int function, String text){
        if (function == 0)
            return true;
        else if (!(text.length()<3)) {
            Customer customer = CustomerServices.getCustomer("recrutador");
            if (function == 1){
                CustomerMangement products = new CustomerMangement(customer);
                products.setVisible(true);
            } else {
                AdministratorManagement management = new AdministratorManagement();
                management.setVisible(true);
            }
            return true;
        }
        return false;
    }
}
