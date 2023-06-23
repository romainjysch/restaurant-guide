package ch.romainjysch.restaurantguide.persistence;

public class DAORestaurantType {

    private static DAORestaurantType instance;

    private DAORestaurantType() {}

    public static DAORestaurantType getInstance() {
        if (instance == null)
            instance = new DAORestaurantType();
        return instance;
    }

}
