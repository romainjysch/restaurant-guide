package ch.romainjysch.restaurantguide.persistence;

import ch.romainjysch.restaurantguide.business.Restaurant;
import ch.romainjysch.restaurantguide.business.RestaurantOverview;
import ch.romainjysch.restaurantguide.business.RestaurantType;

import javax.persistence.TypedQuery;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static ch.romainjysch.restaurantguide.persistence.Database.getEntityManager;

public class DAORestaurant {

    private static DAORestaurant instance;
    private final static Function<TypedQuery<RestaurantOverview>, Set<RestaurantOverview>> getSetRestaurantOverview = x -> x
            .getResultStream()
            .collect(Collectors.toUnmodifiableSet());

    private DAORestaurant() {}

    public static DAORestaurant getInstance() {
        if (instance == null)
            instance = new DAORestaurant();
        return instance;
    }

    public Set<RestaurantOverview> findAll() {
        return getSetRestaurantOverview.apply(getEntityManager()
                .createNamedQuery("Restaurant.researchAll", RestaurantOverview.class));
    }

    public Restaurant findById(int id) {
        return getEntityManager()
                .createNamedQuery("Restaurant.researchById", Restaurant.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public Set<RestaurantOverview> findByName(String name) {
        return getSetRestaurantOverview.apply(getEntityManager()
                .createNamedQuery("Restaurant.researchByName", RestaurantOverview.class)
                .setParameter("name", "%" + name + "%"));
    }

    public Set<RestaurantOverview> findByCityName(String name) {
        return getSetRestaurantOverview.apply(getEntityManager()
                .createNamedQuery("Restaurant.researchByCityName", RestaurantOverview.class)
                .setParameter("cityName", "%" + name + "%"));
    }

    public Set<RestaurantOverview> findByRestaurantType(RestaurantType restaurantType) {
        return getSetRestaurantOverview.apply(getEntityManager()
                .createNamedQuery("Restaurant.researchByRestaurantType", RestaurantOverview.class)
                .setParameter("restaurantType", restaurantType));
    }

    public void insert(Restaurant restaurant) {
        getEntityManager().persist(restaurant);
    }

    public void update(Restaurant restaurant) {
        getEntityManager().merge(restaurant);
    }

    public void delete(Restaurant restaurant) {
        Restaurant merged = getEntityManager().merge(restaurant);
        getEntityManager().remove(merged);
    }

}
