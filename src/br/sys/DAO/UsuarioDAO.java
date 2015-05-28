package br.sys.DAO;

//import controle.Autenticavel;
//import modelo.Funcionario;
import br.sys.Bean.Alunos;
import br.sys.Bean.Usuario;
import br.sys.Bean.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import br.sys.DAO.ConexaoBD;
import javax.swing.JOptionPane;

public class UsuarioDAO extends AbstractDAO<Funcionario> {

    public static String inserirFornecedor(Usuario f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        private List<Funcionario> lista = new ArrayList<Funcionario>();
        PreparedStatement ptmt;
        ResultSet rs;
        private Connection con;
        

    public static String inserirFunc(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static String inserirCliente(Usuario c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	
	public UsuarioDAO() {
		super();
		lista = new ArrayList<Funcionario>();
                 setCon(con);
	}
        
        
        public String inserirFunc(Funcionario funcionario) {
        String sql = "insert into tbfuncionario (Nome, CPF, Endereco, Cidade, Estado, Telefone, Funcao) VALUES (?,?,?,?,?,?,?)";
       // System.out.println("Pesquisa realizada na inserção:");
       
        try {
            
            ptmt = getCon().prepareStatement(sql);
            ptmt.setString(1, funcionario.getNome());
            ptmt.setString(2, funcionario.getCpf());
            ptmt.setString(3, funcionario.getEndereco());
            ptmt.setString(4, funcionario.getCidade());
            ptmt.setString(5, funcionario.getEstado());
            ptmt.setString(6, funcionario.getTelCelular());
            ptmt.setString(7, funcionario.getFuncao());
            
            ptmt.execute();
          //  ptmt.close();
        }
        catch (SQLException e){  
         throw new RuntimeException(e); 
       }
        return null;
     }

         public String inserirCliente(Alunos cliente) {
        String sql = "insert into tbcliente (Nome, CPF, Endereco, Cidade, Estado, Telefone) VALUES (?,?,?,?,?,?)";
       // System.out.println("Pesquisa realizada na inserção:");
       
        try {
            
            ptmt = getCon().prepareStatement(sql);
            ptmt.setString(1, cliente.getNome());
        //    ptmt.setString(2, cliente.getCpf());
            ptmt.setString(3, cliente.getEndereco());
            ptmt.setString(4, cliente.getCidade());
            ptmt.setString(5, cliente.getEstado());
            ptmt.setString(6, cliente.getTelCelular());
            
            ptmt.execute();
          //  ptmt.close();
        }
        catch (SQLException e){  
         throw new RuntimeException(e); 
       }
        return null;
     }
    /*
     public String inserirFornecedor(Fornecedor f) {
        String sql = "insert into tbfornecedor (Nome, Cnpj, Endereco, Cidade, Estado, Telefone) VALUES (?,?,?,?,?,?)";
       // System.out.println("Pesquisa realizada na inserção:");
       
        try {
            
            ptmt = getCon().prepareStatement(sql);
            ptmt.setString(1, f.getNome());
            ptmt.setString(2, f.getCNPJ());
            ptmt.setString(3, f.getEndereco());
            ptmt.setString(4, f.getCidade());
            ptmt.setString(5, f.getEstado());
            ptmt.setString(6, f.getTelefone());
            
            ptmt.execute();
          //  ptmt.close();
        }
        catch (SQLException e){  
         throw new RuntimeException(e); 
       }
        return null;
     }*/
         
         
	public List<Funcionario> getLista(Funcionario funcionario) {
		return lista;
	}

	public List<Funcionario> getLista() {
		return lista;
	}

	public void adicionar(Funcionario funcionario) {
		lista.add(funcionario);
	}
        
       
    public Connection getCon() {
            return con;
        }

        public void setCon(Connection con) {
            this.con = con;
        }
        
        public ResultSet getResultado() {  
             return rs;  
        } 
        
}
