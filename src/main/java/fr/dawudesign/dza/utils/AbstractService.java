package fr.dawudesign.dza.utils;

public interface AbstractService <T> {
    Iterable<T> findAll();
    T findById(Long id);
    T save(T t);
    T update(Long id, T t);
    void deleteById(Long id);

}
