package com.github.atharvashelkeatwork.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
    
    private static final EntityManagerFactory emf;
    
    static {
        try {
            emf = Persistence.createEntityManagerFactory("vikas");
        } catch (Throwable e) {
        	System.out.println("Initial EntityManagerFactory creation failed: " + e.getMessage());
        	e.printStackTrace(); // This prints the entire stack trace so you know the exact line number that failed
            throw new ExceptionInInitializerError(e);
        }
    }
    
    private HibernateUtil() {}

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public static void destroy() {
        if (emf != null) {
            emf.close();
        }
    }
}
