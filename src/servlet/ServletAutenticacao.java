package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoLogin;
import user.UserLogado;

@WebServlet("/pages/ServletAutenticacao")
public class ServletAutenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DaoLogin daoLogin = new DaoLogin();
       
    public ServletAutenticacao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (Boolean.parseBoolean(request.getParameter("deslogar"))) {
			// adiciona usuário logado na sessão
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			session.invalidate();
			//redireciona para login novamente:
			response.sendRedirect("../index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			String url   = request.getParameter("url");
			
			if (login != null && !login.isEmpty()
					&& senha != null && !senha.isEmpty()) {
				if (daoLogin.validarLogin(login, senha)) {
					
					UserLogado userLogado = new UserLogado();
					userLogado.setLogin(login);
					userLogado.setSenha(senha);
					
					// adiciona usuário logado na sessão
					HttpServletRequest req = (HttpServletRequest) request;
					HttpSession session = req.getSession();
					session.setAttribute("usuario", userLogado);
					
					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/autenticar.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	
	}

}
