package com.Eletronics.services.renderers;

import com.Eletronics.model.Customer;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class CustomRendererFive extends DefaultListCellRenderer implements ListCellRenderer<Object> {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean hasFocus) {
        Customer customer = (Customer) value;
        setText(customer.getName()+" ("+customer.getUserId()+")");
        
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
