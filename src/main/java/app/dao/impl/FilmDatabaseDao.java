package app.dao.impl;

import app.dao.FilmDao;
import app.model.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDatabaseDao implements FilmDao {

    private static final String DB_URL = "jdbc:postgresql:servlets";
    private static final String ID = "postgres";
    private static final String PASS = "4f1d18e0";

    private static final String CREATE = "INSERT INTO film(id_name,duration,type_id) VALUES(?,?,?)";
    private static final String UPDATE = "UPDATE film SET duration = ? , type_id = ? WHERE id_name = ?";
    private static final String DELETE = "DELETE FROM film WHERE id_name = ?";
    private static final String FIND_BY_ID = "SELECT * FROM film WHERE id_name = ?";
    private static final String FIND_ALL = "SELECT * FROM film ORDER BY id_name";

    @Override
    public boolean add(Film film) {

        try(Connection connection = DriverManager.getConnection(DB_URL,ID,PASS);PreparedStatement preparedStatement = connection.prepareStatement(CREATE))
        {
            preparedStatement.setString(1,film.getName());
            preparedStatement.setInt(2,film.getDuration());
            preparedStatement.setString(3, film.getType().toString());
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException ex)
        {
            throw new RuntimeException(String.format("Can't create film by id_name = ?",film.getName()));
        }


    }

    @Override
    public Film update(List<Film> films) {

        Film oldFilm = films.get(0);
        Film newFilm = films.get(1);

        try(Connection connection = DriverManager.getConnection(DB_URL,ID,PASS);PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
            preparedStatement.setInt(1,newFilm.getDuration());
            preparedStatement.setString(2, String.valueOf(newFilm.getType()));
            preparedStatement.setString(3,oldFilm.getName());
            preparedStatement.executeUpdate();
            return newFilm;
        }catch (SQLException ex)
        {
            throw new RuntimeException(String.format("Can't update film by id_name = ?",oldFilm.getName()));
        }
    }

    @Override
    public boolean delete(Film film) {
        try(Connection connection = DriverManager.getConnection(DB_URL,ID,PASS);PreparedStatement preparedStatement = connection.prepareStatement(DELETE))
        {
            preparedStatement.setString(1, film.getName());
            preparedStatement.executeUpdate();
            return true;

        }catch (SQLException ex)
        {
            throw new RuntimeException(String.format("Can't delete film by id_name = ?",film.getName()));
        }
    }

    @Override
    public Film findById(String id_name) {
        try(Connection connection = DriverManager.getConnection(DB_URL,ID,PASS); PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID))
        {
            preparedStatement.setString(1,id_name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                int duration = resultSet.getInt("duration");
                String type = resultSet.getString("type_id");

                return new Film(id_name,duration,type);
            }else
                return null ;
        }catch (SQLException ex)
        {
            throw new RuntimeException(String.format("Cannot find film by id_name = ?",id_name),ex);
        }
    }

    @Override
    public List<Film> findAll() {
        List<Film> films = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(DB_URL,ID,PASS); PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL))
        {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                int duration = resultSet.getInt("duration");
                String type = resultSet.getString("type_id");

                films.add(new Film(duration,type));
            }
        }
        catch (SQLException ex)
        {
            throw new RuntimeException("Cannot find all",ex);
        }
        return films;
    }
}
