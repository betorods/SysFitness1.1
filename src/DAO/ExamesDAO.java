package DAO;

/**
 *
 * @author Alberto
 */
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Bean.Exames;

public class ExamesDAO {
    
    ConectaBanco conecta;
    public ExamesDAO(){
        conecta = new ConectaBanco();
        conecta.conexao();
    }
    
 public void inserirExames(Exames exames){
      try {
            PreparedStatement preStat;
            preStat = conecta.connection.prepareStatement("Insert into examesmedicos(cpf_aluno,nome_medico,crm,datarealizacao,datavalidade,recomendacoes,objetivo) values(?,?,?,?,?,?,?)");
            preStat.setString(1, exames.getCpf());
            preStat.setString(2, exames.getNomeMedico());
            preStat.setInt(3, exames.getCrm());
            preStat.setString(4, exames.getDataRealizacaoExame());
            preStat.setString(5, exames.getDataValidadeExame());
            preStat.setString(6, exames.getRecomendacoes());
            preStat.setString(7, exames.getObjetivo());
 
            preStat.execute();   
            //JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
        
        }
        catch (SQLException e){  
             throw new RuntimeException(e); 
       }
 }
}
