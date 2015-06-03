package br.sys.DAO;

/**
 *
 * @author Alberto
 */
import br.sys.Bean.Login;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class LoginDAO {
    ConectaBanco conecta;

    public LoginDAO() {
        conecta = new ConectaBanco();
        conecta.conexao();
    }
    
    public void inserirLogin(Login login) {
        try {
            PreparedStatement preStat;
            preStat = conecta.connection.prepareStatement("Insert into login(login, senha, id_usuario_login, verificador) values(?,?,?,?)");

            preStat.setString(1, login.getLogin());
            preStat.setString(2, login.getSenha());
            preStat.setInt(3, login.getId_usuario_login());
            preStat.setString(4, login.getVerificador());
            preStat.execute();
            // Resposta para o Cadastro
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
