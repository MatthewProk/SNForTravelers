package servlet;

import DAO.hibernateDAO.MessageDAOHibernate;
import DAO.hibernateDAO.UserDAOHibernate;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "MessageServlet")
public class MessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageDAOHibernate messageDAO = new MessageDAOHibernate();
        User receiver = Optional.ofNullable(new UserDAOHibernate().getUserByLogin(request.getParameter("receiverLogin"))).get().orElse(null);
        request.getSession().setAttribute("receiver", receiver);
        request.setAttribute("messagesList", messageDAO.getMessageList((User)request.getSession().getAttribute("user"),receiver));
        request.getRequestDispatcher("/message.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
