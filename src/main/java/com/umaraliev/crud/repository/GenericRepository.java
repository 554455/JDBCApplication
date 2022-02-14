package com.umaraliev.crud.repository;

import java.sql.SQLException;
import java.util.List;

public interface GenericRepository<T, ID> {
    
    T getById(ID id);

    List<T> getAll();

    T save(T t);

    T update(T t);

    void deleteById(ID id);
}
