package ch.romainjysch.restaurantguide.persistence;

import ch.romainjysch.restaurantguide.business.EvaluationCriteria;

import java.util.Set;
import static java.util.stream.Collectors.toUnmodifiableSet;

import static ch.romainjysch.restaurantguide.persistence.Database.getEntityManager;

public class DAOEvaluationCriteria {

    private static DAOEvaluationCriteria instance;

    private DAOEvaluationCriteria() {}

    public static DAOEvaluationCriteria getInstance() {
        if (instance == null)
            instance = new DAOEvaluationCriteria();
        return instance;
    }

    public Set<EvaluationCriteria> findAll() {
        return getEntityManager()
                .createNamedQuery("EvaluationCriteria.researchAll", EvaluationCriteria.class)
                .getResultStream()
                .collect(toUnmodifiableSet());
    }

}
