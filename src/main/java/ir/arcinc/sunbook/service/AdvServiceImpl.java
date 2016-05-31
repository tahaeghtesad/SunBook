package ir.arcinc.sunbook.service;

import ir.arcinc.sunbook.datamodel.Adv;
import ir.arcinc.sunbook.datamodel.Company;
import ir.arcinc.sunbook.repository.AdvDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Zohreh on 5/25/2016.
 */
@Service
public class AdvServiceImpl implements AdvService{
    @Autowired
    private AdvDao advDao;

    @Override
    @Transactional
    public Adv create(Adv o) {
        return advDao.create(o);
    }

    @Override
    @Transactional
    public Adv find(Long id) {
        return advDao.find(id);
    }

    @Override
    @Transactional
    public void update(Adv o) {
        advDao.update(o);
    }

    @Override
    @Transactional
    public void delete(Adv o) {
        advDao.delete(o);
    }

    @Override
    public List getAdvByDate(Date date) {
        return null;
    }

    @Override
    public List<Adv> getAdvByOstan(String ostan) {
        return null;
    }

    @Override
    public List<Adv> getAdvByCompany(Company company) {
        return null;
    }

    @Override
    public List<Adv> getAdvByType(int type) {
        return null;
    }

    @Override
    public List<Adv> getAdvBySalaryType(int salarytype) {
        return null;
    }

    @Override
    public List<Adv> getAllAdvs() {
        return advDao.getAllAdvs();
    }
}
