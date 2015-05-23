package DAO;

import DAO.FabricarConexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO<T> {

	protected Connection conn;

	public AbstractDAO() {
		try {
			conn = FabricarConexao.getInstance().getConexao();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public abstract List<T> getLista(T objeto);

	public abstract List<T> getLista();

	public abstract void adicionar(T objeto);
	
}
