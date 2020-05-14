package excecoes;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns={"/*"})
public class FilterAutenticacao  implements Filter{
	
	// Faz alguma coisa quando a aplicação é derrubada
	@Override
	public void destroy() {
		Filter.super.destroy();
	}

	// Intercepta todas as requisições	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//executa as ações do request e response
		chain.doFilter(request, response);
		
		System.out.println("interceptando");
	}
	
	// Executa alguma coisa quando a aplicação é iniciada.
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
