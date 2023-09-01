package IntegracaoBD;

public class TesteBD {
    public static void main(String[] args) {
        DAOUsuario dao = new DAOUsuario();
        
        dao.listar();
        
        dao.adicionar();
        dao.listar();
        
        dao.atualizar();
        dao.listar();
        
        dao.apagar();
        dao.listar();
    }
  
}
