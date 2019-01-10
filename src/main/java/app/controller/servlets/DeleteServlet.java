package app.controller.servlets;

import app.controller.service.UserService;
import app.controller.service.impl.UserServiceImpl;
import app.controller.utils.ValidationData;
import app.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet
{
    private static ValidationData validationData;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/login.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String wrongData = "Empty some field!";
        String mail = req.getParameter("mail");
        String pass = req.getParameter("pass");

        if(validationData.isValidParam(pass,mail)) {
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
