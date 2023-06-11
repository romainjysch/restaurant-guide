package ch.romainjysch.restaurantguide.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.function.Supplier;

public class Database implements AutoCloseable {

    private static Database instance;
    private final EntityManagerFactory emf;
    private final static ThreadLocal<EntityManager> em = new ThreadLocal<>();
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    private Database() {
        emf = Persistence.createEntityManagerFactory("guideRestoPersistenceUnit");
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public <T> T inTransaction(Supplier<T> function) {
        logger.info("Database # Create EntityManager");
        EntityManager em = emf.createEntityManager();
        try {
            Database.em.set(em);
            logger.info("Database # Begin transaction");
            em.getTransaction().begin();
            T t = function.get();
            logger.info("Database # Commit transaction");
            em.getTransaction().commit();
            return t;
        } finally {
            logger.info("Database # Close EntityManager");
            //em.close();
            //Database.em.remove();
        }
    }

    public void inTransaction(Runnable function) {
        logger.info("Database # Start inTransaction");
        EntityManager em = emf.createEntityManager();
        try {
            Database.em.set(em);
            logger.info("Database # Begin transaction");
            em.getTransaction().begin();
            function.run();
            logger.info("Database # Commit transaction");
            em.getTransaction().commit();
        } finally {
            logger.info("Database # Close EntityManager");
            //em.close();
            //Database.em.remove();
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
