/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.TbRecorrido;
import Model.TbUsuarioRecorrido;
import Model.TbUsuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Usuario
 */
public class TbUsuarioRecorridoJpaController implements Serializable {

    public TbUsuarioRecorridoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TbUsuarioRecorrido tbUsuarioRecorrido) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbRecorrido idRecorrido = tbUsuarioRecorrido.getIdRecorrido();
            if (idRecorrido != null) {
                idRecorrido = em.getReference(idRecorrido.getClass(), idRecorrido.getIdRecorrido());
                tbUsuarioRecorrido.setIdRecorrido(idRecorrido);
            }
            TbUsuarios idUsuario = tbUsuarioRecorrido.getIdUsuario();
            if (idUsuario != null) {
                idUsuario = em.getReference(idUsuario.getClass(), idUsuario.getIdUsuario());
                tbUsuarioRecorrido.setIdUsuario(idUsuario);
            }
            em.persist(tbUsuarioRecorrido);
            if (idRecorrido != null) {
                idRecorrido.getTbUsuarioRecorridoList().add(tbUsuarioRecorrido);
                idRecorrido = em.merge(idRecorrido);
            }
            if (idUsuario != null) {
                idUsuario.getTbUsuarioRecorridoList().add(tbUsuarioRecorrido);
                idUsuario = em.merge(idUsuario);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TbUsuarioRecorrido tbUsuarioRecorrido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbUsuarioRecorrido persistentTbUsuarioRecorrido = em.find(TbUsuarioRecorrido.class, tbUsuarioRecorrido.getId());
            TbRecorrido idRecorridoOld = persistentTbUsuarioRecorrido.getIdRecorrido();
            TbRecorrido idRecorridoNew = tbUsuarioRecorrido.getIdRecorrido();
            TbUsuarios idUsuarioOld = persistentTbUsuarioRecorrido.getIdUsuario();
            TbUsuarios idUsuarioNew = tbUsuarioRecorrido.getIdUsuario();
            if (idRecorridoNew != null) {
                idRecorridoNew = em.getReference(idRecorridoNew.getClass(), idRecorridoNew.getIdRecorrido());
                tbUsuarioRecorrido.setIdRecorrido(idRecorridoNew);
            }
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getIdUsuario());
                tbUsuarioRecorrido.setIdUsuario(idUsuarioNew);
            }
            tbUsuarioRecorrido = em.merge(tbUsuarioRecorrido);
            if (idRecorridoOld != null && !idRecorridoOld.equals(idRecorridoNew)) {
                idRecorridoOld.getTbUsuarioRecorridoList().remove(tbUsuarioRecorrido);
                idRecorridoOld = em.merge(idRecorridoOld);
            }
            if (idRecorridoNew != null && !idRecorridoNew.equals(idRecorridoOld)) {
                idRecorridoNew.getTbUsuarioRecorridoList().add(tbUsuarioRecorrido);
                idRecorridoNew = em.merge(idRecorridoNew);
            }
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getTbUsuarioRecorridoList().remove(tbUsuarioRecorrido);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getTbUsuarioRecorridoList().add(tbUsuarioRecorrido);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbUsuarioRecorrido.getId();
                if (findTbUsuarioRecorrido(id) == null) {
                    throw new NonexistentEntityException("The tbUsuarioRecorrido with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbUsuarioRecorrido tbUsuarioRecorrido;
            try {
                tbUsuarioRecorrido = em.getReference(TbUsuarioRecorrido.class, id);
                tbUsuarioRecorrido.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbUsuarioRecorrido with id " + id + " no longer exists.", enfe);
            }
            TbRecorrido idRecorrido = tbUsuarioRecorrido.getIdRecorrido();
            if (idRecorrido != null) {
                idRecorrido.getTbUsuarioRecorridoList().remove(tbUsuarioRecorrido);
                idRecorrido = em.merge(idRecorrido);
            }
            TbUsuarios idUsuario = tbUsuarioRecorrido.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getTbUsuarioRecorridoList().remove(tbUsuarioRecorrido);
                idUsuario = em.merge(idUsuario);
            }
            em.remove(tbUsuarioRecorrido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TbUsuarioRecorrido> findTbUsuarioRecorridoEntities() {
        return findTbUsuarioRecorridoEntities(true, -1, -1);
    }

    public List<TbUsuarioRecorrido> findTbUsuarioRecorridoEntities(int maxResults, int firstResult) {
        return findTbUsuarioRecorridoEntities(false, maxResults, firstResult);
    }

    private List<TbUsuarioRecorrido> findTbUsuarioRecorridoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbUsuarioRecorrido.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TbUsuarioRecorrido findTbUsuarioRecorrido(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbUsuarioRecorrido.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbUsuarioRecorridoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TbUsuarioRecorrido> rt = cq.from(TbUsuarioRecorrido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
