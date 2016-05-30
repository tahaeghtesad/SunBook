package ir.arcinc.sunbook.repository;

import ir.arcinc.sunbook.datamodel.Company;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Zohreh on 5/30/2016.
 */
@Repository()
public class CompDaoImpl implements CompDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Company create(Company o) {
        return null;
    }

    @Override
    public Company find(Long id) {
        return null;
    }

    @Override
    public void update(Company o) {

    }

    @Override
    public void delete(Company o) {

    }
}
