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
        try (var database = new Database()) {
            var scanner = new Scanner(System.in);
            var printStream = System.out;
            var daoContainer = new DAOContainer(
                    new DAOBasicEvaluation(),
                    new DAOCity(),
                    new DAOCompleteEvaluation(),
                    new DAOEvaluationCriteria(),
                    new DAOGrade(),
                    new DAORestaurant(),
                    new DAORestaurantType());
            var restaurantService = new RestaurantService(database, daoContainer);
            var cli = new CLI(scanner, printStream, restaurantService);
            cli.start();
        }
    }

}
