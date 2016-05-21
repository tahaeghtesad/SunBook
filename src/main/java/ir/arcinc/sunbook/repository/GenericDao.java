package ir.arcinc.sunbook.repository;

import java.io.Serializable;

/**
 * Created by tahae on 5/21/2016.
 */
public interface GenericDao <T,PK extends Serializable> {
    T create (T o);
    T find(PK id);
    void update(T o);
    void delete(T o);
}
