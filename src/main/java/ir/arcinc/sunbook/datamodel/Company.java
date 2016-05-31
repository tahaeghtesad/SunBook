package ir.arcinc.sunbook.datamodel;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Zohreh on 5/25/2016.
 */
@Entity
public class Company {
    private String name;
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long id;
    private String type;
    private String city;
    private String ostan;
    private String exp;
    private String manager;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Project> projects;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> employee;
    private String site , mail , phone, fax , addr;

    public Company(){}

    public Company(String name, String type, String city, String ostan, String exp, String manager, Set<Project> projects, Set<User> employee) {
        this.name = name;
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

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
