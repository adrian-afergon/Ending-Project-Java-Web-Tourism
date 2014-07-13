/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.TbRecorrido;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Usuario
 */

/*
    Definimos el controlador Recorridos, dicho controlador lo hemos creado nosotros a mano
    en el cual tenemos las funciones que procesarán los valores que deseamos obtener
    a través del modelo correspondiente y las namequery pertinentes.
*/
public class Recorridos {
    
    //Nos busca y devuelve los proximos recorridos
    public static List<TbRecorrido> findProximos()
    {
        Date fecha = new Date();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Poyecto_Java_Web2PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<TbRecorrido> query =em.createNamedQuery("TbRecorrido.findProximos", TbRecorrido.class)
        .setParameter("fechaInicio",fecha);
        return query.getResultList();
    }
    
    //Nos busca y devuelve los proximos recorridos en función de una fecha y un lugar
    public static List<TbRecorrido> findProximosLugar(Date fecha,String lugar)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Poyecto_Java_Web2PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<TbRecorrido> query =em.createNamedQuery("TbRecorrido.findProximosLugar", TbRecorrido.class)
        .setParameter("fechaInicio",fecha)
        .setParameter("lugar",lugar);
        return query.getResultList();
    }
    /*
    public static List<TbRecorrido> filtroPorID()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Poyecto_Java_Web2PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<TbRecorrido> query =em.createNamedQuery("TbRecorrido.findByIdRecorrido", TbRecorrido.class)
        .setParameter("idRecorrido", 1);
        return query.getResultList();
    }*/
}
