package IntegracaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DAOUsuario {
    
    public void adicionar(){
        String nome;
        String senha;        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite o nome do usuario: ");
        nome = sc.nextLine();
        System.out.println("Digite a senha do usuario: ");
        senha = sc.nextLine();
        
        //1: Definir o comando SQL
        String sql = "INSERT INTO tb_usuarios(nome, senha) VALUES (?, ?)";

        //2: Abrir uma conexão
        ConexaoBD cbd = new ConexaoBD();
        
        try (Connection c = cbd.obtemConexao()){
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            
            //4: Preenche os dados faltantes
            ps.setString(1, nome);
            ps.setString(2, senha);
            
            //5: Executa o comando
            ps.execute();
        }

        catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void atualizar(){
        String nome;
        String nomenovo;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite o nome atual do usuario: ");
        nome = sc.nextLine();       
        System.out.println("Digite o novo nome do usuario: ");
        nomenovo = sc.nextLine();
                 
        //1: Definir o comando SQL
        String sql = "UPDATE tb_usuarios SET nome = ? WHERE nome = ?";

        //2: Abrir uma conexão
        ConexaoBD cbd = new ConexaoBD();
        try (Connection c = cbd.obtemConexao()){

            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);

            //4: Preenche os dados faltantes
            ps.setString(1, nomenovo);
            ps.setString(2, nome);

            //5: Executa o comando
            ps.execute();
        }

        catch (Exception e){
            e.printStackTrace();    
        }   
        
    }

    public void listar(){
        String nome;
        String senha;
        
        //1: Definir o comando SQL
        String sql = "SELECT * FROM tb_usuarios";

        //2: Abrir uma conexão
        ConexaoBD cbd = new ConexaoBD();

        try (Connection c = cbd.obtemConexao()){
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);

            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();

            if(rs.next() == false){
                System.out.println("DB vazio");
            } else{
                //5: itera sobre o resultado
                do{
                    nome = rs.getString("nome");
                    senha = rs.getString("senha");

                    System.out.println("===========================");
                    System.out.println("Nome: " + nome);
                    System.out.println("Senha: " + senha);
                    System.out.println("===========================");
                } while (rs.next());
            }
        }

        catch (Exception e){
            e.printStackTrace();
        }        
        
    }
    
    public void apagar (){
        String nome;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite o nome do usuario: ");
        nome = sc.nextLine();             
                
        //1: Definir o comando SQL  
        String sql = "DELETE FROM tb_usuarios WHERE nome = ?";

        //2: Abrir uma conexão
        ConexaoBD cbd = new ConexaoBD();

        try (Connection c = cbd.obtemConexao()){
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);

            //4: Preenche os dados faltantes
            ps.setString(1, nome);

            //5: Executa o comando
            ps.execute();
        }

        catch (Exception e){
            e.printStackTrace();
        }
        
    }
}