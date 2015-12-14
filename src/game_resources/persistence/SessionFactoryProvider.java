package game_resources.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Creates Sessions for use in Hibernate database transactions.
 *
 * @author      Jen Williams, via Paula Waite
 * @version     1.0     11/12/2015
 */
public class SessionFactoryProvider {

    /**
     * The self-generated shared 'SessionFactory' object.
     */
    private static SessionFactory sessionFactory;

    /**
     * Shared method that instantiates the shared 'SessionFactory' object.
     */
    public static void createSessionFactory() {

        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()).buildServiceRegistry();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

    }

    /**
     * Shared method that returns the shared 'SessionFactory' object.
     *
     * @return  The shared 'SessionFactory' object.
     */
    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            createSessionFactory();

        }

        return sessionFactory;

    }

}
