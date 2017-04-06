package servlet;

import DAO.hibernateDAO.UserDAOHibernate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet(name = "UserRegistration")
public class UserRegistration extends HttpServlet {


    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String genderType = request.getParameter("genderType");
        String path = null;
        try {
            if (new UserDAOHibernate().loginFree(login)) {
                UserDAOHibernate userDAO = new UserDAOHibernate();
                userDAO.addUser(firstName, lastName, login, password, email, genderType);
//                logger.log(Level.INFO,"Registered new user");
                request.getSession().removeAttribute("freeLogin");
                request.getRequestDispatcher("/success.jsp").forward(request,response);
            } else {
                path = request.getSession().getAttribute("path").toString();
                request.getSession().setAttribute("freeLogin", "loginNotFree");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher(path).forward(request, response);
    }
}
