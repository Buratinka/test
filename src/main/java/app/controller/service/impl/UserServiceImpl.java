package app.controller.service.impl;

import app.controller.service.UserService;
import app.dao.UserDao;
import app.dao.impl.UserDatabaseDao;
import app.exception.DataBaseException;
import app.exception.ServiceException;
import app.exception.UserNotFoundException;
import app.model.User;

import java.util.List;

public class UserServiceImpl implements UserService
{

    private final UserDao userDao = new UserDatabaseDao();
    @Override
    public boolean add(User user) {
        try {
            return userDao.add(user);
        }catch (DataBaseException ex)
        {
            throw new ServiceException();
        }
    }

    @Override
    public User update(List<User> users) {
        return userDao.update(users);
    }

    @Override
    public boolean delete(User user) {
        return userDao.delete(user);
    }

    @Override
    public User findById(Integer id) {
        try {
            return userDao.findById(id);
        }catch (DataBaseException ex)
        {
            throw new ServiceException();
        }
    }

    @Override
    public User findByMail(String mail) {
        try {
        return userDao.findByMail(mail);
        }catch (DataBaseException ex)
        {
            throw new ServiceException();
        }
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByMailAndPass(String mail, String pass)
    {
        try {
            return userDao.findByMailAndPass(mail, pass);
        }catch (DataBaseException ex)
        {
            throw new ServiceException();
        }
    }
}
