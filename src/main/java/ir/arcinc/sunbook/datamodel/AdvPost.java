package ir.arcinc.sunbook.datamodel;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by tahae on 6/1/2016.
 */
@Entity
@Table(name = "POST")
@DiscriminatorValue("ADV")
public class AdvPost extends AbstractPost {
    public AdvPost(User poster, Date creationDate, Adv adv) {
        super(poster, creationDate);
        this.adv = adv;
    }
    public AdvPost(){
        super(new User(),new Date());
    }

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Adv adv;

    public Adv getAdv() {
        return adv;
    }

    public void setAdv(Adv adv) {
        this.adv = adv;
    }
}
