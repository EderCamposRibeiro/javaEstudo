package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pages/buscarDatasPlanejamento")
public class BuscarDatasPlanejamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuscarDatasPlanejamento() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ganttJson = "["+
				"{"+
				"\"id\": \"1\", \"name\": \"Projeto Java Web\", \"series\": [" +
				"{ \"name\": \"Planejado\", \"start\": new Date(2020,04,05), \"end\": new Date(2020,04,20) },"+
				"{ \"name\": \"Real\", \"start\": new Date(2020,04,06), \"end\": new Date(2020,04,17), \"color\": \"#f0f0f0\" },"+
				"{ \"name\": \"Projetado\", \"start\": new Date(2020,04,06), \"end\": new Date(2020,04,17), \"color\": \"#e0e0e0\" }"+
			"]}]";

			response.setStatus(200);
			response.getWriter().write(ganttJson);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	}

}
