/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.TbUsuarios;
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
    Este controlador tiene una única función que nos permite obtener una lista de usuarios
    que cumplen los requisitos pasados como parámetros (email y contraseña)
*/
public class Usuarios {
    public static List<TbUsuarios> findLogin(String username,String password)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Poyecto_Java_Web2PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<TbUsuarios> query =em.createNamedQuery("TbUsuarios.findLogin", TbUsuarios.class)
        .setParameter("email", username).setParameter("password",password);
        return query.getResultList();
    }
}
