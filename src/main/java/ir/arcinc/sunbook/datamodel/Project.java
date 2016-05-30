package ir.arcinc.sunbook.datamodel;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Zohreh on 5/30/2016.
 */
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToOne
    private Company company;
    @ManyToMany(mappedBy = "projects")
    private Set<User> team;
    private String exp;

    public Project(String name, Company company, Set<User> team, String exp) {
        this.name = name;
        this.company = company;
        this.team = team;
        this.exp = exp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<User> getTeam() {
        return team;
    }

    public void setTeam(Set<User> team) {
        this.team = team;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
}
