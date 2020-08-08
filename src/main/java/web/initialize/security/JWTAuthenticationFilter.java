package web.initialize.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class JWTAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
         
        System.out.println("2.doFilter");
         
        Authentication authentication = TokenAuthenticationService
        		.getAuthentication((HttpServletRequest) servletRequest);
         //if null -> user is not login -> exception
        // if have authenwill be create but 2 case
        // authentication true
        // authenticastion false -> exception -> need catch
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("3.doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println(((HttpServletRequest)servletRequest).getContextPath());
    }

}
