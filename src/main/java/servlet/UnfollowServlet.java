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
import java.util.Optional;

@WebServlet(name = "UnfollowServlet")
public class UnfollowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDAOHibernate userDAO = new UserDAOHibernate();
        User initiator = (User)request.getSession().getAttribute("user");
        User friend = Optional.ofNullable(userDAO.getUserByLogin(request.getParameter("login"))).get().orElse(null);
        new FriendDAOHibernate().deleteFriend(initiator,friend);
        request.getRequestDispatcher("/mypage.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
