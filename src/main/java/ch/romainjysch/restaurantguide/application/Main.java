package ch.romainjysch.restaurantguide.application;

import ch.romainjysch.restaurantguide.business.City;
import ch.romainjysch.restaurantguide.business.Restaurant;
import ch.romainjysch.restaurantguide.persistence.Database;
import static ch.romainjysch.restaurantguide.persistence.Database.getEntityManager;

public class Main {

    public static void main(String[] args) {
        cli();
    }

    private static void cli() {
        try (var database = Database.getInstance()) {
            database.inTransaction(() -> {
                City city = getEntityManager().find(City.class, 1);
                System.out.println(city);
            });
            database.inTransaction(() -> {
                Restaurant restaurant = getEntityManager().find(Restaurant.class, 1);
                System.out.println(restaurant);
            });
        }
    }

}
