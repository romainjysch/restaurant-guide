package ch.romainjysch.restaurantguide.service;

import ch.romainjysch.restaurantguide.business.City;
import ch.romainjysch.restaurantguide.persistence.CityDAO;
import ch.romainjysch.restaurantguide.persistence.Database;

public class RestaurantService {

    private static RestaurantService instance;
    private final Database database;
    private final CityDAO cityDAO;

    private RestaurantService(Database database, CityDAO cityDAO) {
        this.database = database;
        this.cityDAO = cityDAO;
    }

    public static RestaurantService getInstance(Database database, CityDAO cityDAO) {
        if (instance == null) {
            instance = new RestaurantService(database, cityDAO);
        }
        return instance;
    }

    public City researchCityById(int id) {
        return database.inTransaction(() -> cityDAO.findCityById(id));
    }

}
