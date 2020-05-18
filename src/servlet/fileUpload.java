package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUsuario;

@WebServlet("/pages/fileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DaoUsuario daoUsuario = new DaoUsuario();
       
    public FileUpload() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			RequestDispatcher viDispatcher = request.getRequestDispatcher("upload.jsp");
			request.setAttribute("listaUserImagem", daoUsuario.getUsuarios());
			viDispatcher.forward(request, response);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			String fileUpload = request.getParameter("fileUpload");
			// Usar variavel fileUpload para salvar no banco de dados
			daoUsuario.gravarImagem(fileUpload);
			
			//neste momento faz o insert no banco de dados
			response.getWriter().write("UPLOAD realizado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("Erro fatal ao realizar upload");

		}
		
	}

}
