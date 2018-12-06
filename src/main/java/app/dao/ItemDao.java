package app.dao;

import app.model.User;

import java.util.List;

public interface ItemDao<T,K>
{
   boolean add(T t);
   T update(List<T> t);
   boolean delete(T id);

   User findById(K id);
   User findByNames(String name);
   List<T> findAll();
}
