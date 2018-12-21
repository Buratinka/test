package app.dao;

import app.model.User;

public interface UserDao extends ItemDao<User,Integer>
{
    User findByMailAndPass(String mail,String pass);
}
