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

public class RegistrationServlet extends HttpServlet
{
    private static ValidationData validationData;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/registration.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String wrongData = "Wrong Data !";
        String wrongAge = "Incorrect age !";
        String pass = req.getParameter("pass");
        String mail = req.getParameter("mail");
        int age = Integer.parseInt(req.getParameter("age"));




        if(!validationData.isValidParam(pass,mail,age)) {
            req.setAttribute("wrongData", wrongData);
            doGet(req, resp);
        }
        else if(!validationData.isValidAge(age))
        {
            req.setAttribute("wrongAge",wrongAge);
            doGet(req,resp);
        }
        else
            {
                User user = new User(mail,pass,age);
                UserService userService = new UserServiceImpl();
                userService.add(user);


                req.setAttribute("userData", mail);
                doGet(req, resp);
            }
    }
}
