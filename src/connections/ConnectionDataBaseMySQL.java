package connections;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Realizar conex�o com o banco de dados
 * Conex�o  MySQL para o banco ???????
 * @author ederc
 *
 */

public class ConnectionDataBaseMySQL {
	
	private static String banco = "jdbc:mysql://localhost:3306/aprendendojsp?autoReconnect=true";
	private static String user = "admin";
	private static String password = "admin";
	private static Connection connection = null;
	
	/*
	 * Chamada Est�tica do M�todo conectar()
	 */
	static {
		conectar();
	}
	
	/*
	 * Construtor da Classe SingleConnection()
	 * Chama o M�todo conectar()
	 */
	public ConnectionDataBaseMySQL() {
		conectar();
	}

	/*
	 * M�todo conectar()
	 * Prov� os Meios de Conex�o ao BD
	 */
	private static void conectar() {
		try {
			if (connection == null) {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(banco, user, password);
				connection.setAutoCommit(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao Conectar com o Banco de Dados" + e.getMessage());
		}
	}
	
	/*
	 * M�todo getConnection()
	 * M�todo respons�vel por fazer uso da conex�o na Aplica��o
	 */
	public static Connection getConnection() {
		return connection;
	}
	
}




















