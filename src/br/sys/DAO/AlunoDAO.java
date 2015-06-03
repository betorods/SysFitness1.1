package br.sys.DAO;

import br.sys.Bean.Alunos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

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
            preStat.setInt(17, alunos.getVerificador());
            preStat.execute();
            // Resposta para o Cadastro
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //   return "index";
    }

    /*public void pesquisaUsuarioCpf(Alunos aluno) {

        //String sql = ;
        try {
            PreparedStatement preStat;
            preStat = conecta.connection.prepareStatement("Select id_usuario, nome, cpf, endereco from usuario where cpf like ?");
        //

            preStat.setString(1, aluno.getCpf() + "%");// %para quando apagar trazer de volta as informações do BD.
            preStat.executeQuery();
            TabelaUsuario.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }*/

}
