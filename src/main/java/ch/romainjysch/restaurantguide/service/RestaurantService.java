package ch.romainjysch.restaurantguide.service;

import ch.romainjysch.restaurantguide.business.City;
import ch.romainjysch.restaurantguide.persistence.DAOCity;
import ch.romainjysch.restaurantguide.persistence.Database;

public class RestaurantService {

    private static RestaurantService instance;
    private final Database database;
    private final DAOCity DAOCity;

    private RestaurantService(Database database, DAOCity DAOCity) {
        this.database = database;
        this.DAOCity = DAOCity;
    }

    public static RestaurantService getInstance(Database database, DAOCity DAOCity) {
        if (instance == null) {
            instance = new RestaurantService(database, DAOCity);
        }
        return instance;
    }

    public City researchCityById(int id) {
        return database.inTransaction(() -> DAOCity.findCityById(id));
    }

}
