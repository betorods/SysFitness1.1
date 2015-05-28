package br.sys.DAO;

import br.sys.Bean.Turma;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alberto
 */
public class TurmaDAO {
    
    ConectaBanco conecta;

    public TurmaDAO() {
        conecta = new ConectaBanco();
        conecta.conexao();
    }

    public void InserirTurma(Turma turma){
        try {
            PreparedStatement preStat;
            preStat = conecta.connection.prepareStatement("Insert into turma(id_turma, id_funcionario, capacidade, horario, turno) values(?,?,?,?,?)");
            preStat.setInt(1, turma.getCodTurma());
            preStat.setInt(2, turma.getMatriculaProfessor());
            preStat.setInt(3, turma.getCapacidade());
            preStat.setInt(4, turma.getHorario());
            preStat.setString(5, turma.getTurno());

            preStat.execute();
    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!","Cadastro com sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        
    }
    
}
