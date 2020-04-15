package dao;

import entity.ParameterEntity;
import java.util.Collection;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.sql.DataSource;

@Singleton
public class DbManager implements DbManagerLocal {
    
    @Resource(name = "jdbc/datastorage")
    private DataSource ds;
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void createParameter(ParameterEntity param) {
        em.persist(param);
    }

    @Override
    public Collection<ParameterEntity> getAllParameters() {
        return em.createNamedQuery("ParameterEntity.getAll").getResultList();
    }

    @Override
    public Collection<ParameterEntity> getParametersByNameTemplate(String nameTemplate) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ParameterEntity> q = cb.createQuery(ParameterEntity.class);
        Root<ParameterEntity> p = q.from(ParameterEntity.class);
        q.select(p).where(cb.like(p.get("name"), "%" + nameTemplate + "%")); 
        TypedQuery<ParameterEntity> query = em.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Collection<ParameterEntity> getParametersByValInterval(int lowerBound, int upperBound) {
        return em.createNamedQuery("ParameterEntity.findByValInterval")
                .setParameter("lowerBound", lowerBound)
                .setParameter("upperBound", upperBound)
                .getResultList();
    }

    @Override
    public Collection<ParameterEntity> getParameterByName(String name) {
        return em.createNamedQuery("ParameterEntity.findByName")
                 .setParameter("name", name)
                .getResultList();
    }

}
