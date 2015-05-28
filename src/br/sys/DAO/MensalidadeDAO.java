package br.sys.DAO;

import br.sys.Bean.Mensalidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alberto
 */
public class MensalidadeDAO {

    ConectaBanco conecta;

    public MensalidadeDAO() {
        conecta = new ConectaBanco();
        conecta.conexao();
    }

    public void InserirMensalidade(Mensalidade mensalidade) {
        try {
            PreparedStatement preStat;
            preStat = conecta.connection.prepareStatement("Insert into pagamento_mensalidade(cpf_aluno,valor,data_vencimento,data_pagamento) values(?,?,?,?)");
            preStat.setString(1, mensalidade.getCpf());
            preStat.setFloat(2, mensalidade.getValor());
            preStat.setString(3, mensalidade.getData_vencimento());
            preStat.setString(4, mensalidade.getData_pagamento());

            preStat.execute();
            JOptionPane.showMessageDialog(null, "Pagamento Realizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
        
}
