package ch.romainjysch.restaurantguide.service;

import ch.romainjysch.restaurantguide.business.City;
import ch.romainjysch.restaurantguide.business.Restaurant;
import ch.romainjysch.restaurantguide.business.RestaurantOverview;
import ch.romainjysch.restaurantguide.persistence.Database;
import ch.romainjysch.restaurantguide.utils.RestaurantToRestaurantOverview;

import static ch.romainjysch.restaurantguide.persistence.Database.getEntityManager;

public class RestaurantService {

    private static RestaurantService instance;
    private final Database database;

    private RestaurantService(Database database) {
        this.database = database;
    }

    public static RestaurantService getInstance(Database database) {
        if (instance == null) {
            instance = new RestaurantService(database);
        }
        return instance;
    }

    public RestaurantOverview researchRestaurantById(int id) {
        return database.inTransaction(() -> RestaurantToRestaurantOverview.convert(getEntityManager().find(Restaurant.class, id)));
    }

    public City researchCityById(int id) {
        return database.inTransaction(() -> getEntityManager().find(City.class, id));
    }

}
