package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class L1 implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext ss = servletContextEvent.getServletContext();
        System.out.println("L1:contextInitialized");
        System.out.println("L1:serverInfo="+ss.getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext ss = servletContextEvent.getServletContext();
        System.out.println("L1:contextDestroyed");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
