package app.controller.servlets;

import app.controller.service.UserService;
import app.controller.service.impl.UserServiceImpl;
import app.controller.service.utils.Validation;
import app.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet
{
    private static Validation validation;
    private final String userID = "admin";
    private final String password = "pass";

    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException
    {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String mail = req.getParameter("mail");
        String pass = req.getParameter("pass");
        String done = "done";

        String wrongData = "Empty field(s)!";
        if((validation.isEmpty(pass,mail) == false)&&(userID.equals(mail) && password.equals(pass)))
        {

            UserService userService = new UserServiceImpl();
            User user = userService.findByMailAndPass(mail,pass);
            //continue with login
            if(validation.isEmpty(user.getMail(),user.getPassword())==false)
            {
                req.setAttribute("done",done);
                doGet(req,resp);
            }
        }else
        {
            req.setAttribute("wrongData",wrongData);
            doGet(req,resp);
        }
    }
}
