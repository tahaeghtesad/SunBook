package ir.arcinc.sunbook.service;

import ir.arcinc.sunbook.datamodel.Company;
import ir.arcinc.sunbook.repository.CompDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Zohreh on 5/30/2016.
 */
@Service
public class CompServiceImpl implements  CompService {
    @Autowired
    private CompDao compDao;

    @Override
    public Company create(Company o) {
        return compDao.create(o);
    }

    @Override
    public Company find(Long id) {
        return compDao.find(id);
    }

    @Override
    public void update(Company o) {
        compDao.update(o);
    }

    @Override
    public void delete(Company o) {
        compDao.delete(o);
    }
}
