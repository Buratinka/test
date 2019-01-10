package app.controller.utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletUtil
{

    public static void goToPage(HttpServletRequest req, HttpServletResponse res, String url) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(url);
        try{
            requestDispatcher.forward(req,res);
        }catch (ServletException|IOException ex)
        {}
    }
    public static String getUserPageByRole(int accessLevel) {
        String page = "";

        switch(accessLevel)
        {
            case 2 : page = "WEB-INF/view/user_page.jsp";
            break;
            case 3 : page = "WEB-INF/view/admin_page.jsp";
            break;
            default:
        }

        return page;
    }
}
