package com.cdc.mitrais.jpa.listener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class PersonListener
 *
 */
@WebListener
public class PersonListener implements ServletContextListener {

	private static EntityManagerFactory emf;
	
    /**
     * Default constructor. 
     */
    public PersonListener() {
        // TODO Auto-generated constructor stub
    }

    public static EntityManager createEntityManager() {
    	
    	if(emf == null) {
    		throw new IllegalStateException("Context is not initialized yet.");
    	}
    	
    	return emf.createEntityManager();
    }
    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         emf.close();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         emf = Persistence.createEntityManagerFactory("persistenceUnit");
    }
	
}
