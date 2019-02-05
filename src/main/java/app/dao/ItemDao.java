package app.dao;

import app.model.User;

import java.util.List;

public interface ItemDao<T,K>
{
   boolean add(T t);
   T update(List<T> t);
   boolean delete(T t);
   T findById(K id);

   List<T> findAll();
}
