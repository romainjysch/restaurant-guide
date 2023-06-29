package ch.romainjysch.restaurantguide.persistence;

import ch.romainjysch.restaurantguide.business.City;

import java.util.Set;
import static java.util.stream.Collectors.toUnmodifiableSet;

import static ch.romainjysch.restaurantguide.persistence.Database.getEntityManager;

public class DAOCity {

    public DAOCity() {}

    public Set<City> findAll() {
        Set<City> cities = getEntityManager().createNamedQuery("City.researchAll", City.class)
                .getResultStream()
                .collect(toUnmodifiableSet());
        cities.forEach(c -> c.getRestaurants().size());
        return cities;
    }

    public void insert(City city) {
        getEntityManager().persist(city);
    }

}
