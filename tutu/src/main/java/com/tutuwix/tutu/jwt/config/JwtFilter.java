package com.tutuwix.tutu.jwt.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean{
	public static String secret="CHMIX9-ya-casi-se-termina-este-bootcamp-2022-04-05";//Frase para cifrar

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String authHeader = httpServletRequest.getHeader("authorization");
		
		if ( ("POST".equals(httpServletRequest.getMethod())) || 
			 ("GET".equals(httpServletRequest.getMethod())) ||//Solo para la parte de usuarios y se comenta el get de abajo
			//( ("GET".equals(httpServletRequest.getMethod())) && //filtra todo los que tenga que ver con productos
			//		(! httpServletRequest.getRequestURI().contains("/api/productos/") ) )|| //Se agrega para filtrado de productos. Quiero poder tener la LISTA DE PRODUCTOS SIN AUTENTICARME
			 ("PUT".equals(httpServletRequest.getMethod())) || 
			 ("DELETE".equals(httpServletRequest.getMethod())) ) 
		{ 
			if(authHeader == null || !authHeader.startsWith("Bearer ")) {
				throw new ServletException("1, Invalid Token!");
			}
			String token = authHeader.substring(7); 
			try { 
				Claims claims = Jwts.parser().setSigningKey(secret)
						.parseClaimsJws(token).getBody();
				claims.forEach((key, value)->{
					System.out.println("key: " + key + " value: " + value);
				});
				request.setAttribute("claims", claims); 
			}catch (SignatureException | MalformedJwtException e) { 
				throw new ServletException("2. Invalid Token."); 
			}//catch }//if Methods chain.doFilter(request, response); } //doFilter 
		}//if methods
		chain.doFilter(request,response);
	}//do filter
}//main
