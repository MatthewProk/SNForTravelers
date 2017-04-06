package servlet;

import DAO.hibernateDAO.FriendDAOHibernate;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDAOHibernate userDAO = new UserDAOHibernate();
        FriendDAOHibernate friendDAO = new FriendDAOHibernate();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = Optional.ofNullable(userDAO.getUserByLogin(login))
                .get().orElse(null);

        if (user != null) {
            if (user.getPassword().equals(password)) {
                request.getSession().setAttribute("user", user);

                List<User> friendList = friendDAO.getAllFriendsOfUser((User) request.getSession()
                        .getAttribute("user"));
                request.getSession().setAttribute("friendsList", friendList);

                request.getSession().removeAttribute("isIncorrect");
                response.sendRedirect("/mypage.jsp");
            } else {
                request.getSession().setAttribute("isIncorrect", "true");
                response.sendRedirect("/login.jsp");
            }
        }else{
            request.getSession().setAttribute("isIncorrect", "true");
            response.sendRedirect("/login.jsp");
        }
    }
}

