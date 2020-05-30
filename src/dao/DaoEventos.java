package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Eventos;
import connections.ConnectionDataBase;

public class DaoEventos {
	
	private Connection connection;
	
	/*
	 * Construtor DaoUsuario()
	 * Recebe um Objeto connectio da Classe ConnectionDatabase()
	 */

	public DaoEventos() {
		connection = ConnectionDataBase.getConnection();
	}
	/*
	 * M�todo salvar()
	 * Respons�vel Por Fazer a Inser��o de Dados (INSERT) no BD
	 * @param Eventos eventos = Objeto Usu�rio da Classe Eventos
	 */
	public void salvar(Eventos eventos) {
		try {
			String sql = "INSERT INTO eventos(id, dataevento, descricao) "
					+ " VALUES(?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1, eventos.getId());
			insert.setString(2, eventos.getDataevento());
			insert.setString(3, eventos.getDescricao());
			insert.execute();
			connection.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	/*
	 * M�todo listar()
	 * Respons�vel Por Listar Todos os Usu�rios do Sistema
	 */
	
	public List<Eventos> listar(String descricaoConsulta) throws SQLException {
		String sql = "SELECT * FROM eventos WHERE descricao like '%"+ descricaoConsulta+"%' ";
		return consultarEventos(sql);
	}
	
	public List<Eventos> listar() throws Exception {
		
		String sql = "SELECT * FROM eventos";
		return consultarEventos(sql);	
	}

	private List<Eventos> consultarEventos(String sql) throws SQLException {
		List<Eventos> listar = new ArrayList<Eventos>();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Eventos eventos = new Eventos();
				eventos.setId(resultSet.getLong("id"));
				eventos.setDataevento(resultSet.getString("dataevento"));
				eventos.setDescricao(resultSet.getString("descricao"));
				listar.add(eventos);
			}
		return listar;	
	}
	

	public List<Eventos> getEventos() throws Exception {
		List<Eventos> listar = new ArrayList<Eventos>();
		
		String sql = "select * from eventos";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Eventos evento = new Eventos();
				evento.setId(resultSet.getLong("id"));
				evento.setDataevento(resultSet.getString("dataevento"));
				evento.setDescricao(resultSet.getString("descricao"));
				listar.add(evento);
			}
		return listar;	
	}	
	
	/*
	 * M�todo delete()
	 * Respons�vel Por Fazer a Exclus�o (Delete) no BD
	 * @param String id = Atributo ID do Usu�rio
	 */
	public void delete(String id) {
		if (id != null && !id.isEmpty()) {
			try {
				String sql = "DELETE FROM eventos WHERE id = '"+ id +"";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.execute();
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	/*
	 * M�todo consultar()
	 * Respons�vel Por Fazer Consultas (SELECT) no BD
	 * @param String id = Atributo ID do Usu�rio
	 */
	public Eventos consultar(String id) throws Exception {
		String sql = "SELECT * FROM eventos WHERE id = '"+ id +"";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				Eventos evento = new Eventos();
				evento.setId(resultSet.getLong("id"));
				evento.setDataevento(resultSet.getString("dataevento"));
				evento.setDescricao(resultSet.getString("descricao"));
				return evento;
			}
		return null; 
	}
	
	/*
	 * M�todo validarLogin
	 * Respons�vel Por Validar Login(N�o Pode Existir 1 Mesmo Login Para 2 Usu�rios Diferentes)
	 * @param String login = Atributo Login do Usu�rio
	 */
	public boolean validarLogin(String id) throws Exception {
		String sql = "SELECT COUNT(1) as qtde FROM eventos WHERE id = '"+ id +"'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt("qtde") <= 0;
			}
		return false;
	}
	
	
	/*
	 * M�todo atualizar()
	 * M�todo Respons�vel Por Atualizar os Dados (UPDATE) no BD
	 * @param Eventos eventos = Objeto eventos da Classe Eventos
	 */
	public void atualizar(Eventos eventos) {
		try {
			StringBuilder sql = new StringBuilder();
			
			sql.append(" UPDATE eventos SET dataevento = ?, descricao = ?");
			sql.append(" WHERE id = "+ eventos.getId());
			PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setString(1, eventos.getDataevento());
			preparedStatement.setString(2, eventos.getDescricao());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}

























