package DAO.hibernateDAO;

import DAO.Friendship;
import hibernate.HibernateUtil;
import model.User;
import org.hibernate.Session;

import javax.persistence.Query;

public class FriendDAOHibernate implements Friendship {

    public void deleteFriend(User init, User friend) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

//        Query query =  session.createQuery("delete  from Friendship ");
//                query.executeUpdate();

        Query query = session.createQuery("delete from Friendship ");
        query.executeUpdate();

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }

    public void addFriend() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        model.Friendship friendship = new model.Friendship();
        friendship.setFriend(new User((long) 1));
        friendship.setInitiator(new User((long) 3));

        session.save(friendship);

        session.getTransaction().commit();
        HibernateUtil.shutdown();

    }

    public static void main(String[] args) {
        FriendDAOHibernate f = new FriendDAOHibernate();
        f.addFriend();
    }
}
