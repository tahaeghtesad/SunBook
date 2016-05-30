package ir.arcinc.sunbook.datamodel;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Zohreh on 5/30/2016.
 */
@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToMany(mappedBy = "skills")
    private Set<User> users;

    public Skill(String name) {
        this.name = name;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
