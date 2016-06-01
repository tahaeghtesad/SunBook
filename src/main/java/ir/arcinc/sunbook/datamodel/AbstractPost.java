package ir.arcinc.sunbook.datamodel;

import org.hibernate.annotations.Fetch;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by tahae on 5/30/2016.
 */
@Entity
@Table(name = "POST")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class AbstractPost {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private User poster;

    @CreatedDate
    private Date creationDate;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Collection<User> likes;

    public AbstractPost(User poster, Date creationDate) {
        this.poster = poster;
        this.creationDate = creationDate;
    }

    public AbstractPost(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Collection<User> getLikes() {
        return likes;
    }

    public void setLikes(Collection<User> likes) {
        this.likes = likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractPost that = (AbstractPost) o;

        return getId() == that.getId();

    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }

    @Override
    public String toString() {
        return "AbstractPost{" +
                "id=" + id +
                ", poster=" + poster +
                ", creationDate=" + creationDate +
                ", likes=" + likes +
                '}';
    }
}
