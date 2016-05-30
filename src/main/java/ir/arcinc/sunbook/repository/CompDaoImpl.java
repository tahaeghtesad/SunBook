package ir.arcinc.sunbook.repository;

import ir.arcinc.sunbook.datamodel.Company;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by Zohreh on 5/30/2016.
 */
@Repository
@Transactional
public class CompDaoImpl implements CompDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Company create(Company o) {
        em.persist(o);
        em.flush();
        return o;
    }

    @Override
    public Company find(Long id) {
        return em.find(Company.class,id);
    }

    @Override
    public void update(Company o) {
        em.persist(o);
        em.flush();
    }

    @Override
    public void delete(Company o) {
        em.remove(o);
        em.flush();
    }
}
