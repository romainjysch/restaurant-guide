package ch.romainjysch.restaurantguide.application;

import ch.romainjysch.restaurantguide.persistence.*;
import ch.romainjysch.restaurantguide.presentation.CLI;
import ch.romainjysch.restaurantguide.service.RestaurantService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        cli();
    }

    private static void cli() {
        try (var database = Database.getInstance()) {
            var scanner = new Scanner(System.in);
            var printStream = System.out;
            var daoContainer = DAOContainer.getInstance(
                    DAOBasicEvaluation.getInstance(),
                    DAOCity.getInstance(),
                    DAOCompleteEvaluation.getInstance(),
                    DAOEvaluationCriteria.getInstance(),
                    DAORestaurant.getInstance(),
                    DAORestaurantType.getInstance());
            var restaurantService = RestaurantService.getInstance(database, daoContainer);
            var cli = new CLI(scanner, printStream, restaurantService);
            cli.start();
        }
    }

}
