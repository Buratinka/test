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
import java.util.Objects;

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
        String wrongData = "Wrong data !";
        String wrongAge = "Wrong age! You must be over 9 years old.";
        String successData = "Success !";

try {
    String pass = req.getParameter("pass");
    String mail = req.getParameter("mail");
    int age = Integer.parseInt(req.getParameter("age"));

    if(age < 10)
    {
        req.setAttribute("wrongAge", wrongAge);
        doGet(req, resp);
    }
        if (!pass.equals("") && !mail.equals("")){
        User user = new User(mail, pass, age);
        UserService userService = new UserServiceImpl();
        userService.add(user);


        req.setAttribute("successData", successData);
        doGet(req, resp);
        }
        else
            {
                throw new NullPointerException();
            }

} catch (NullPointerException ex)
{
    req.setAttribute("wrongData", wrongData);
    doGet(req, resp);
}
    }
}
