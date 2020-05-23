package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/pages/carregarDadosDataTable")
public class carregarDadosDataTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public carregarDadosDataTable() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String json = "{"+
			  "\"draw\": 1, "+ 
			  "\"recordsTotal\": 3, "+
			  "\"recordsFiltered\": 3, "+
			  "\"data\": ["+
			    "["+
			      "\"Airi\", "+
			      "\"Satou\", "+
			      "\"Accountant\", "+
			      "\"Tokyo\", "+
			      "\"28th Nov 08\", "+
			      "\"$162.700\"" +
			    "],"+
			    "["+
			      "\"Angelica\", "+
			      "\"Ramos\", "+
			      "\"Chief Executive Officer (CEO)\", "+
			      "\"London\", "+
			      "\"9th Oct 09\", "+
			      "\"$1.200.000\""+
			    "],"+
			    "["+
			      "\"Cedric\", "+
			      "\"Kelly\", "+
			      "\"Senior Javascript Developer\", "+
			      "\"Edinburgh\", "+
			      "\"29th Mar 12\", "+
			      "\"$433.060\""+
			    "]"+
			 "]"+
			"}";
		
		
		response.setStatus(200);// resposta completa OK
		response.getWriter().write(json);// json de resposta (escreve a resposta Http)
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
