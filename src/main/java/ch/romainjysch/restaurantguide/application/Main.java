package ch.romainjysch.restaurantguide.application;

import ch.romainjysch.restaurantguide.business.Restaurant;

public class Main {

    public static void main(String[] args) {
        cli();
    }

    private static void cli() {
        Restaurant restaurant = new Restaurant(1, "Romain");
        System.out.println(restaurant);
    }

}
