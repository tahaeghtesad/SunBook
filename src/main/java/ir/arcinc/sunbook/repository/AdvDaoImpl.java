package ir.arcinc.sunbook.repository;

import ir.arcinc.sunbook.datamodel.Adv;
import ir.arcinc.sunbook.datamodel.Company;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by Zohreh on 5/25/2016.
 */
@Repository
@Transactional
public class AdvDaoImpl implements AdvDao{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Adv> getAdvByDate(Date date) {
        return em.createQuery("SELECT a FROM Adv a where a.date =: d").setParameter("d",date).getResultList();
    }

    @Override
    public List<Adv> getAdvByOstan(String ostan) {
        return em.createQuery("SELECT a FROM Adv a where a.ostan =: o").setParameter("o",ostan).getResultList();
    }

    @Override
    public List<Adv> getAdvByCompany(Company company) {
        return em.createQuery("SELECT a FROM Adv a where a.company =: c").setParameter("c",company).getResultList();
    }

    @Override
    public List<Adv> getAdvByType(int type) {
        return em.createQuery("SELECT a FROM Adv a where a.type =: t").setParameter("t",type).getResultList();
    }

    @Override
    public List<Adv> getAdvBySalaryType(int salarytype) {
        return em.createQuery("SELECT a FROM Adv a where a.salaryType =: s").setParameter("s",salarytype).getResultList();
    }

    @Override
    public List<Adv> getAllAdvs() {
        return em.createQuery("SELECT a FROM Adv a").getResultList();

    }

    @Override
    public Adv create(Adv o) {
        em.persist(o);
        em.flush();
        return o;
    }

    @Override
    public Adv find(Long id) {
        return em.find(Adv.class,id);
    }

    @Override
    public void update(Adv o) {
        em.persist(o);
        em.flush();

    }

    @Override
    public void delete(Adv o) {
        em.remove(o);
        em.flush();
    }
}
