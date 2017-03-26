package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionfFactory();

    private static SessionFactory buildSessionfFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure(
                    new File("E:/EPAMCourse/SocialNetwork/src/main/resources/hibernate.cfg.xml")).buildSessionFactory();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

//    private static SessionFactory sessionFactory ;
//    static {
//        Configuration configuration = new Configuration().configure();
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//        sessionFactory = configuration.buildSessionFactory(builder.build());
//    }
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }


}
