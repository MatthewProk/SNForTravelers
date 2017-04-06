package DAO.hibernateDAO;

import DAO.UserDAO;
import hibernate.HibernateUtil;
import model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOHibernate implements UserDAO {

    public static final Logger logger = Logger.getLogger(UserDAOHibernate.class);

    public List<User> getAllUsers() {
        Session session = null;
        List<User> results = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM User ");
            results = query.list();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return results;
    }

    public boolean loginFree(String login) {
        Session session = null;
        List<String> results = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createQuery("SELECT us.id FROM User us where login=:login");
            query.setParameter("login", login);
            results = query.getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
//            HibernateUtil.shutdown();
        }
        if (results.size() != 0) {
            return false;
        } else {
            return true;
        }
    }

    public void addUser(String firstName, String lastName, String login,
                        String password, String email, String genderType) throws ParseException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
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
        } catch (Exception e) {
            logger.error("Can't add new user" + e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
//        HibernateUtil.shutdown();
    }

    public void updateUser(User user, String firstName, String lastName, String email, String telephone,
                           Integer age, String country, String city, String aboutSelf) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setTelephone(telephone);
            user.setAge(age);
            user.setCountry(country);
            user.setCity(city);
            user.setAboutSelf(aboutSelf);
            session.saveOrUpdate(user);

            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Can't update the user " + e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<User> searchUsers(User user) {
        List<User> foundUsers = new ArrayList<>();
        String querySQL = "FROM User WHERE id>0 ";
        if (!user.getFirstName().equals("") && user.getFirstName() != null) {
            querySQL = querySQL + "AND firstName LIKE '%" + user.getFirstName() + "%' ";
        }
        if (!user.getLastName().equals("") && user.getLastName() != null) {
            querySQL = querySQL + "AND lastName LIKE '%" + user.getLastName() + "%' ";
        }
        if (user.getGenderType().equals("Female") || user.getGenderType().equals("Male")) {
            querySQL = querySQL + "AND genderType LIKE '%" + user.getGenderType() + "%'";
        }
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createQuery(querySQL);
            foundUsers = query.getResultList();

            session.getTransaction().commit();

        } catch (Exception e) {
            logger.error("Can't search for the users " + e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
            return foundUsers;
        }
    }
}


