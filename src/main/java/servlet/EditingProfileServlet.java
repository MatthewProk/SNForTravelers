package servlet;

import DAO.hibernateDAO.UserDAOHibernate;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditingProfileServlet")
public class EditingProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        Integer age = Integer.parseInt(request.getParameter("age"));
        String telephone = request.getParameter("telephone");
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        String aboutSelf = request.getParameter("aboutSelf");
        User user = (User)request.getSession().getAttribute("user");
        new UserDAOHibernate().updateUser(user, firstName, lastName, email, telephone, age,
                country,city,aboutSelf);
        request.getSession().setAttribute("user", user);
        request.getRequestDispatcher("/editingProfile.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
