package DAO.hibernateDAO;

import DAO.MessageDAO;
import hibernate.HibernateUtil;
import model.Message;
import model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import java.util.List;

public class MessageDAOHibernate implements MessageDAO {

    public static final Logger logger = Logger.getLogger(FriendDAOHibernate.class);

    @Override
    public void sendMessage(Message message) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(message);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Can't save message " + e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List<Message> getMessageList(User sender, User receiver) {
        Session session = null;
        List<Message> messagesList = null;
        String senderLogin = sender.getLogin();
        String receiverLogin = receiver.getLogin();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query =
                    session.createQuery("from Message " +
                            "where sender.login='" + senderLogin + "' and receiver.login ='" + receiverLogin + "'" +
                            "or sender.login='" + receiverLogin + "' and receiver.login ='" + senderLogin + "'");
            session.getTransaction().commit();
            messagesList = query.getResultList();

        } catch (Exception e) {
            logger.error("Can't get list of messages " + e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return messagesList;
    }

    public void deleteMessage(String textMessage) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Query query =  session.createQuery("delete  from Message " +
                    "where textMessage ='" + textMessage + "'");
            query.executeUpdate();

            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Can't delete Friendship " + e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
//            HibernateUtil.shutdown();
        }
    }

    public List<Message> getAListOfSentMessages(User sender) {
        Session session = null;
        List<Message> messagesList = null;
        String senderLogin = sender.getLogin();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query =
                    session.createQuery("from Message " +
                            "where sender.login='" + senderLogin + "'");
            session.getTransaction().commit();
            messagesList = query.getResultList();

        } catch (Exception e) {
            logger.error("Can't get list of messages " + e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return messagesList;
    }

    public List<Message> getAListOfReceivedMessages(User receiver) {
        Session session = null;
        List<Message> messagesList = null;
        String receiverLogin = receiver.getLogin();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query =
                    session.createQuery("from Message " +
                            "where receiver.login='" + receiverLogin + "'");
            session.getTransaction().commit();
            messagesList = query.getResultList();

        } catch (Exception e) {
            logger.error("Can't get list of messages " + e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return messagesList;
    }


}
