package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanUsuario;
import dao.DaoUsuario;


@WebServlet("/pages/carregarDadosDataTable")
public class carregarDadosDataTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DaoUsuario daoUsuario = new DaoUsuario();
       
    public carregarDadosDataTable() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<BeanUsuario> usuarios = daoUsuario.getUsuarios();
			
			String data = "";
			int totalUsuarios = usuarios.size();
			int index = 1;
			
			for (BeanUsuario beanUsuario : usuarios) {
				
				
		     	  data += "["+
			     	      "\""+beanUsuario.getId()+"\", "+
			     	      "\""+beanUsuario.getLogin()+"\", "+
			     	      "\""+beanUsuario.getNome()+"\" "+
			     	    "]";
		     	  if (index < totalUsuarios) {
					data += ",";
				  }
		     	  index++;
			}
			
			if (!usuarios.isEmpty()) {
			     String json = "{"+
			     	  "\"draw\": 1, "+ 
			     	  "\"recordsTotal\": "+usuarios.size()+", "+
			     	  "\"recordsFiltered\": "+usuarios.size()+", "+
			     	  "\"data\": ["+data+"]"+ //Fechamento do data
			     	"}";    //Fechamento do json
			
			
			response.setStatus(200);// resposta completa OK
			response.getWriter().write(json);// json de resposta (escreve a resposta Http)
			}
		} catch (Exception e) {
			response.setStatus(500);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
