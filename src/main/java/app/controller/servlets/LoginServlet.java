package app.controller.servlets;

import app.controller.service.UserService;
import app.controller.service.impl.UserServiceImpl;
import app.exception.ServiceException;
import app.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class LoginServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException
    {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String wrongData = "Wrong data !";
        String mail = req.getParameter("mail");
        String pass = req.getParameter("pass");
        try {
        if(Objects.nonNull(mail) && Objects.nonNull(pass)) {

            UserService userService = new UserServiceImpl();
            User user = userService.findByMailAndPass(mail, pass);

            if(Objects.nonNull(user.getMail()) && Objects.nonNull(user.getPassword()))
            {

                req.getSession().setAttribute("user",user);

                if(user.getAccessLevel() == 2)
                {
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/user_page.jsp");
                    requestDispatcher.forward(req, resp);
                }
                else if(user.getAccessLevel() == 3)
                {
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/admin_page.jsp");
                    requestDispatcher.forward(req, resp);
                }
                else
                    {
                        System.out.println("wrong access level");
                        throw new ServiceException();
                    }
            }
            else
                {
                    System.out.println("wrong null fields");
                    throw new ServiceException();
                }

            }
        }catch (Exception ex)
        {
            req.setAttribute("wrongData",wrongData);
            doGet(req,resp);
        }

    }
}
