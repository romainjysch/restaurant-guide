package ch.romainjysch.restaurantguide.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.function.Supplier;

public class Database implements AutoCloseable {

    private final EntityManagerFactory emf;
    private static final ThreadLocal<EntityManager> em = new ThreadLocal<>();
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    public Database() {
        emf = Persistence.createEntityManagerFactory("guideRestoPersistenceUnit");
    }

    public <T> T inTransaction(Supplier<T> function) {
        EntityManager em = emf.createEntityManager();
        try {
            Database.em.set(em);
            em.getTransaction().begin();
            T t = function.get();
            em.getTransaction().commit();
            return t;
        } catch (Exception e) {
            logger.error("Exception : ", e);
            throw new RuntimeException(e);
        } finally {
            em.close();
            Database.em.remove();
        }
    }

    public void inTransaction(Runnable function) {
        EntityManager em = emf.createEntityManager();
        try {
            Database.em.set(em);
            em.getTransaction().begin();
            function.run();
            em.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Exception : ", e);
            throw new RuntimeException(e);
        } finally {
            em.close();
            Database.em.remove();
        }
    }

    public static EntityManager getEntityManager() {
        return em.get();
    }

    @Override
    public void close() {
        try {
            emf.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
