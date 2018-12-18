package app.controller.servlets;

import app.controller.service.UserService;
import app.controller.service.impl.UserServiceImpl;
import app.dao.UserDao;
import app.dao.impl.UserDatabaseDao;
import app.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService = new UserServiceImpl();
        List<User> users = userService.findAll();

        List<String>user = new ArrayList<>();

        if(users != null)
        {
        for(User u : users)
        {
            user.add(u.getMail());
        }
        }

        req.setAttribute("user",user);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/list.jsp");
        requestDispatcher.forward(req,resp);
    }
}
