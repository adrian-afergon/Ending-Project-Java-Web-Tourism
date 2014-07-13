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
import Model.TbActividades;
import Model.TbRecorrido;
import Model.TbRecorridoActividad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Usuario
 */
public class TbRecorridoActividadJpaController implements Serializable {

    public TbRecorridoActividadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TbRecorridoActividad tbRecorridoActividad) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbActividades idActividad = tbRecorridoActividad.getIdActividad();
            if (idActividad != null) {
                idActividad = em.getReference(idActividad.getClass(), idActividad.getIdActividad());
                tbRecorridoActividad.setIdActividad(idActividad);
            }
            TbRecorrido idRecorrido = tbRecorridoActividad.getIdRecorrido();
            if (idRecorrido != null) {
                idRecorrido = em.getReference(idRecorrido.getClass(), idRecorrido.getIdRecorrido());
                tbRecorridoActividad.setIdRecorrido(idRecorrido);
            }
            em.persist(tbRecorridoActividad);
            if (idActividad != null) {
                idActividad.getTbRecorridoActividadList().add(tbRecorridoActividad);
                idActividad = em.merge(idActividad);
            }
            if (idRecorrido != null) {
                idRecorrido.getTbRecorridoActividadList().add(tbRecorridoActividad);
                idRecorrido = em.merge(idRecorrido);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TbRecorridoActividad tbRecorridoActividad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbRecorridoActividad persistentTbRecorridoActividad = em.find(TbRecorridoActividad.class, tbRecorridoActividad.getId());
            TbActividades idActividadOld = persistentTbRecorridoActividad.getIdActividad();
            TbActividades idActividadNew = tbRecorridoActividad.getIdActividad();
            TbRecorrido idRecorridoOld = persistentTbRecorridoActividad.getIdRecorrido();
            TbRecorrido idRecorridoNew = tbRecorridoActividad.getIdRecorrido();
            if (idActividadNew != null) {
                idActividadNew = em.getReference(idActividadNew.getClass(), idActividadNew.getIdActividad());
                tbRecorridoActividad.setIdActividad(idActividadNew);
            }
            if (idRecorridoNew != null) {
                idRecorridoNew = em.getReference(idRecorridoNew.getClass(), idRecorridoNew.getIdRecorrido());
                tbRecorridoActividad.setIdRecorrido(idRecorridoNew);
            }
            tbRecorridoActividad = em.merge(tbRecorridoActividad);
            if (idActividadOld != null && !idActividadOld.equals(idActividadNew)) {
                idActividadOld.getTbRecorridoActividadList().remove(tbRecorridoActividad);
                idActividadOld = em.merge(idActividadOld);
            }
            if (idActividadNew != null && !idActividadNew.equals(idActividadOld)) {
                idActividadNew.getTbRecorridoActividadList().add(tbRecorridoActividad);
                idActividadNew = em.merge(idActividadNew);
            }
            if (idRecorridoOld != null && !idRecorridoOld.equals(idRecorridoNew)) {
                idRecorridoOld.getTbRecorridoActividadList().remove(tbRecorridoActividad);
                idRecorridoOld = em.merge(idRecorridoOld);
            }
            if (idRecorridoNew != null && !idRecorridoNew.equals(idRecorridoOld)) {
                idRecorridoNew.getTbRecorridoActividadList().add(tbRecorridoActividad);
                idRecorridoNew = em.merge(idRecorridoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbRecorridoActividad.getId();
                if (findTbRecorridoActividad(id) == null) {
                    throw new NonexistentEntityException("The tbRecorridoActividad with id " + id + " no longer exists.");
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
            TbRecorridoActividad tbRecorridoActividad;
            try {
                tbRecorridoActividad = em.getReference(TbRecorridoActividad.class, id);
                tbRecorridoActividad.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbRecorridoActividad with id " + id + " no longer exists.", enfe);
            }
            TbActividades idActividad = tbRecorridoActividad.getIdActividad();
            if (idActividad != null) {
                idActividad.getTbRecorridoActividadList().remove(tbRecorridoActividad);
                idActividad = em.merge(idActividad);
            }
            TbRecorrido idRecorrido = tbRecorridoActividad.getIdRecorrido();
            if (idRecorrido != null) {
                idRecorrido.getTbRecorridoActividadList().remove(tbRecorridoActividad);
                idRecorrido = em.merge(idRecorrido);
            }
            em.remove(tbRecorridoActividad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TbRecorridoActividad> findTbRecorridoActividadEntities() {
        return findTbRecorridoActividadEntities(true, -1, -1);
    }

    public List<TbRecorridoActividad> findTbRecorridoActividadEntities(int maxResults, int firstResult) {
        return findTbRecorridoActividadEntities(false, maxResults, firstResult);
    }

    private List<TbRecorridoActividad> findTbRecorridoActividadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbRecorridoActividad.class));
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

    public TbRecorridoActividad findTbRecorridoActividad(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbRecorridoActividad.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbRecorridoActividadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TbRecorridoActividad> rt = cq.from(TbRecorridoActividad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
