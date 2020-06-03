package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Projeto;
import beans.Series;
import connections.ConnectionDataBase;

public class DaoGanttChart {
	
	private Connection connection;
	
	public DaoGanttChart() {
		connection = ConnectionDataBase.getConnection();
	}
	
	public void atualizar(Series series) throws Exception{
		String sqlUpdate = "UPDATE public.series SET "
						+   "datainicial='"+series.getDatainicial()+"'"
						+   ", datafinal='"+series.getDatafinal()+"'"
						+   "   WHERE id= "+series.getId() 
						+   " and projeto= "+series.getProjeto(); 
		connection.prepareStatement(sqlUpdate).executeUpdate();	
		connection.commit();
	}
	
	public List<Projeto> getProjetos() throws Exception{
		
		List<Projeto> projetos = new ArrayList<Projeto>();
		
		String sqlProjetos = "select * from projeto";
		PreparedStatement statementProjetos = connection.prepareStatement(sqlProjetos);
		ResultSet resultSetProjetos = statementProjetos.executeQuery();
		
		while (resultSetProjetos.next()) {
			Projeto projeto = new Projeto();
			projeto.setId(resultSetProjetos.getLong("id"));
			projeto.setNome(resultSetProjetos.getString("nome"));
			
			String sqlSeries = "select * from series where projeto = " + resultSetProjetos.getLong("id");
			PreparedStatement statementSeries = connection.prepareStatement(sqlSeries);
			ResultSet resultSetSeries = statementSeries.executeQuery();
			
			List<Series> series = new ArrayList<Series>();
			
			while (resultSetSeries.next()) {
				Series serie = new Series();
				serie.setId(resultSetSeries.getLong("id"));
				serie.setNome(resultSetSeries.getString("nome"));
				serie.setDatainicial(resultSetSeries.getString("datainicial"));
				serie.setDatafinal(resultSetSeries.getString("datafinal"));
				serie.setProjeto(resultSetSeries.getLong("projeto"));
				
				series.add(serie);
			}
			
			projeto.setSeries(series);
			
			projetos.add(projeto);
			
		}
		
		return projetos;
	}

}
