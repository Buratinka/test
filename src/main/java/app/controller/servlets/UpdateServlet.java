package app.controller.command;

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

public class UpdateServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/update.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String wrongData = "Wrong data !";
        String oldMail = req.getParameter("mail");
        String oldPass = req.getParameter("pass");
        String newMail = req.getParameter("newMail");
        String newPass = req.getParameter("newPass");

        if(!oldMail.equals("") && !oldPass.equals("") && !newMail.equals("") && !newPass.equals("")) {
        User oldUser = new User(oldMail,oldPass);
        User newUser = new User(newMail,newPass);

            List<User> users = new ArrayList<>();
            users.add(oldUser);
            users.add(newUser);

            UserDao userDao = new UserDatabaseDao();
            userDao.update(users);

            req.setAttribute("oldMail", oldMail);
            doGet(req, resp);
        }
        else
            {
                req.setAttribute("wrongData", wrongData);
                doGet(req, resp);
            }
    }
}
