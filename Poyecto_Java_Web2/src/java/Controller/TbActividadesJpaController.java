/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Controller.exceptions.NonexistentEntityException;
import Model.TbActividades;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.TbRecorridoActividad;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Usuario
 */
public class TbActividadesJpaController implements Serializable {

    public TbActividadesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TbActividades tbActividades) {
        if (tbActividades.getTbRecorridoActividadList() == null) {
            tbActividades.setTbRecorridoActividadList(new ArrayList<TbRecorridoActividad>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<TbRecorridoActividad> attachedTbRecorridoActividadList = new ArrayList<TbRecorridoActividad>();
            for (TbRecorridoActividad tbRecorridoActividadListTbRecorridoActividadToAttach : tbActividades.getTbRecorridoActividadList()) {
                tbRecorridoActividadListTbRecorridoActividadToAttach = em.getReference(tbRecorridoActividadListTbRecorridoActividadToAttach.getClass(), tbRecorridoActividadListTbRecorridoActividadToAttach.getId());
                attachedTbRecorridoActividadList.add(tbRecorridoActividadListTbRecorridoActividadToAttach);
            }
            tbActividades.setTbRecorridoActividadList(attachedTbRecorridoActividadList);
            em.persist(tbActividades);
            for (TbRecorridoActividad tbRecorridoActividadListTbRecorridoActividad : tbActividades.getTbRecorridoActividadList()) {
                TbActividades oldIdActividadOfTbRecorridoActividadListTbRecorridoActividad = tbRecorridoActividadListTbRecorridoActividad.getIdActividad();
                tbRecorridoActividadListTbRecorridoActividad.setIdActividad(tbActividades);
                tbRecorridoActividadListTbRecorridoActividad = em.merge(tbRecorridoActividadListTbRecorridoActividad);
                if (oldIdActividadOfTbRecorridoActividadListTbRecorridoActividad != null) {
                    oldIdActividadOfTbRecorridoActividadListTbRecorridoActividad.getTbRecorridoActividadList().remove(tbRecorridoActividadListTbRecorridoActividad);
                    oldIdActividadOfTbRecorridoActividadListTbRecorridoActividad = em.merge(oldIdActividadOfTbRecorridoActividadListTbRecorridoActividad);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TbActividades tbActividades) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbActividades persistentTbActividades = em.find(TbActividades.class, tbActividades.getIdActividad());
            List<TbRecorridoActividad> tbRecorridoActividadListOld = persistentTbActividades.getTbRecorridoActividadList();
            List<TbRecorridoActividad> tbRecorridoActividadListNew = tbActividades.getTbRecorridoActividadList();
            List<TbRecorridoActividad> attachedTbRecorridoActividadListNew = new ArrayList<TbRecorridoActividad>();
            for (TbRecorridoActividad tbRecorridoActividadListNewTbRecorridoActividadToAttach : tbRecorridoActividadListNew) {
                tbRecorridoActividadListNewTbRecorridoActividadToAttach = em.getReference(tbRecorridoActividadListNewTbRecorridoActividadToAttach.getClass(), tbRecorridoActividadListNewTbRecorridoActividadToAttach.getId());
                attachedTbRecorridoActividadListNew.add(tbRecorridoActividadListNewTbRecorridoActividadToAttach);
            }
            tbRecorridoActividadListNew = attachedTbRecorridoActividadListNew;
            tbActividades.setTbRecorridoActividadList(tbRecorridoActividadListNew);
            tbActividades = em.merge(tbActividades);
            for (TbRecorridoActividad tbRecorridoActividadListOldTbRecorridoActividad : tbRecorridoActividadListOld) {
                if (!tbRecorridoActividadListNew.contains(tbRecorridoActividadListOldTbRecorridoActividad)) {
                    tbRecorridoActividadListOldTbRecorridoActividad.setIdActividad(null);
                    tbRecorridoActividadListOldTbRecorridoActividad = em.merge(tbRecorridoActividadListOldTbRecorridoActividad);
                }
            }
            for (TbRecorridoActividad tbRecorridoActividadListNewTbRecorridoActividad : tbRecorridoActividadListNew) {
                if (!tbRecorridoActividadListOld.contains(tbRecorridoActividadListNewTbRecorridoActividad)) {
                    TbActividades oldIdActividadOfTbRecorridoActividadListNewTbRecorridoActividad = tbRecorridoActividadListNewTbRecorridoActividad.getIdActividad();
                    tbRecorridoActividadListNewTbRecorridoActividad.setIdActividad(tbActividades);
                    tbRecorridoActividadListNewTbRecorridoActividad = em.merge(tbRecorridoActividadListNewTbRecorridoActividad);
                    if (oldIdActividadOfTbRecorridoActividadListNewTbRecorridoActividad != null && !oldIdActividadOfTbRecorridoActividadListNewTbRecorridoActividad.equals(tbActividades)) {
                        oldIdActividadOfTbRecorridoActividadListNewTbRecorridoActividad.getTbRecorridoActividadList().remove(tbRecorridoActividadListNewTbRecorridoActividad);
                        oldIdActividadOfTbRecorridoActividadListNewTbRecorridoActividad = em.merge(oldIdActividadOfTbRecorridoActividadListNewTbRecorridoActividad);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbActividades.getIdActividad();
                if (findTbActividades(id) == null) {
                    throw new NonexistentEntityException("The tbActividades with id " + id + " no longer exists.");
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
            TbActividades tbActividades;
            try {
                tbActividades = em.getReference(TbActividades.class, id);
                tbActividades.getIdActividad();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbActividades with id " + id + " no longer exists.", enfe);
            }
            List<TbRecorridoActividad> tbRecorridoActividadList = tbActividades.getTbRecorridoActividadList();
            for (TbRecorridoActividad tbRecorridoActividadListTbRecorridoActividad : tbRecorridoActividadList) {
                tbRecorridoActividadListTbRecorridoActividad.setIdActividad(null);
                tbRecorridoActividadListTbRecorridoActividad = em.merge(tbRecorridoActividadListTbRecorridoActividad);
            }
            em.remove(tbActividades);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TbActividades> findTbActividadesEntities() {
        return findTbActividadesEntities(true, -1, -1);
    }

    public List<TbActividades> findTbActividadesEntities(int maxResults, int firstResult) {
        return findTbActividadesEntities(false, maxResults, firstResult);
    }

    private List<TbActividades> findTbActividadesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbActividades.class));
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

    public TbActividades findTbActividades(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbActividades.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbActividadesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TbActividades> rt = cq.from(TbActividades.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
