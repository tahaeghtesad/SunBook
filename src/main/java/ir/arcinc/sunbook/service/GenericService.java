package ir.arcinc.sunbook.service;

import java.io.Serializable;

/**
 * Created by tahae on 5/21/2016.
 */
public interface GenericService <T, PK extends Serializable> {
    T create (T o);
    T find(PK id);
    void update(T o);
    void delete(T o);
}
