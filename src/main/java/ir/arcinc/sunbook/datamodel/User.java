package ir.arcinc.sunbook.datamodel;

import ir.arcinc.sunbook.datamodel.AbstractUser;
import ir.arcinc.sunbook.datamodel.Company;
import ir.arcinc.sunbook.datamodel.Project;
import ir.arcinc.sunbook.datamodel.Skill;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.*;

/**
 * Created by tahae on 5/21/2016.
 */
@Entity
public class User extends AbstractUser {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    private String firstName, lastName;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Company company;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private int phoneNumber;
    private String naghsh , city , ostan , university , field;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name="EMP_SKILL",joinColumns=@JoinColumn(name="EMP_ID", referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="SKILL_ID", referencedColumnName="id"))
    private Set<Skill> skills;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name="EMP_PROJ",joinColumns=@JoinColumn(name="EMP_ID", referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="PROJ_ID", referencedColumnName="id"))
    private Set<Project> projects;

    public User(){
        super("empty","null",new LinkedList<>());
    }

    public User(String firstName, String lastName, String userName, Company company, String email, String password, String naghsh, Set<Project> projects , String city , String ostan  , String university ,String field, Set<Skill> skills) {
        super(userName, password, Arrays.asList(new SimpleGrantedAuthority("USER")));
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.email = email;
        this.naghsh = naghsh;
        this.projects = projects;
        this.city = city;
        this.ostan = ostan;
        this.university = university;
        this.field = field;
        this.skills = skills;
    }

    public User(String username, String password, Collection<? extends GrantedAuthority> authorities, String email, int phoneNumber) {
        super(username, password, authorities);
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, String email, int phoneNumber) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        return super.toString() +
                "Id: " + id + ";" +
                "Email: " + email + ";" +
                "PhoneNumber: " + phoneNumber + ";"
                ;
    }
}
