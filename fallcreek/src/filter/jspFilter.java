package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class jspFilter implements Filter{
	
	 @Override  
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {  
	        HttpServletRequest httpServletRequest = (HttpServletRequest) request;  
	        HttpServletResponse httpServletResponse = (HttpServletResponse) response;  
	        String url = httpServletRequest.getRequestURI(); 
	       // System.out.println(url);
	        if(url.endsWith("recentleetcodeaction") || url.endsWith("update"))
	        {
//	        		System.out.println(url);
	        		if ("GET".equalsIgnoreCase(httpServletRequest.getMethod())) 
	        		{
//	        			System.out.println("block" + url);
	        			String contextPath = httpServletRequest.getContextPath();
		        		httpServletResponse.sendRedirect(contextPath + "/error");  
		            return; 
		        	}
	        }
	        
	        if(url.endsWith("upload_Qiuxi"))
	        {
//	        		System.out.println("here");
	        	 	String contextPath = httpServletRequest.getContextPath();
	        		httpServletResponse.sendRedirect(contextPath + "/upload?user=fallcreek");  
	            return; 
	        }
	        
	        if(url != null && (url.endsWith(".jsp") || url.endsWith(".action"))) {  
	            String contextPath = httpServletRequest.getContextPath();
	        		httpServletResponse.sendRedirect(contextPath + "/error");  
	            return;  
	        } 
	        chain.doFilter(request, response);  
	    }  
	  
	    @Override  
	    public void destroy() {  
	          
	    }  
	  
	    @Override  
	    public void init(FilterConfig arg0) throws ServletException {  
	          
	    }  
	  
}
