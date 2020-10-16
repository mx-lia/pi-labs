package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class L2 implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("L2:attributeAdded:AtributeName= " + httpSessionBindingEvent.getName());
        System.out.println("L2:attributeAdded:AtributeValue " + httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("L2:attributeRemoved:AtributeName= " + httpSessionBindingEvent.getName());
        System.out.println("L2:attributeRemoved:AtributeValue " + httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("L2:attributeReplaced:AtributeName=" + httpSessionBindingEvent.getName());
        System.out.println("L2:attributeReplaced:AtributeOldValue " + httpSessionBindingEvent.getValue());
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
