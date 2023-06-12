package ch.romainjysch.restaurantguide.application;

import ch.romainjysch.restaurantguide.persistence.CityDAO;
import ch.romainjysch.restaurantguide.persistence.Database;
import ch.romainjysch.restaurantguide.service.RestaurantService;

public class Main {

    public static void main(String[] args) {
        cli();
    }

    private static void cli() {
        try (var database = Database.getInstance()) {
            RestaurantService restaurantService = RestaurantService.getInstance(
                    database,
                    CityDAO.getInstance());
            System.out.println(restaurantService.researchCityById(1));
        }
    }

}
