package servlet;

import DAO.hibernateDAO.MessageDAOHibernate;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReceivedMessagesServlet")
public class ReceivedMessagesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User receiver = (User) request.getSession().getAttribute("user");
        request.setAttribute("messagesList", new MessageDAOHibernate().getAListOfReceivedMessages(receiver));
        request.getRequestDispatcher("/messagePage.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
