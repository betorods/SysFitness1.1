/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Alberto
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FabricarConexao {
	
	private static final String DRIVER_NAME = "org.gjt.mm.mysql.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/sysfitness";
	private static final String USUARIO = "root";
	private static final String SENHA = "12345";
	
	private static FabricarConexao fabricarConexao = null;

	public FabricarConexao() {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public Connection getConexao() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(URL, USUARIO, SENHA);
                JOptionPane.showMessageDialog(null, "Conectado com sucesso:");
		return conn;
	}

	public static FabricarConexao getInstance() {
		if (fabricarConexao == null) {
			fabricarConexao = new FabricarConexao();
		}
		return fabricarConexao;
	}
	
}
