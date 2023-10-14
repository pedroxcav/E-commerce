package com.Eletronics.services.tools;

import com.Eletronics.services.CarrinhoServices;
import com.Eletronics.services.CompraServices;
import com.Eletronics.services.EnderecoServices;
import com.Eletronics.services.PedidoServices;
import com.Eletronics.services.ProdutoServices;
import com.Eletronics.services.VendaServices;
import java.util.Random;

public class GeradorAleatorio {
    
    public static String gerarSenha() {
        String letras[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","W","Z"};
        String caracteres[] = {"@","#","$","%","&","*"};
        Random random = new Random();
        
        String senha = "";
        senha += letras[random.nextInt(letras.length)];
        for (int i=1; i <= 6; i++)
            senha += String.valueOf(random.nextInt(10));
        senha += caracteres[random.nextInt(caracteres.length)];
        return senha;
    }
    
    public static String gerarCarrinhoID() {
        String letras[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","W","Z"};
        Random random = new Random();
        String ID_Carrinho;
        do {
            ID_Carrinho = "";
            ID_Carrinho += letras[random.nextInt(10)];
            for (int i=1; i<=4; i++) {
                ID_Carrinho += String.valueOf(random.nextInt(10));
            }
        } while (CarrinhoServices.verificar(ID_Carrinho));
        return ID_Carrinho;
    }
    
    public static String gerarCompraID() {
        String letras[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","W","Z"};
        Random random = new Random();
        String ID_Compra;
        do {
            ID_Compra = "";
            ID_Compra += letras[random.nextInt(10)];
            for (int i=1; i<=4; i++) {
                ID_Compra += String.valueOf(random.nextInt(10));
            }
        } while (CompraServices.verificar(ID_Compra));
        return ID_Compra;
    }
    
    public static String gerarProdutoID() {
        String letras[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","W","Z"};
        Random random = new Random();
        String ID_Produto;
        do {
            ID_Produto = "";
            ID_Produto += letras[random.nextInt(10)];
            for (int i=1; i<=4; i++) {
                ID_Produto += String.valueOf(random.nextInt(10));
            }
        } while (ProdutoServices.verificar(ID_Produto));
        return ID_Produto;
    }
    
    public static String gerarPedidoID() {
        String letras[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","W","Z"};
        Random random = new Random();
        String ID_Pedido;
        do {
            ID_Pedido = "";
            ID_Pedido += letras[random.nextInt(10)];
            for (int i=1; i<=4; i++) {
                ID_Pedido += String.valueOf(random.nextInt(10));
            }
        } while (PedidoServices.verificar(ID_Pedido));
        return ID_Pedido;
    }
    
    public static String gerarEnderecoID() {
        String letras[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","W","Z"};
        Random random = new Random();
        String ID_Endereco;
        do {
            ID_Endereco = "";
            ID_Endereco += letras[random.nextInt(10)];
            for (int i=1; i<=4; i++) {
                ID_Endereco += String.valueOf(random.nextInt(10));
            }
        } while (EnderecoServices.verificar(ID_Endereco));
        return ID_Endereco;
    }
    
    public static String gerarVendaID() {
        String letras[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","W","Z"};
        Random random = new Random();
        String ID_Venda;
        do {
            ID_Venda = "";
            ID_Venda += letras[random.nextInt(10)];
            for (int i=1; i<=4; i++) {
                ID_Venda += String.valueOf(random.nextInt(10));
            }
        } while (VendaServices.verificar(ID_Venda));
        return ID_Venda;
    }
}
