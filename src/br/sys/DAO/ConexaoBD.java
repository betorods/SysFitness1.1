package br.sys.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Alberto
 */
public class ConexaoBD {
     public static Connection conexao() throws ClassNotFoundException{
        try {
           //  Class.forName("org.mysql.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/sysfitness","root","12345");
            // Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Academia","postgres","1234");
            // JOptionPane.showMessageDialog(null, "Conectado com sucesso:");
             return con;
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
            return null;
        //    throw new RuntimeException(ex);
        }
    }

 
}
