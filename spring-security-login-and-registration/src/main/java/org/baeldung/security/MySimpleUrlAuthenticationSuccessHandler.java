package org.baeldung.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.servlet.http.HttpSessionEvent;

import org.baeldung.persistence.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.baeldung.persistence.model.User;
@Component("myAuthenticationSuccessHandler")
public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
	private IUserService service;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
    	/*
    	try {
    		User user = service.getEuser(authentication.getName());
    		
			if(user.getLoginstatus()==1){			
				//redirectAttributes.addFlashAttribute("message", "Tài khoản đang chơi trên máy khác");
				//model.addAttribute("message", "Tài khoản đang chơi trên máy khác");
				//String email = authentication.getName();
					authentication.setAuthenticated(false);
				  determineFailUrl(request, response) ;
				return;
			}else {
				user.setLoginstatus(1);
				service.saveRegisteredUser(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		*/
        handle(request, response, authentication);
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.setMaxInactiveInterval(20*60);
            session.setAttribute("username", authentication.getName());
           // System.out.println( authentication.getName());
        }
        clearAuthenticationAttributes(request);
        //System.out.println((String)session.getAttribute("username"));
    }

    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
    
    
    protected void determineFailUrl(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	request.setAttribute("message", "Tài khoản đang chơi trên máy khác");
    	RequestDispatcher dispatcher =
    			request.getRequestDispatcher("/login.html");
    			dispatcher.forward(request, response);
    	//redirectStrategy.sendRedirect(request, response );
    }
    
    
    protected String determineTargetUrl(Authentication authentication) {
        boolean isUser = false;
        boolean isAdmin = false;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
                isUser = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                isAdmin = true;
                break;
            }
        }
        if (isUser) {
        	return "/home.html" ;
           //return "/homepage.html?user=" + authentication.getName();
        } else if (isAdmin) {
            return "/admin.html";
        } else {
            throw new IllegalStateException();
        }
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}