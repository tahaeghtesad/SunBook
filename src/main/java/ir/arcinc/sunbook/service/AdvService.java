package ir.arcinc.sunbook.service;

import ir.arcinc.sunbook.datamodel.Adv;
import ir.arcinc.sunbook.datamodel.Company;

import java.util.Date;
import java.util.List;

/**
 * Created by Zohreh on 5/25/2016.
 */
public interface AdvService extends GenericService<Adv,Long> {
    List getAdvByDate(Date date);
    List<Adv> getAdvByOstan(String ostan);
    List<Adv> getAdvByCompany(Company company);
    List<Adv> getAdvByType(int type);
    List<Adv> getAdvBySalaryType(int salarytype);
    List<Adv> getAllAdvs();
}
