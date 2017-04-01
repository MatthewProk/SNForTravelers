package servlet;

import DAO.hibernateDAO.MessageDAOHibernate;
import model.User;
import org.jboss.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteMessageServlet")
public class DeleteMessageServlet extends HttpServlet {
    public static final Logger logger = Logger.getLogger(UnfollowServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String textMessage = request.getParameter("textMessage");

        new MessageDAOHibernate().deleteMessage(textMessage);

        request.setAttribute("messagesList", new MessageDAOHibernate()
                .getMessageList((User) request.getSession().getAttribute("user")
                        ,(User) request.getSession().getAttribute("receiver")));
        request.getRequestDispatcher("/message.jsp").forward(request,response);
        logger.info("Delete message: " + textMessage);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
