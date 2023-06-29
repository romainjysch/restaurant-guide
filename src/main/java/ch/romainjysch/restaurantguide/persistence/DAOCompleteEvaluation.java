package ch.romainjysch.restaurantguide.persistence;

import ch.romainjysch.restaurantguide.business.CompleteEvaluation;

import static ch.romainjysch.restaurantguide.persistence.Database.getEntityManager;

public class DAOCompleteEvaluation {

    public DAOCompleteEvaluation() {}

    public void insert(CompleteEvaluation completeEvaluation) {
        getEntityManager().persist(completeEvaluation);
    }

    public void delete(CompleteEvaluation completeEvaluation) {
        CompleteEvaluation merged = getEntityManager().merge(completeEvaluation);
        getEntityManager().remove(merged);
    }

}
