package com.Eletronics.services.renderers;

import com.Eletronics.model.Pedido;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class RenderizadorTres extends DefaultListCellRenderer implements ListCellRenderer<Object> {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean hasFocus) {
        Pedido pedido = (Pedido) value;
        setText(pedido.getQuantidade()+" x "+pedido.getProduto().getValor()+" = R$"+pedido.getValor());
        Image imagem = pedido.getProduto().getImagem().getScaledInstance(46, 60, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(imagem));
        setIconTextGap(10);
        
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
