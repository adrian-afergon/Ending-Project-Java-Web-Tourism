/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Controller.exceptions.NonexistentEntityException;
import Model.TbRecorrido;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.TbRecorridoActividad;
import java.util.ArrayList;
import java.util.List;
import Model.TbUsuarioRecorrido;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Usuario
 */
public class TbRecorridoJpaController implements Serializable {

    public TbRecorridoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TbRecorrido tbRecorrido) {
        if (tbRecorrido.getTbRecorridoActividadList() == null) {
            tbRecorrido.setTbRecorridoActividadList(new ArrayList<TbRecorridoActividad>());
        }
        if (tbRecorrido.getTbUsuarioRecorridoList() == null) {
            tbRecorrido.setTbUsuarioRecorridoList(new ArrayList<TbUsuarioRecorrido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<TbRecorridoActividad> attachedTbRecorridoActividadList = new ArrayList<TbRecorridoActividad>();
            for (TbRecorridoActividad tbRecorridoActividadListTbRecorridoActividadToAttach : tbRecorrido.getTbRecorridoActividadList()) {
                tbRecorridoActividadListTbRecorridoActividadToAttach = em.getReference(tbRecorridoActividadListTbRecorridoActividadToAttach.getClass(), tbRecorridoActividadListTbRecorridoActividadToAttach.getId());
                attachedTbRecorridoActividadList.add(tbRecorridoActividadListTbRecorridoActividadToAttach);
            }
            tbRecorrido.setTbRecorridoActividadList(attachedTbRecorridoActividadList);
            List<TbUsuarioRecorrido> attachedTbUsuarioRecorridoList = new ArrayList<TbUsuarioRecorrido>();
            for (TbUsuarioRecorrido tbUsuarioRecorridoListTbUsuarioRecorridoToAttach : tbRecorrido.getTbUsuarioRecorridoList()) {
                tbUsuarioRecorridoListTbUsuarioRecorridoToAttach = em.getReference(tbUsuarioRecorridoListTbUsuarioRecorridoToAttach.getClass(), tbUsuarioRecorridoListTbUsuarioRecorridoToAttach.getId());
                attachedTbUsuarioRecorridoList.add(tbUsuarioRecorridoListTbUsuarioRecorridoToAttach);
            }
            tbRecorrido.setTbUsuarioRecorridoList(attachedTbUsuarioRecorridoList);
            em.persist(tbRecorrido);
            for (TbRecorridoActividad tbRecorridoActividadListTbRecorridoActividad : tbRecorrido.getTbRecorridoActividadList()) {
                TbRecorrido oldIdRecorridoOfTbRecorridoActividadListTbRecorridoActividad = tbRecorridoActividadListTbRecorridoActividad.getIdRecorrido();
                tbRecorridoActividadListTbRecorridoActividad.setIdRecorrido(tbRecorrido);
                tbRecorridoActividadListTbRecorridoActividad = em.merge(tbRecorridoActividadListTbRecorridoActividad);
                if (oldIdRecorridoOfTbRecorridoActividadListTbRecorridoActividad != null) {
                    oldIdRecorridoOfTbRecorridoActividadListTbRecorridoActividad.getTbRecorridoActividadList().remove(tbRecorridoActividadListTbRecorridoActividad);
                    oldIdRecorridoOfTbRecorridoActividadListTbRecorridoActividad = em.merge(oldIdRecorridoOfTbRecorridoActividadListTbRecorridoActividad);
                }
            }
            for (TbUsuarioRecorrido tbUsuarioRecorridoListTbUsuarioRecorrido : tbRecorrido.getTbUsuarioRecorridoList()) {
                TbRecorrido oldIdRecorridoOfTbUsuarioRecorridoListTbUsuarioRecorrido = tbUsuarioRecorridoListTbUsuarioRecorrido.getIdRecorrido();
                tbUsuarioRecorridoListTbUsuarioRecorrido.setIdRecorrido(tbRecorrido);
                tbUsuarioRecorridoListTbUsuarioRecorrido = em.merge(tbUsuarioRecorridoListTbUsuarioRecorrido);
                if (oldIdRecorridoOfTbUsuarioRecorridoListTbUsuarioRecorrido != null) {
                    oldIdRecorridoOfTbUsuarioRecorridoListTbUsuarioRecorrido.getTbUsuarioRecorridoList().remove(tbUsuarioRecorridoListTbUsuarioRecorrido);
                    oldIdRecorridoOfTbUsuarioRecorridoListTbUsuarioRecorrido = em.merge(oldIdRecorridoOfTbUsuarioRecorridoListTbUsuarioRecorrido);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TbRecorrido tbRecorrido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbRecorrido persistentTbRecorrido = em.find(TbRecorrido.class, tbRecorrido.getIdRecorrido());
            List<TbRecorridoActividad> tbRecorridoActividadListOld = persistentTbRecorrido.getTbRecorridoActividadList();
            List<TbRecorridoActividad> tbRecorridoActividadListNew = tbRecorrido.getTbRecorridoActividadList();
            List<TbUsuarioRecorrido> tbUsuarioRecorridoListOld = persistentTbRecorrido.getTbUsuarioRecorridoList();
            List<TbUsuarioRecorrido> tbUsuarioRecorridoListNew = tbRecorrido.getTbUsuarioRecorridoList();
            List<TbRecorridoActividad> attachedTbRecorridoActividadListNew = new ArrayList<TbRecorridoActividad>();
            for (TbRecorridoActividad tbRecorridoActividadListNewTbRecorridoActividadToAttach : tbRecorridoActividadListNew) {
                tbRecorridoActividadListNewTbRecorridoActividadToAttach = em.getReference(tbRecorridoActividadListNewTbRecorridoActividadToAttach.getClass(), tbRecorridoActividadListNewTbRecorridoActividadToAttach.getId());
                attachedTbRecorridoActividadListNew.add(tbRecorridoActividadListNewTbRecorridoActividadToAttach);
            }
            tbRecorridoActividadListNew = attachedTbRecorridoActividadListNew;
            tbRecorrido.setTbRecorridoActividadList(tbRecorridoActividadListNew);
            List<TbUsuarioRecorrido> attachedTbUsuarioRecorridoListNew = new ArrayList<TbUsuarioRecorrido>();
            for (TbUsuarioRecorrido tbUsuarioRecorridoListNewTbUsuarioRecorridoToAttach : tbUsuarioRecorridoListNew) {
                tbUsuarioRecorridoListNewTbUsuarioRecorridoToAttach = em.getReference(tbUsuarioRecorridoListNewTbUsuarioRecorridoToAttach.getClass(), tbUsuarioRecorridoListNewTbUsuarioRecorridoToAttach.getId());
                attachedTbUsuarioRecorridoListNew.add(tbUsuarioRecorridoListNewTbUsuarioRecorridoToAttach);
            }
            tbUsuarioRecorridoListNew = attachedTbUsuarioRecorridoListNew;
            tbRecorrido.setTbUsuarioRecorridoList(tbUsuarioRecorridoListNew);
            tbRecorrido = em.merge(tbRecorrido);
            for (TbRecorridoActividad tbRecorridoActividadListOldTbRecorridoActividad : tbRecorridoActividadListOld) {
                if (!tbRecorridoActividadListNew.contains(tbRecorridoActividadListOldTbRecorridoActividad)) {
                    tbRecorridoActividadListOldTbRecorridoActividad.setIdRecorrido(null);
                    tbRecorridoActividadListOldTbRecorridoActividad = em.merge(tbRecorridoActividadListOldTbRecorridoActividad);
                }
            }
            for (TbRecorridoActividad tbRecorridoActividadListNewTbRecorridoActividad : tbRecorridoActividadListNew) {
                if (!tbRecorridoActividadListOld.contains(tbRecorridoActividadListNewTbRecorridoActividad)) {
                    TbRecorrido oldIdRecorridoOfTbRecorridoActividadListNewTbRecorridoActividad = tbRecorridoActividadListNewTbRecorridoActividad.getIdRecorrido();
                    tbRecorridoActividadListNewTbRecorridoActividad.setIdRecorrido(tbRecorrido);
                    tbRecorridoActividadListNewTbRecorridoActividad = em.merge(tbRecorridoActividadListNewTbRecorridoActividad);
                    if (oldIdRecorridoOfTbRecorridoActividadListNewTbRecorridoActividad != null && !oldIdRecorridoOfTbRecorridoActividadListNewTbRecorridoActividad.equals(tbRecorrido)) {
                        oldIdRecorridoOfTbRecorridoActividadListNewTbRecorridoActividad.getTbRecorridoActividadList().remove(tbRecorridoActividadListNewTbRecorridoActividad);
                        oldIdRecorridoOfTbRecorridoActividadListNewTbRecorridoActividad = em.merge(oldIdRecorridoOfTbRecorridoActividadListNewTbRecorridoActividad);
                    }
                }
            }
            for (TbUsuarioRecorrido tbUsuarioRecorridoListOldTbUsuarioRecorrido : tbUsuarioRecorridoListOld) {
                if (!tbUsuarioRecorridoListNew.contains(tbUsuarioRecorridoListOldTbUsuarioRecorrido)) {
                    tbUsuarioRecorridoListOldTbUsuarioRecorrido.setIdRecorrido(null);
                    tbUsuarioRecorridoListOldTbUsuarioRecorrido = em.merge(tbUsuarioRecorridoListOldTbUsuarioRecorrido);
                }
            }
            for (TbUsuarioRecorrido tbUsuarioRecorridoListNewTbUsuarioRecorrido : tbUsuarioRecorridoListNew) {
                if (!tbUsuarioRecorridoListOld.contains(tbUsuarioRecorridoListNewTbUsuarioRecorrido)) {
                    TbRecorrido oldIdRecorridoOfTbUsuarioRecorridoListNewTbUsuarioRecorrido = tbUsuarioRecorridoListNewTbUsuarioRecorrido.getIdRecorrido();
                    tbUsuarioRecorridoListNewTbUsuarioRecorrido.setIdRecorrido(tbRecorrido);
                    tbUsuarioRecorridoListNewTbUsuarioRecorrido = em.merge(tbUsuarioRecorridoListNewTbUsuarioRecorrido);
                    if (oldIdRecorridoOfTbUsuarioRecorridoListNewTbUsuarioRecorrido != null && !oldIdRecorridoOfTbUsuarioRecorridoListNewTbUsuarioRecorrido.equals(tbRecorrido)) {
                        oldIdRecorridoOfTbUsuarioRecorridoListNewTbUsuarioRecorrido.getTbUsuarioRecorridoList().remove(tbUsuarioRecorridoListNewTbUsuarioRecorrido);
                        oldIdRecorridoOfTbUsuarioRecorridoListNewTbUsuarioRecorrido = em.merge(oldIdRecorridoOfTbUsuarioRecorridoListNewTbUsuarioRecorrido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbRecorrido.getIdRecorrido();
                if (findTbRecorrido(id) == null) {
                    throw new NonexistentEntityException("The tbRecorrido with id " + id + " no longer exists.");
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
            TbRecorrido tbRecorrido;
            try {
                tbRecorrido = em.getReference(TbRecorrido.class, id);
                tbRecorrido.getIdRecorrido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbRecorrido with id " + id + " no longer exists.", enfe);
            }
            List<TbRecorridoActividad> tbRecorridoActividadList = tbRecorrido.getTbRecorridoActividadList();
            for (TbRecorridoActividad tbRecorridoActividadListTbRecorridoActividad : tbRecorridoActividadList) {
                tbRecorridoActividadListTbRecorridoActividad.setIdRecorrido(null);
                tbRecorridoActividadListTbRecorridoActividad = em.merge(tbRecorridoActividadListTbRecorridoActividad);
            }
            List<TbUsuarioRecorrido> tbUsuarioRecorridoList = tbRecorrido.getTbUsuarioRecorridoList();
            for (TbUsuarioRecorrido tbUsuarioRecorridoListTbUsuarioRecorrido : tbUsuarioRecorridoList) {
                tbUsuarioRecorridoListTbUsuarioRecorrido.setIdRecorrido(null);
                tbUsuarioRecorridoListTbUsuarioRecorrido = em.merge(tbUsuarioRecorridoListTbUsuarioRecorrido);
            }
            em.remove(tbRecorrido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TbRecorrido> findTbRecorridoEntities() {
        return findTbRecorridoEntities(true, -1, -1);
    }

    public List<TbRecorrido> findTbRecorridoEntities(int maxResults, int firstResult) {
        return findTbRecorridoEntities(false, maxResults, firstResult);
    }

    private List<TbRecorrido> findTbRecorridoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbRecorrido.class));
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

    public TbRecorrido findTbRecorrido(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbRecorrido.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbRecorridoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TbRecorrido> rt = cq.from(TbRecorrido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
