package ch.romainjysch.restaurantguide.application;

import ch.romainjysch.restaurantguide.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
                    DAOBasicEvaluation.getInstance(),
                    DAOCity.getInstance(),
                    DAOCompleteEvaluation.getInstance(),
                    DAOEvaluationCriteria.getInstance(),
                    DAOGrade.getInstance(),
                    DAORestaurant.getInstance(),
                    DAORestaurantType.getInstance());
            System.out.println(restaurantService.researchCityById(1));
            System.out.println(restaurantService.researchRestaurantById(1));
        }
        logger.info("Main # CLI Close");
    }

}
