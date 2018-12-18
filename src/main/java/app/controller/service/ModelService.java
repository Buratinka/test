package app.controller.service;

import app.model.Model;

import java.util.List;

public interface ModelService<K, T extends Model>
{
    boolean add(T t);
    T update(List<T> t);
    boolean delete(T user);

    T findById(K id);
    T findByMail(String mail);
    List<T> findAll();
}
