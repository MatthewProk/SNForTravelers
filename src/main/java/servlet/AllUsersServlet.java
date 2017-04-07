package servlet;

import DAO.hibernateDAO.UserDAOHibernate;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AllUsersServlet")
public class AllUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> usersList = new UserDAOHibernate().getAllUsers();
        List<User> friendsList = (List<User>) request.getSession().getAttribute("friendsList");
        List<User> otherUsers = new ArrayList<>();
        for(User u:usersList){
            if(!friendsList.contains(u)){
                otherUsers.add(u);
            }
        }
        request.getSession().setAttribute("lusersList",otherUsers);
        request.getRequestDispatcher("/allUsers.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
