/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * This is an abstract bean in order to satisfy DRY requirements for other beans
 * @author Tejal
 */
public abstract class AbstractBean<T> {

    @PersistenceContext(unitName = "Tgajare_Final_ProjectPU")
    private EntityManager em;
    private Class<T> entityClass;

    protected EntityManager getEntityManager() {
        return this.em;
    }

    public void create(T entity) {
        em.persist(entity);
    }

    public T find(Object id) {
        return em.find(entityClass, id);
    }

    public void update(T entity) {
        em.merge(entity);
      
    }

    public void delete(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public List<T> findAll(String jpql) {
        TypedQuery<T> query = em.createQuery(jpql, entityClass);
        return query.getResultList();
    }
}
