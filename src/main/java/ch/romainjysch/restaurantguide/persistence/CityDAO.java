package ch.romainjysch.restaurantguide.persistence;

import ch.romainjysch.restaurantguide.business.City;

import static ch.romainjysch.restaurantguide.persistence.Database.getEntityManager;

public class CityDAO {

    private static CityDAO instance;

    private CityDAO() {}

    public static CityDAO getInstance() {
        if (instance == null) {
            instance = new CityDAO();
        }
        return instance;
    }

    public City findCityById(int id) {
        return getEntityManager().find(City.class, id);
    }

}
