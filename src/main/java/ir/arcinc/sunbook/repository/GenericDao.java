package ir.arcinc.sunbook.repository;

import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * Created by tahae on 5/21/2016.
 */
public interface GenericDao <T,PK extends Serializable> extends Repository<T,PK>{
    T create (T o);
    T find(PK id);
    void update(T o);
    void delete(T o);
}
