package DAO;

import Bean.Alunos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alberto
 */
public class AlunoDAO {
           
    ConectaBanco conecta;
    public AlunoDAO() {
        conecta = new ConectaBanco();
        conecta.conexao();
    }

     /*   public List<Alunos> getLista(Alunos aluno) {
                String sql = "select * from tbcliente where Id_Produto, Nome like ?, ?";
		try {
			ptmt = conecta.prepareStatement(sql);
      			ptmt.setString(1, "%" + aluno.getId_cliente()+ "%");
			ptmt.setString(2, "%" + aluno.getNome()+ "%");
			rs = ptmt.executeQuery();
			while (rs.next()) {
		//		funcionario = new Funcionario();
				clienteLista.add(cliente);
			}
			rs.close();
			ptmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
            return clienteLista;
	}

	public List<Cliente> getLista() {
		return clienteLista;
	}*/
    public void inserirAlunos(Alunos alunos) {
        try {
            PreparedStatement preStat;
            preStat = conecta.connection.prepareStatement("Insert into usuario(nome,dataNasc,localNasc,cpf,rg,telFixo,telCelular,mae,pai,endereco,bairro,cep,cidade,sexo,estado,foto) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        
            preStat.setString(1, alunos.getNome());
            preStat.setString(2, alunos.getDataNasc());
            preStat.setString(3, alunos.getLocalNasc());
            preStat.setString(4, alunos.getCpf());
            preStat.setString(5, alunos.getRg());
            preStat.setString(6, alunos.getTelFixo());
            preStat.setString(7, alunos.getTelCelular());
            preStat.setString(8, alunos.getMae());
            preStat.setString(9, alunos.getPai());
            preStat.setString(10, alunos.getEndereco());
            preStat.setString(11, alunos.getBairro());
            preStat.setString(12, alunos.getCep());
            preStat.setString(13, alunos.getCidade());
            preStat.setString(14, alunos.getSexo());
            preStat.setString(15, alunos.getEstado());
            preStat.setString(16, alunos.getFoto());
            preStat.execute();   
            // Resposta para o Cadastro
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
        
        }
        catch (SQLException e){  
             throw new RuntimeException(e); 
       }
         //   return "index";
    }
    
    
}
