package utils;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Session {
	
	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}
	
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}
	
	public static String logout(){
 		FacesContext context = FacesContext.getCurrentInstance();
 		ExternalContext ec = context.getExternalContext();
 
 		final HttpServletRequest request = (HttpServletRequest)ec.getRequest();
 	     request.getSession( false ).invalidate();
 	  
 	     
 	     return "login";
 	}
	
}
