/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Eletronics.services;

import com.Eletronics.model.Product;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author pedro
 */
public class CustomRendererTwo extends DefaultListCellRenderer implements ListCellRenderer<Object> {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean hasFocus) {
        Product product = (Product) value;
        setText(product.getName().toUpperCase()+"   R$"+product.getPrice());
        
        if (isSelected){
            setBackground(new Color(55, 105, 140));
            setForeground(new Color(255,255,255));
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        
        setEnabled(true);
        setFont(list.getFont());
        
        return this;
    }
}
