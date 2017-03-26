package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getSession().removeAttribute("invalidEmail");
//        request.getSession().removeAttribute("invalidPassword");
//        String login = request.getParameter("email");
//        String password = request.getParameter("password");
//        User user;
//        RequestDispatcher requestDispatcher;
//        user = Optional.ofNullable(userDao.getUserByLogin(login)).get().orElse(null);
//        if (user != null)
//            if (user.getPassword().equals(password)) {
//                logger.log(Level.INFO,"User  entered");
//                request.getSession().setAttribute("user", user);
//                request.getSession().setAttribute("id", user.getId());
//                request.getSession().setAttribute("firstName", user.getFirstName());
//                request.getSession().setAttribute("lastName", user.getLastName());
//                request.getSession().setAttribute("patronymic", user.getPatronymic());
//                request.getSession().setAttribute("dob", user.getDob());
//                request.getSession().setAttribute("gender", user.getGender_code());
//                request.getSession().setAttribute("telephone", user.getTelephone());
//                request.getSession().setAttribute("email", user.getEmail());
//                request.getSession().setAttribute("password", user.getPassword());
//                request.getSession().setAttribute("height", user.getHeight());
//                request.getSession().setAttribute("weight", user.getWeight());
//                request.getSession().setAttribute("country", user.getCountry());
//                request.getSession().setAttribute("city", user.getCity());
//                request.getSession().setAttribute("status", user.getStatus_code());
//                request.getSession().setAttribute("rating", user.getRating());
//                requestDispatcher = request.getRequestDispatcher("/friends.jsp");
//                List<User> ratingList = userDao.rating();
//                List<Integer> friendsId = friendDao.getFriendsId(user.getId());
//                List<User> friends = new ArrayList<>();
//                friendsId.stream().forEach(id -> friends.add(userDao.get(id).get()));
//                request.getSession().setAttribute("friends", friends);
//                request.getSession().setAttribute("ratingList", ratingList);
//            } else {
//                request.getSession().setAttribute("invalidPassword", "Yes");
//                requestDispatcher = request.getRequestDispatcher("/login.jsp");
//            }
//        else {
//            request.getSession().setAttribute("invalidEmail", "Yes");
//            requestDispatcher = request.getRequestDispatcher("/login.jsp");
//        }
//        requestDispatcher.forward(request, response);
//
//    }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
