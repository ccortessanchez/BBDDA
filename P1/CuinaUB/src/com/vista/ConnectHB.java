/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vista;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
@SuppressWarnings("deprecation")

/**
 *
 * @author Carlos Cortes i Pol Girbal
 */
public class ConnectHB {
    private static SessionFactory sf = null;

    public ConnectHB() {

    }

    //Se instancia antes del constructor
    static {
        //Inicializa el SF buscando los ficheros de configuracion
        try {
            sf = new Configuration().configure().buildSessionFactory();
            //Marcamos la opcion anotaciones
            //sf = new AnnotationConfiguration().configure().buildSessionFactory();
            System.out.println("Instanciando SF");
        } catch (HibernateException e) {
            System.out.println("Error SF: " + e.getMessage());
        }
    }

    public static Session getSession() {
        Session session = sf.openSession();
        return session;
    }
    
}
