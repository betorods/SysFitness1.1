package br.sys.DAO;

/**
 *
 * @author Alberto
 */
import br.sys.Bean.Entrada;
import br.sys.Bean.Funcionario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.sys.DAO.ConectaBanco;
import javax.swing.JOptionPane;

public class EntradaDAO {
     ConectaBanco conecta;
    public EntradaDAO() {
        conecta = new ConectaBanco();
        conecta.conexao();

    }

    public String inserirEntrada(Entrada entrada) {
        try {
            PreparedStatement preStat;
            preStat = conecta.connection.prepareStatement("insert into entrada(dataEntrada,valor,id_funcionario,descricao) VALUES (?,?,?,?)");

            preStat.setString(1, entrada.getDataEntrada());
            preStat.setFloat(2, entrada.getValor());
            preStat.setInt(3, entrada.getId_funcionario());
            preStat.setString(4, entrada.getDescricao());
           
            preStat.execute();
            // Resposta para o Cadastro
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Você digou algo errado");
            throw new RuntimeException(e);
        }
        return null;
    }

}
