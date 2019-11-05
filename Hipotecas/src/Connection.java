import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public final class Connection {

	private static Connection instancia = null;
	private static Context initContext;
	private static Context envContext;
	private static DataSource DatSrc;

	private Connection() {

		try {

			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			DatSrc = (DataSource) envContext.lookup("jdbc/HIPOTECA");

		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	public static Connection getInstance() {

		if (instancia == null) {
			synchronized (Connection.class) {

				if (instancia == null) {
					instancia = new Connection();
				}

			}

		}

		return instancia;
	}
	
	public java.sql.Connection getConnection() throws SQLException{
		
		return DatSrc.getConnection();
	}

}