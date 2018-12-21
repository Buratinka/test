package app.controller.servlets;

import app.controller.service.UserService;
import app.controller.service.impl.UserServiceImpl;
import app.controller.service.utils.Validation;
import app.dao.UserDao;
import app.dao.impl.UserDatabaseDao;
import app.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet
{
    private static Validation validation;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/delete.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String wrongData = "Empty some field!";
        String mail = req.getParameter("mail");
        String pass = req.getParameter("pass");

        if(validation.isEmpty(pass,mail) == false) {
            User user = new User(mail, pass);
            UserService userService = new UserServiceImpl();
            userService.delete(user);


            req.setAttribute("deletedUserMail", mail);
            doGet(req, resp);
        }else
            {
                req.setAttribute("wrongData", wrongData);
                doGet(req, resp);
            }
    }
}
