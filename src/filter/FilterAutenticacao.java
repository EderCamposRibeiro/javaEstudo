package filter;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import connections.ConnectionDataBase;
import user.UserLogado;

@WebFilter(urlPatterns={"/pages/*"})
public class FilterAutenticacao  implements Filter{
	
	private static Connection connection;
	
	// Faz alguma coisa quando a aplica��o � derrubada
	@Override
	public void destroy() {
		Filter.super.destroy();
	}

	// Intercepta todas as requisi��es	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		String urlParaAutenticar = req.getServletPath();
		
		// retorna null caso n�o esteja logado
		UserLogado userLogado = (UserLogado) session.getAttribute("usuario");
		
		if (userLogado ==  null && !urlParaAutenticar.equalsIgnoreCase("/pages/ServletAutenticacao")) { // usu�rio n�o logado
			RequestDispatcher dispatcher = request.getRequestDispatcher("/autenticar.jsp?url="+urlParaAutenticar);
			dispatcher.forward(request, response);
			return; //interrompe o processo para redirecionar
		}
		
		//executa as a��es do request e response
//		try {
			chain.doFilter(request, response);
//			connection.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			try {
//				connection.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		}
		
	}
	
	// Executa alguma coisa quando a aplica��o � iniciada.
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		connection = ConnectionDataBase.getConnection();
	}

}
