/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Eletronics.services;

import java.util.Random;

/**
 *
 * @author pedro
 */
public class PasswordGenerator {
    
    public String generatePassword(){
        String[] letters1 = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","x","y","w","z"};
        String[] letters2 = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","s","T","U","V","X","Y","W","Z"};
        String[] symbols = {"!","@","#","$","%","&","*","(",")","[","]","{","}","/","?","<",">","§","£"};
        String password;
        Random ra = new Random();
        int number = ra.nextInt(letters1.length);
        password = letters1[number];
        number = ra.nextInt(letters2.length);
        password = password + letters2[number];
        for(int i=1;i<=5;i++){
            number = ra.nextInt(10);
            password = password + number;
        }
        number = ra.nextInt(symbols.length);
        password = password + symbols[number];
        return password;
    }
}
