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
import Model.TbUsuarioRecorrido;
import Model.TbUsuarios;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Usuario
 */
public class TbUsuariosJpaController implements Serializable {

    public TbUsuariosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TbUsuarios tbUsuarios) {
        if (tbUsuarios.getTbUsuarioRecorridoList() == null) {
            tbUsuarios.setTbUsuarioRecorridoList(new ArrayList<TbUsuarioRecorrido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<TbUsuarioRecorrido> attachedTbUsuarioRecorridoList = new ArrayList<TbUsuarioRecorrido>();
            for (TbUsuarioRecorrido tbUsuarioRecorridoListTbUsuarioRecorridoToAttach : tbUsuarios.getTbUsuarioRecorridoList()) {
                tbUsuarioRecorridoListTbUsuarioRecorridoToAttach = em.getReference(tbUsuarioRecorridoListTbUsuarioRecorridoToAttach.getClass(), tbUsuarioRecorridoListTbUsuarioRecorridoToAttach.getId());
                attachedTbUsuarioRecorridoList.add(tbUsuarioRecorridoListTbUsuarioRecorridoToAttach);
            }
            tbUsuarios.setTbUsuarioRecorridoList(attachedTbUsuarioRecorridoList);
            em.persist(tbUsuarios);
            for (TbUsuarioRecorrido tbUsuarioRecorridoListTbUsuarioRecorrido : tbUsuarios.getTbUsuarioRecorridoList()) {
                TbUsuarios oldIdUsuarioOfTbUsuarioRecorridoListTbUsuarioRecorrido = tbUsuarioRecorridoListTbUsuarioRecorrido.getIdUsuario();
                tbUsuarioRecorridoListTbUsuarioRecorrido.setIdUsuario(tbUsuarios);
                tbUsuarioRecorridoListTbUsuarioRecorrido = em.merge(tbUsuarioRecorridoListTbUsuarioRecorrido);
                if (oldIdUsuarioOfTbUsuarioRecorridoListTbUsuarioRecorrido != null) {
                    oldIdUsuarioOfTbUsuarioRecorridoListTbUsuarioRecorrido.getTbUsuarioRecorridoList().remove(tbUsuarioRecorridoListTbUsuarioRecorrido);
                    oldIdUsuarioOfTbUsuarioRecorridoListTbUsuarioRecorrido = em.merge(oldIdUsuarioOfTbUsuarioRecorridoListTbUsuarioRecorrido);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TbUsuarios tbUsuarios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TbUsuarios persistentTbUsuarios = em.find(TbUsuarios.class, tbUsuarios.getIdUsuario());
            List<TbUsuarioRecorrido> tbUsuarioRecorridoListOld = persistentTbUsuarios.getTbUsuarioRecorridoList();
            List<TbUsuarioRecorrido> tbUsuarioRecorridoListNew = tbUsuarios.getTbUsuarioRecorridoList();
            List<TbUsuarioRecorrido> attachedTbUsuarioRecorridoListNew = new ArrayList<TbUsuarioRecorrido>();
            for (TbUsuarioRecorrido tbUsuarioRecorridoListNewTbUsuarioRecorridoToAttach : tbUsuarioRecorridoListNew) {
                tbUsuarioRecorridoListNewTbUsuarioRecorridoToAttach = em.getReference(tbUsuarioRecorridoListNewTbUsuarioRecorridoToAttach.getClass(), tbUsuarioRecorridoListNewTbUsuarioRecorridoToAttach.getId());
                attachedTbUsuarioRecorridoListNew.add(tbUsuarioRecorridoListNewTbUsuarioRecorridoToAttach);
            }
            tbUsuarioRecorridoListNew = attachedTbUsuarioRecorridoListNew;
            tbUsuarios.setTbUsuarioRecorridoList(tbUsuarioRecorridoListNew);
            tbUsuarios = em.merge(tbUsuarios);
            for (TbUsuarioRecorrido tbUsuarioRecorridoListOldTbUsuarioRecorrido : tbUsuarioRecorridoListOld) {
                if (!tbUsuarioRecorridoListNew.contains(tbUsuarioRecorridoListOldTbUsuarioRecorrido)) {
                    tbUsuarioRecorridoListOldTbUsuarioRecorrido.setIdUsuario(null);
                    tbUsuarioRecorridoListOldTbUsuarioRecorrido = em.merge(tbUsuarioRecorridoListOldTbUsuarioRecorrido);
                }
            }
            for (TbUsuarioRecorrido tbUsuarioRecorridoListNewTbUsuarioRecorrido : tbUsuarioRecorridoListNew) {
                if (!tbUsuarioRecorridoListOld.contains(tbUsuarioRecorridoListNewTbUsuarioRecorrido)) {
                    TbUsuarios oldIdUsuarioOfTbUsuarioRecorridoListNewTbUsuarioRecorrido = tbUsuarioRecorridoListNewTbUsuarioRecorrido.getIdUsuario();
                    tbUsuarioRecorridoListNewTbUsuarioRecorrido.setIdUsuario(tbUsuarios);
                    tbUsuarioRecorridoListNewTbUsuarioRecorrido = em.merge(tbUsuarioRecorridoListNewTbUsuarioRecorrido);
                    if (oldIdUsuarioOfTbUsuarioRecorridoListNewTbUsuarioRecorrido != null && !oldIdUsuarioOfTbUsuarioRecorridoListNewTbUsuarioRecorrido.equals(tbUsuarios)) {
                        oldIdUsuarioOfTbUsuarioRecorridoListNewTbUsuarioRecorrido.getTbUsuarioRecorridoList().remove(tbUsuarioRecorridoListNewTbUsuarioRecorrido);
                        oldIdUsuarioOfTbUsuarioRecorridoListNewTbUsuarioRecorrido = em.merge(oldIdUsuarioOfTbUsuarioRecorridoListNewTbUsuarioRecorrido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tbUsuarios.getIdUsuario();
                if (findTbUsuarios(id) == null) {
                    throw new NonexistentEntityException("The tbUsuarios with id " + id + " no longer exists.");
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
            TbUsuarios tbUsuarios;
            try {
                tbUsuarios = em.getReference(TbUsuarios.class, id);
                tbUsuarios.getIdUsuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tbUsuarios with id " + id + " no longer exists.", enfe);
            }
            List<TbUsuarioRecorrido> tbUsuarioRecorridoList = tbUsuarios.getTbUsuarioRecorridoList();
            for (TbUsuarioRecorrido tbUsuarioRecorridoListTbUsuarioRecorrido : tbUsuarioRecorridoList) {
                tbUsuarioRecorridoListTbUsuarioRecorrido.setIdUsuario(null);
                tbUsuarioRecorridoListTbUsuarioRecorrido = em.merge(tbUsuarioRecorridoListTbUsuarioRecorrido);
            }
            em.remove(tbUsuarios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TbUsuarios> findTbUsuariosEntities() {
        return findTbUsuariosEntities(true, -1, -1);
    }

    public List<TbUsuarios> findTbUsuariosEntities(int maxResults, int firstResult) {
        return findTbUsuariosEntities(false, maxResults, firstResult);
    }

    private List<TbUsuarios> findTbUsuariosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbUsuarios.class));
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

    public TbUsuarios findTbUsuarios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbUsuarios.class, id);
        } finally {
            em.close();
        }
    }

    public int getTbUsuariosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TbUsuarios> rt = cq.from(TbUsuarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
