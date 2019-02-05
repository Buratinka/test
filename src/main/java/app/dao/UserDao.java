package app.dao;

import app.model.User;

public interface UserDao extends ItemDao<User,Integer>
{
    User findByMail(String mail);
    User findByMailAndPass(String mail,String pass);
}
