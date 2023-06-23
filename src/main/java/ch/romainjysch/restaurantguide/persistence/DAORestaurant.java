package ch.romainjysch.restaurantguide.persistence;

import ch.romainjysch.restaurantguide.business.Restaurant;

import static ch.romainjysch.restaurantguide.persistence.Database.getEntityManager;

public class DAORestaurant {

    private static DAORestaurant instance;

    private DAORestaurant() {}

    public static DAORestaurant getInstance() {
        if (instance == null)
            instance = new DAORestaurant();
        return instance;
    }

    public Restaurant findRestaurantById(int id) {
        return getEntityManager().find(Restaurant.class, id);
    }

}
