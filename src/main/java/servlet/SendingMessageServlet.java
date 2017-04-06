package servlet;

import DAO.hibernateDAO.MessageDAOHibernate;
import model.Message;
import model.User;
import org.jboss.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "SendingMessageServlet")
public class SendingMessageServlet extends HttpServlet {
    public static final Logger logger = Logger.getLogger(SendingMessageServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MessageDAOHibernate messageDAO = new MessageDAOHibernate();
        String textMessage = request.getParameter("textMessage");

        User receiver = (User) request.getSession().getAttribute("receiver");
        User sender = (User) request.getSession().getAttribute("user");

        Message message = new Message(sender, receiver, textMessage,new Date());
        messageDAO.sendMessage(message);

//        request.setAttribute("messagesList", messageDAO.getMessageList(sender,receiver));
        request.getRequestDispatcher("/messageIsSent.jsp").forward(request,response);
        logger.info("Message successful send");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
