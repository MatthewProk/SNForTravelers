package DAO.hibernateDAO;

import DAO.AddressDAO;
import hibernate.HibernateUtil;
import model.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AddressDAOHibernate implements AddressDAO{

    public void addAddress(String country, String city, String street, String house, Integer flat){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Address address = new Address();
        address.setCountry(country);
        address.setCity(city);
        address.setStreet(street);
        address.setHouse(house);
        address.setFlat(flat);

        session.save(address);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }

    public List getAllAddress() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Address ");
        List<Address> results = query.list();
        session.getTransaction().commit();
        HibernateUtil.shutdown();
        return results;
    }

    public String getCountry(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("select country FROM Address ");
        List<String> arr = query.list();
        session.getTransaction().commit();
        HibernateUtil.shutdown();
        return arr.get(0);
    }


    public static void main(String[] args) {
        new AddressDAOHibernate().addAddress("USA", "NY","lol","34",3);
    }
}
