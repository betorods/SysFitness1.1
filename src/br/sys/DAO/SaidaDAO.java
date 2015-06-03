package br.sys.DAO;

/**
 *
 * @author Alberto
 */
import br.sys.Bean.Saida;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.sys.DAO.ConectaBanco;
import javax.swing.JOptionPane;

public class SaidaDAO {
       ConectaBanco conecta;
    public SaidaDAO() {
        conecta = new ConectaBanco();
        conecta.conexao();

    }

    public String inserirSaida(Saida saida) {
        try {
            PreparedStatement preStat;
            preStat = conecta.connection.prepareStatement("insert into saida(dataEntrada,valor,id_funcionario,descricao) VALUES (?,?,?,?)");

            preStat.setString(1, saida.getDataSaida());
            preStat.setFloat(2, saida.getValor());
            preStat.setInt(3, saida.getId_funcionario());
            preStat.setString(4, saida.getDescricao());
           
            preStat.execute();
            // Resposta para o Cadastro
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Você digitou algo errado");
            throw new RuntimeException(e);
        }
        return null;
    }

    
}
