package ir.arcinc.sunbook.datamodel;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Zohreh on 5/25/2016.
 */
@Entity
public class Company {
    private String name;
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long id;
    @OneToMany(mappedBy="company", cascade = CascadeType.MERGE)
    private Set<Adv> Advs;
    private String type;
    private String city;
    private String ostan;
    private String exp;
    private String manager;
    @OneToMany(mappedBy="company", cascade = CascadeType.MERGE)
    private Set<Project> projects;
    @OneToMany(mappedBy="company", cascade = CascadeType.MERGE)
    private Set<User> employee;

    public Company(){}

    public Company(String name, Set<Adv> advs, String type, String city, String ostan, String exp, String manager, Set<Project> projects, Set<User> employee) {
        this.name = name;
        Advs = advs;
        this.type = type;
        this.city = city;
        this.ostan = ostan;
        this.exp = exp;
        this.manager = manager;
        this.projects = projects;
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Adv> getAdvs() {
        return Advs;
    }

    public void setAdvs(Set<Adv> advs) {
        Advs = advs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOstan() {
        return ostan;
    }

    public void setOstan(String ostan) {
        this.ostan = ostan;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<User> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<User> employee) {
        this.employee = employee;
    }
}
