package br.sys.DAO;
import br.sys.Bean.PagamentoDeSalario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PagamentoDeSalarioDAO {
    ConectaBanco conecta;
    
    public PagamentoDeSalarioDAO(){
        conecta = new ConectaBanco();
        conecta.conexao();
    }


    public void inserirSalario(PagamentoDeSalario pagamentoDeSalario){
         try {
            PreparedStatement preStat;
            preStat = conecta.connection.prepareStatement("Insert into pagamento_funcionario(mat_funcionario,meses,valor,data_pagamento) values(?,?,?,?)");
            preStat.setString(1, pagamentoDeSalario.getMatriculaFuncionario());
            preStat.setString(2, pagamentoDeSalario.getMeses());
            preStat.setFloat(3, pagamentoDeSalario.getValor());
            preStat.setString(4, pagamentoDeSalario.getDataDoPagamento());
           
            preStat.execute();   
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
        
        }
        catch (SQLException e){  
             throw new RuntimeException(e); 
       }
 
    
        
    }
    
}
