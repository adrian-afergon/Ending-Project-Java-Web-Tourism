package Controller;
import Model.TbRecorrido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public final class EntityMan {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Poyecto_Java_Web2PU");
    public EntityMan(){
        
    }
    public static EntityManagerFactory getInstance(){
        return emf;
    }
    
    public static List<TbRecorrido> filtroPorID()
    {
        EntityManager em = emf.createEntityManager();
        TypedQuery<TbRecorrido> query =em.createNamedQuery("TbRecorrido.findByIdRecorrido", TbRecorrido.class)
        .setParameter("idRecorrido", 1);
        return query.getResultList();
    }
}

