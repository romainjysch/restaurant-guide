package ch.romainjysch.restaurantguide.application;

import ch.romainjysch.restaurantguide.business.*;
import ch.romainjysch.restaurantguide.persistence.Database;
import ch.romainjysch.restaurantguide.utils.RestaurantToRestaurantOverview;

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
                RestaurantOverview restaurantOverview = RestaurantToRestaurantOverview.convert(restaurant);
                System.out.println(restaurantOverview);
            });
            database.inTransaction(() -> {
                RestaurantType restaurantType = getEntityManager().find(RestaurantType.class, 1);
                System.out.println(restaurantType);
            });
        }
    }

}
