package connections;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Realizar conexão com o banco de dados
 * Conexão  Postgresql para o banco curso-jsp
 * @author ederc
 *
 */

public class ConnectionDataBase2 {
	
	private static String banco = "jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true";
	private static String user = "postgres";
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
	public ConnectionDataBase2() {
		conectar();
	}

	/*
	 * Método conectar()
	 * Provê os Meios de Conexão ao BD
	 */
	private static void conectar() {
		try {
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
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




















