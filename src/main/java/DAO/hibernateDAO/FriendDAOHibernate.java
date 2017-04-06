package DAO.hibernateDAO;

import DAO.FriendshipDAO;
import hibernate.HibernateUtil;
import model.Friendship;
import model.User;
import org.hibernate.Session;
import org.jboss.logging.Logger;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class FriendDAOHibernate implements FriendshipDAO {

    public static final Logger logger = Logger.getLogger(FriendDAOHibernate.class);

    @Override
    public void saveFriendship(Friendship friendship) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(friendship);

            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Can't save or update Friendship" + e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List<User> getAllFriendsOfUser(User user) {

        Session session = null;
        String login = user.getLogin();
        List<User> friendsList = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Friendship where initiator.login='" + login + "'");
            session.getTransaction().commit();
            List<Friendship> friendships = query.getResultList();

            friendsList.addAll(friendships.stream().map(Friendship::getFriend).collect(Collectors.toList()));

        } catch (Exception e) {
            logger.error("Can't get all friends of user" + e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return friendsList;
    }

    @Override
    public void deleteFriend(User init, User friend) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createQuery("delete  from Friendship " +
                    "where initiator.login ='" + init.getLogin() + "' and friend.login='" + friend.getLogin() + "'");
            query.executeUpdate();

            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Can't delete Friendship " + e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
