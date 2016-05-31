package ir.arcinc.sunbook.datamodel;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Zohreh on 5/25/2016.
 */
@Entity
public class Adv {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Company company;
    private String ostan;
    private Date date;
    private int salaryType;
    private int type;
    private String text;
    private String title;

    public Adv() {
    }

    public Adv(String title, Company company, String ostan, Date date, int salaryType, int type, String text) {
        this.title = title;
        this.company = company;
        this.ostan = ostan;
        this.date = date;
        this.salaryType = salaryType;
        this.type = type;
        this.text = text;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getOstan() {
        return ostan;
    }

    public void setOstan(String ostan) {
        this.ostan = ostan;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(int salaryType) {
        this.salaryType = salaryType;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Adv{" +
                "id=" + id +
                ", company=" + company +
                ", ostan='" + ostan + '\'' +
                ", date=" + date +
                ", salaryType=" + salaryType +
                ", type=" + type +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
