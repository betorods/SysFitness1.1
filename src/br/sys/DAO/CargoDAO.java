package br.sys.DAO;

import br.sys.Bean.Cargo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Alberto
 */
public class CargoDAO {

    ConectaBanco conecta;

    public CargoDAO() {
        conecta = new ConectaBanco();
        conecta.conexao();
    }

    public void inserirCargo(Cargo cargo) {
        try {
            PreparedStatement preStat;
            preStat = conecta.connection.prepareStatement("Insert into cargo(descricao,funcao,id_funcionario_cargo,salario) values(?,?,?,?)");

            preStat.setString(1, cargo.getDescricao());
            preStat.setString(2, cargo.getFuncao());
            preStat.setInt(3, cargo.getId_funcionario_cargo());
            preStat.setFloat(4, cargo.getSalario());
            preStat.execute();
            // Resposta para o Cadastro
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
