package servlet;

import DAO.Friendship;
import DAO.UserDAO;
import DAO.hibernateDAO.UserDAOHibernate;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "Login")
public class Login extends HttpServlet {

    private UserDAO userDAO;
    private Friendship friendship;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAOHibernate userDAO = new UserDAOHibernate();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user;
        List<User> usersList = new UserDAOHibernate().getAllUsers();
        User user1 = new UserDAOHibernate().getAllUsers().get(0);
        user = Optional.ofNullable(userDAO.getUserByLogin(login)).get().orElse(null);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("u", user1);
                request.getSession().setAttribute("usersList",usersList);
                request.getSession().removeAttribute("isIncorrect");
                response.sendRedirect("/mypage.jsp");
                return;
            } else {
                request.getSession().setAttribute("isIncorrect", "true");
                response.sendRedirect("/login.jsp");
                return;
            }
        }else{
            request.getSession().setAttribute("isIncorrect", "true");
            response.sendRedirect("/login.jsp");
        }
    }
}

