package app.dao.impl;

import app.dao.UserDao;
import app.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserDatabaseDao implements UserDao
{

    //private static final String DRIVER_NAME = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql:servlets";
	private static final String ID = "postgres";
	private static final String PASS = "4f1d18e0";

    private static final String CREATE = "INSERT INTO users(name,pass) VALUES(?,?)";
    private static final String UPDATE = "UPDATE users SET name = ?, pass = ? WHERE name = ?AND pass = ?";
    private static final String DELETE = "DELETE FROM users WHERE name = ? AND pass = ?";
    private static final String FIND_BY_NAMES = "SELECT * FROM users WHERE name = ?";
    private static final String FIND_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM users ORDER BY id";


    @Override
    public boolean add(User user)
    {
        try(Connection connection = DriverManager.getConnection(DB_URL,ID,PASS); PreparedStatement preparedStatement = connection.prepareStatement(CREATE))
        {
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.execute();
            return true;
        }
        catch (SQLException ex)
        {
            throw new RuntimeException("Cannot add user", ex);
        }


    }

    @Override
    public User update(List<User>updaterUser)
    {

        User oldUser = updaterUser.get(0);
        User newUser = updaterUser.get(1);

        try(Connection connection = DriverManager.getConnection(DB_URL,ID,PASS); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
            preparedStatement.setString(1,newUser.getName());
            preparedStatement.setString(2,newUser.getPassword());
            preparedStatement.setString(3,oldUser.getName());
            preparedStatement.setString(4,oldUser.getPassword());
            preparedStatement.executeUpdate();
            return newUser;
        }
        catch (SQLException ex)
        {
            throw new RuntimeException("Cannot update user",ex);
        }

    }

    @Override
    public boolean delete(User user)
    {
        try(Connection connection = DriverManager.getConnection(DB_URL,ID,PASS);PreparedStatement preparedStatement = connection.prepareStatement(DELETE))
        {
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.executeUpdate();
            return true;
        }
        catch (SQLException ex)
        {
            throw new RuntimeException("Cannot delete user", ex);
        }

    }

    @Override
    public User findByNames(String name)
    {
        try(Connection connection = DriverManager.getConnection(DB_URL,ID,PASS); PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAMES))
        {
            preparedStatement.setString(1,name);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
               User user = new User();
               user.setName(resultSet.getString("name"));
               user.setPassword(resultSet.getString("pass"));
                return user;
            }else
            return null ;
        }catch (SQLException ex)
        {
            throw new RuntimeException(String.format("Cannot find user by name = ?",name),ex);
        }

    }

    @Override
    public User findById(Integer id)
    {
        try(Connection connection = DriverManager.getConnection(DB_URL,ID,PASS); PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID))
        {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("pass"));
                return user;
            }else
                return null ;
        }catch (SQLException ex)
        {
            throw new RuntimeException(String.format("Cannot find user by id = ?",id),ex);
        }
    }

    @Override
    public List<User> findAll()
    {
        List<User> users = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(DB_URL,ID,PASS); PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL))
        {

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next())
                {
                    User user = new User();
                    user.setName(resultSet.getString("name"));
                    user.setPassword(resultSet.getString("pass"));
                    users.add(user);
                }
        }
        catch (SQLException ex)
        {
            throw new RuntimeException("Cannt find all",ex);
        }
        return users;
    }
}
