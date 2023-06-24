package ch.romainjysch.restaurantguide.persistence;

import ch.romainjysch.restaurantguide.business.RestaurantType;

import java.util.Set;
import static java.util.stream.Collectors.toUnmodifiableSet;

import static ch.romainjysch.restaurantguide.persistence.Database.getEntityManager;

public class DAORestaurantType {

    private static DAORestaurantType instance;

    private DAORestaurantType() {}

    public static DAORestaurantType getInstance() {
        if (instance == null)
            instance = new DAORestaurantType();
        return instance;
    }

    public Set<RestaurantType> findAll() {
        return getEntityManager()
                .createNamedQuery("RestaurantType.researchAll", RestaurantType.class)
                .getResultStream()
                .collect(toUnmodifiableSet());
    }

}
