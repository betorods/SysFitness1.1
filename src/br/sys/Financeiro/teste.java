package br.sys.Financeiro;

import br.sys.DAO.ConexaoBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class teste {

    public static void main(String args[]) throws ClassNotFoundException {
       double total = 0;
        try {
            Connection con = ConexaoBD.conexao();
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery("SELECT sum(valor)AS total FROM pagamento_mensalidade WHERE data_pagamento >= '2015-01-01' AND data_pagamento <= '2015-05-27';");
            while (rs.next()) {
                total = rs.getDouble("total");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "TOTAL DE DESPESAS R$ : " + total);

    }
}

