package repository;

import java.util.List;

public interface Repository<T>{
    T saveOrUpdate(T entity);
    void delete(Long id);
    List<T> getAll();
    T getById(Long id);
    T findByName(T entity);
}
