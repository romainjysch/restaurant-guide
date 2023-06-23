package ch.romainjysch.restaurantguide.persistence;

import ch.romainjysch.restaurantguide.business.BasicEvaluation;

import static ch.romainjysch.restaurantguide.persistence.Database.getEntityManager;

public class DAOBasicEvaluation {

    private static DAOBasicEvaluation instance;

    private DAOBasicEvaluation() {}

    public static DAOBasicEvaluation getInstance() {
        if (instance == null)
            return new DAOBasicEvaluation();
        return instance;
    }

    public void insert(BasicEvaluation basicEvaluation) {
        getEntityManager().persist(basicEvaluation);
    }

}
