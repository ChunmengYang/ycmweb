package ycmweb;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class OnLineCount
 *
 */
@WebListener
public class OnLineCount implements HttpSessionListener {
	public int count = 0;
	
    /**
     * Default constructor. 
     */
    public OnLineCount() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg)  { 
         // TODO Auto-generated method stub
    	count++;
        arg.getSession().getServletContext().setAttribute("Count", count);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg)  { 
         // TODO Auto-generated method stub
    	count--;
        arg.getSession().getServletContext().setAttribute("Count", count);
    }
	
}
