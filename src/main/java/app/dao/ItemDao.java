package app.dao;

import app.model.User;

import java.util.List;

public interface ItemDao<T,K>
{
   boolean add(T t);
   T update(List<T> t);
   boolean delete(T user);

   User findById(K id);
   User findByMail(String mail);
   List<T> findAll();
}
