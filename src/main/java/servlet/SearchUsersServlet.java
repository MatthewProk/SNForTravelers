package servlet;

import DAO.hibernateDAO.UserDAOHibernate;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchUsersServlet")
public class SearchUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = (List<User>) request.getSession().getAttribute("usersList");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender=request.getParameter("gender");
        User searchUser = new User();
        searchUser.setFirstName(firstName);
        searchUser.setLastName(lastName);
        searchUser.setGenderType(gender);
        List<User> founded = new UserDAOHibernate().searchUsers(searchUser);
        System.out.println("НННИИИИчего нет " + founded);
//        List<User> foundedUsers= founded.stream().filter(u -> !users.contains(u)).collect(Collectors.toList());
        request.getSession().setAttribute("usersList",founded);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/allUsers.jsp");
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
