package game_resources.persistence;

import org.hibernate.SessionFactory;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSessionFactoryProvider {

    @Test
    public void testInstantiateSessionFactoryProvider() {
        SessionFactoryProvider sessionFactoryProvider = new SessionFactoryProvider();
        assertNotNull(sessionFactoryProvider);
    }

    @Test
    public void testGetSessionFactory() {
        SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
        assertNotNull(sessionFactory);
    }

}
