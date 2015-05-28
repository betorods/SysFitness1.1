package br.sys.DAO;

import br.sys.Bean.Funcionario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.sys.DAO.ConectaBanco;
import javax.swing.JOptionPane;

/**
 *
 * @author Alberto
 */
public class FuncionarioDAO {

    ConectaBanco conecta;
    public FuncionarioDAO() {
        conecta = new ConectaBanco();
        conecta.conexao();

    }

    public String inserirFuncionario(Funcionario funcionario) {
        try {
            PreparedStatement preStat;
            preStat = conecta.connection.prepareStatement("insert into funcionario(nome,dataNasc,localNasc,cpf,rg,telFixo,telCelular,mae,pai,endereco,numero,bairro,cep,cidade,sexo,estado,funcao,salario) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            preStat.setString(1, funcionario.getNome());
            preStat.setString(2, funcionario.getDataNasc());
            preStat.setString(3, funcionario.getLocalNasc());
            preStat.setString(4, funcionario.getCpf());
            preStat.setString(5, funcionario.getRg());
            preStat.setString(6, funcionario.getTelFixo());
            preStat.setString(7, funcionario.getTelCelular());
            preStat.setString(8, funcionario.getMae());
            preStat.setString(9, funcionario.getPai());
            preStat.setString(10, funcionario.getEndereco());
            preStat.setInt(11, funcionario.getNumero());
            preStat.setString(12, funcionario.getBairro());
            preStat.setString(13, funcionario.getCep());
            preStat.setString(14, funcionario.getCidade());
            preStat.setString(15, funcionario.getSexo());
            preStat.setString(16, funcionario.getEstado());
            preStat.setString(17, funcionario.getFuncao());
            preStat.setFloat(18, funcionario.getSalario());
            preStat.execute();
            // Resposta para o Cadastro
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String consultaFuncionario(Funcionario funcionario) {
        //    boolean testa = false;  
        try {
            PreparedStatement preStat;
            preStat = conecta.connection.prepareStatement("select * from funcionario where nome like ?");
            preStat.setString(1, funcionario.getNome() + "%");// %para quando apagar trazer de volta as informações do BD.
            preStat.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JOptionPane.showMessageDialog(null, "Buscar feita com sucesso");

        return null;
    }

    /*   public boolean consultarDados(){  
        
     boolean testa = false;  
     // System.out.println("Pesquisa realizada na inserção:");
           
     try {  
     String sql = "select * from tbfuncionario where Nome like ?";  
     rs = ptmt.executeQuery(sql);  
           
     if (rs.next()){
     testa = true;
     }else{
     testa = false;
     }  
           
     }catch (SQLException e){
     System.out.println("Erro na inserção:" + e.getMessage());
     }  
        
     return testa;  
     }
    
     public boolean excluirDados(Funcionario funcionario){  
     boolean testa = false;  
     try {  
     //  System.out.println("Arquivo deletado:");
     String sql = "delete from tbfuncionario where Nome like ?"; 
     ptmt = getCon().prepareStatement(sql);
     ptmt.setString(1, funcionario.getNome()+"%");// %para quando apagar trazer de volta as informações do BD.
     ptmt.executeUpdate();
     int linhas = ptmt.executeUpdate(sql); 
        
     if (linhas > 0){  
     testa = true;  
               
     }else{  
     testa = false; 
     }
     }catch (SQLException e){
     System.out.println("Erro na exclusão:" + e.getMessage());
     }  
     return testa;  
     }
    
     public boolean alterarDados(Funcionario funcionario){  
        
     boolean testa = false;  
     
     try {  
     String sql = "update tbfuncionario set Nome = ? where Nome = ? "; 
     ptmt = getCon().prepareStatement(sql);
     ptmt.setString(1, funcionario.getNome());
     ptmt.setString(2, funcionario.getCpf());
     ptmt.setString(3, funcionario.getFuncao());
     ptmt.setString(4, funcionario.getEndereco());
     ptmt.setString(5, funcionario.getCidade());
     ptmt.setString(6, funcionario.getEstado());
     ptmt.setString(7, funcionario.getTelCelular());
            
     ptmt.executeUpdate();
         
     int linhas = ptmt.executeUpdate(sql);  
           
     if (linhas > 0)  
     testa = true;
     else  
     testa = false;  
  
     }catch (SQLException e){
     System.out.println("Erro na inserção:" + e.getMessage());
     }  
     return testa;  
     }
    
     public Connection getCon() {
     return con;
     }

     public void setCon(Connection con) {
     this.con = con;
     }
        
     public ResultSet getResultado() {  
     return rs;  
     }     */
}
