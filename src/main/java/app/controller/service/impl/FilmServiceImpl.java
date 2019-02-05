package app.controller.service.impl;

import app.controller.service.FilmService;
import app.dao.FilmDao;
import app.dao.impl.FilmDatabaseDao;
import app.exception.DataBaseException;
import app.exception.ServiceException;
import app.model.Film;

import java.util.List;

public class FilmServiceImpl implements FilmService
{
    private final FilmDao filmDao = new FilmDatabaseDao();
    @Override
    public boolean add(Film film) {
        try {
            return filmDao.add(film);
        }catch (DataBaseException ex)
        {
            throw new ServiceException();
        }
    }

    @Override
    public Film update(List<Film> films) {
        return filmDao.update(films);
    }

    @Override
    public boolean delete(Film user) {
        return filmDao.delete(user);
    }

    @Override
    public Film findById(String id) {
        try {
            return filmDao.findById(id);
        }catch (DataBaseException ex)
        {
            throw new ServiceException();
        }
    }

    @Override
    public List<Film> findAll() {
        return filmDao.findAll();
    }

}
