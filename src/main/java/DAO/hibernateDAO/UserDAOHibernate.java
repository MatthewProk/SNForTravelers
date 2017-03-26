package DAO.hibernateDAO;

import DAO.UserDAO;
import hibernate.HibernateUtil;
import model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.text.ParseException;
import java.util.List;

public class UserDAOHibernate implements UserDAO {

    public List<User> getAllUsers() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("FROM User ");
        List<User> results = query.list();

        session.getTransaction().commit();
        HibernateUtil.shutdown();
        return results;
    }

    public boolean loginFree(String login) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT us.id FROM User us where login=:login");
        query.setParameter("login",login);
        List<String> results = query.getResultList();

        session.getTransaction().commit();
        HibernateUtil.shutdown();

        if (results.size() != 0) {
            return false;
        }else{
            return true;
        }
    }

    public void addUser(String firstName, String lastName, String login,
                        String password, String email, String genderType) throws ParseException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setGenderType(genderType);

        session.save(user);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }

    public void deleteUser() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("DELETE from User where login = 'maxkak'");
        query.executeUpdate();

        session.getTransaction().commit();
        HibernateUtil.shutdown();

    }


    public static void main(String[] args) {

        System.out.println(new UserDAOHibernate().loginFree("da"));
//        System.out.println(new UserDAOHibernate().getAllLogins());

    }
}

