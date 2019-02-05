package app.controller.servlets;

import app.controller.service.FilmService;
import app.controller.service.UserService;
import app.controller.service.impl.FilmServiceImpl;
import app.controller.service.impl.UserServiceImpl;
import app.exception.ServiceException;
import app.model.Film;
import app.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class LoginServlet extends HttpServlet
{
    FilmService filmService = new FilmServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Film> filmList = filmService.findAll();
        req.setAttribute("filmList", filmList);
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }
}
