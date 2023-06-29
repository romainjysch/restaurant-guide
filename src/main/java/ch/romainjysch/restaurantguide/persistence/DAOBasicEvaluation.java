package ch.romainjysch.restaurantguide.persistence;

import ch.romainjysch.restaurantguide.business.BasicEvaluation;

import static ch.romainjysch.restaurantguide.persistence.Database.getEntityManager;

public class DAOBasicEvaluation {

    public DAOBasicEvaluation() {}

    public void insert(BasicEvaluation basicEvaluation) {
        getEntityManager().persist(basicEvaluation);
    }

    public void delete(BasicEvaluation basicEvaluation) {
        BasicEvaluation merged = getEntityManager().merge(basicEvaluation);
        getEntityManager().remove(merged);
    }

}
