package ch.romainjysch.restaurantguide.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.romainjysch.restaurantguide.persistence.DAOCity;
import ch.romainjysch.restaurantguide.persistence.Database;
import ch.romainjysch.restaurantguide.service.RestaurantService;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    public static void main(String[] args) {
        cli();
    }

    private static void cli() {
        logger.info("Main # CLI Start");
        try (var database = Database.getInstance()) {
            RestaurantService restaurantService = RestaurantService.getInstance(
                    database,
                    DAOCity.getInstance());
            System.out.println(restaurantService.researchCityById(1));
        }
        logger.info("Main # CLI Close");
    }

}
