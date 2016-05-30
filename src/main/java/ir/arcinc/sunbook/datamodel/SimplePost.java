package ir.arcinc.sunbook.datamodel;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by tahae on 5/30/2016.
 */
@Entity
public class SimplePost extends AbstractPost {
    private String text;

    public SimplePost(){
        super(new User(),new Date());
        text = "";
    }

    public SimplePost(User poster, Date creationDate, String text) {
        super(poster, creationDate);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
