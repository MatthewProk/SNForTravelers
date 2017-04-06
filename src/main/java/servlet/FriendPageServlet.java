package servlet;

import DAO.hibernateDAO.UserDAOHibernate;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "FriendPageServlet")
public class FriendPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User friend = Optional.ofNullable(new UserDAOHibernate().getUserByLogin(request.getParameter("friendLogin"))).get().orElse(null);
        request.getSession().setAttribute("friend", friend);
        request.getRequestDispatcher("/friendPage.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
