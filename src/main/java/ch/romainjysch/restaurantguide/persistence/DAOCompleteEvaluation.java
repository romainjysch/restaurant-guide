package ch.romainjysch.restaurantguide.persistence;

import ch.romainjysch.restaurantguide.business.CompleteEvaluation;

import static ch.romainjysch.restaurantguide.persistence.Database.getEntityManager;

public class DAOCompleteEvaluation {

    private static DAOCompleteEvaluation instance;

    private DAOCompleteEvaluation() {}

    public static DAOCompleteEvaluation getInstance() {
        if (instance == null)
            instance = new DAOCompleteEvaluation();
        return instance;
    }

    public void insert(CompleteEvaluation completeEvaluation) {
        getEntityManager().persist(completeEvaluation);
    }

    public void delete(CompleteEvaluation completeEvaluation) {
        CompleteEvaluation merged = getEntityManager().merge(completeEvaluation);
        getEntityManager().remove(merged);
    }

}
