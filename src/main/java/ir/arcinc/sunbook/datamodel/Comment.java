package ir.arcinc.sunbook.datamodel;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tahae on 5/30/2016.
 */
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private SimplePost post;

    @OneToOne(cascade = CascadeType.MERGE)
    private User commenter;

    @CreatedDate
    private Date creationDate;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<User> likes;

    public Comment(SimplePost post, User commenter, Date creationDate) {
        this.post = post;
        this.commenter = commenter;
        this.creationDate = creationDate;
        this.likes = new ArrayList<User>();
    }

    public Comment(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getCommenter() {
        return commenter;
    }

    public void setCommenter(User commenter) {
        this.commenter = commenter;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<User> getLikes() {
        return likes;
    }

    public void setLikes(List<User> likes) {
        this.likes = likes;
    }
}
