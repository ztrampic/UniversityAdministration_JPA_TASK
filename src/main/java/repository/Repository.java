package repository;

import java.util.List;

public interface Repository<T>{
    T saveOrUpdate(T entity);
    void deleteById(Long id);
    List<T> getAll();
    T getById(Long id);
}
