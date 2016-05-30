package ir.arcinc.sunbook.datamodel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

/**
 * Created by tahae on 5/21/2016.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String firstName, lastName;
    @ManyToOne
    private Company company;

    @Column(unique = true)
    @NotNull
    private String email;

    public String password;
    private String naghsh , city , ostan , university , field , userName;
    @ManyToMany
    @JoinTable(name="EMP_SKILL",joinColumns=@JoinColumn(name="EMP_ID", referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="SKILL_ID", referencedColumnName="id"))
    private Set<Skill> skills;

    @ManyToMany
    @JoinTable(name="EMP_PROJ",joinColumns=@JoinColumn(name="EMP_ID", referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="PROJ_ID", referencedColumnName="id"))
    private Set<Project> projects;

    public User(String firstName, String lastName, String userName, Company company, String email, String password, String naghsh, Set<Project> projects , String city , String ostan  , String university ,String field, Set<Skill> skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.company = company;
        this.email = email;
        this.password = password;
        this.naghsh = naghsh;
        this.projects = projects;
        this.city = city;
        this.ostan = ostan;
        this.university = university;
        this.field = field;
        this.skills = skills;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getNaghsh() {
        return naghsh;
    }

    public void setNaghsh(String naghsh) {
        this.naghsh = naghsh;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public String getOstan() {
        return ostan;
    }

    public void setOstan(String ostan) {
        this.ostan = ostan;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + "\'" +
                '}';
    }
}
