package ch.romainjysch.restaurantguide.persistence;

import ch.romainjysch.restaurantguide.business.EvaluationCriteria;

import java.util.Set;
import static java.util.stream.Collectors.toUnmodifiableSet;

import static ch.romainjysch.restaurantguide.persistence.Database.getEntityManager;

public class DAOEvaluationCriteria {

    public DAOEvaluationCriteria() {}

    public Set<EvaluationCriteria> findAll() {
        return getEntityManager()
                .createNamedQuery("EvaluationCriteria.researchAll", EvaluationCriteria.class)
                .getResultStream()
                .collect(toUnmodifiableSet());
    }

}
