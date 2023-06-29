package ch.romainjysch.restaurantguide.persistence;

import ch.romainjysch.restaurantguide.business.RestaurantType;

import java.util.Set;
import static java.util.stream.Collectors.toUnmodifiableSet;

import static ch.romainjysch.restaurantguide.persistence.Database.getEntityManager;

public class DAORestaurantType {

    public DAORestaurantType() {}

    public Set<RestaurantType> findAll() {
        return getEntityManager()
                .createNamedQuery("RestaurantType.researchAll", RestaurantType.class)
                .getResultStream()
                .collect(toUnmodifiableSet());
    }

}
