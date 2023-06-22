package ch.romainjysch.restaurantguide.persistence;

import ch.romainjysch.restaurantguide.business.City;

import static ch.romainjysch.restaurantguide.persistence.Database.getEntityManager;

public class DAOCity {

    private static DAOCity instance;

    private DAOCity() {}

    public static DAOCity getInstance() {
        if (instance == null) {
            instance = new DAOCity();
        }
        return instance;
    }

    public City findCityById(int id) {
        return getEntityManager().find(City.class, id);
    }

}