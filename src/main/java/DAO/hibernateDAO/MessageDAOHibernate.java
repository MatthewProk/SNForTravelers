package DAO.hibernateDAO;

import hibernate.HibernateUtil;
import model.Message;
import model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MessageDAOHibernate {

    public void sendMessage(Message message){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(message);
        session.getTransaction().commit();
    }

    public List<Message> getMessageList(User sender, User destination) {
        Session session = null;
        List<Message> messagesList = null;
        String senderLogin = sender.getLogin();
        String destinationLogin = destination.getLogin();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query =
                    session.createQuery("from Message " +
                            "where sender.login='" + senderLogin + "' and destination.login ='" + destinationLogin + "'" +
                            "or sender.login='" + destinationLogin + "' and destination.login ='" + senderLogin + "'");
            session.getTransaction().commit();
            messagesList = query.list();

        } catch (Exception e){
//            logger.error("Can't get list of messages " + e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return messagesList;
    }

    public static void main(String[] args) {
//        new MessageDAOHibernate().sendMessage((long)1, "Привет");
    }

}
