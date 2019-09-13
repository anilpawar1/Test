package filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * In order for Spring to be able to recognize a filter, 
 * we needed to define it as a bean with the @Component annotation.

 * */


/**
 * And, to have the filters fire in the right order – we needed to use the @Order annotation.
 * */
//@Component
//@Order(1)
public class TransactionFilter {//implements Filter {

/*	private Logger LOG = LogManager.getLogger(TransactionFilter.class);
	
	
	 @Override
	   public void init(FilterConfig filterconfig) throws ServletException {}

	//@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
        LOG.info(
          "Starting a transaction for req : {}", 
          req.getRequestURI());
  
        System.out.println("======================= Remote Host:"+request.getRemoteHost());
        System.out.println("======================= Remote Address:"+request.getRemoteAddr());
        
        
        chain.doFilter(request, response);
        LOG.info(
          "Committing a transaction for req : {}", 
          req.getRequestURI());
        
	}

	@Override
	public void destroy() {
		
	}	*/
}
