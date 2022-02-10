package com.umaraliev.crud.repository;

import java.sql.SQLException;
import java.util.List;

public interface GenericRepository<T, ID> {
    
    T getById(ID id) throws SQLException;

    List<T> getAll() throws SQLException, ClassNotFoundException;

    T save(T t) throws SQLException;

    T update(T t);

    void deleteById(ID id) throws SQLException;
}