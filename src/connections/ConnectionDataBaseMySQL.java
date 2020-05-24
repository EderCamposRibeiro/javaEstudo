package connections;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Realizar conexão com o banco de dados
 * Conexão  MySQL para o banco ???????
 * @author ederc
 *
 */

public class ConnectionDataBaseMySQL {
	
	private static String banco = "jdbc:mysql://localhost:3306/aprendendojsp?autoReconnect=true";
	private static String user = "admin";
	private static String password = "admin";
	private static Connection connection = null;
	
	/*
	 * Chamada Estática do Método conectar()
	 */
	static {
		conectar();
	}
	
	/*
	 * Construtor da Classe SingleConnection()
	 * Chama o Método conectar()
	 */
	public ConnectionDataBaseMySQL() {
		conectar();
	}

	/*
	 * Método conectar()
	 * Provê os Meios de Conexão ao BD
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
	 * Método getConnection()
	 * Método responsável por fazer uso da conexão na Aplicação
	 */
	public static Connection getConnection() {
		return connection;
	}
	
}




















