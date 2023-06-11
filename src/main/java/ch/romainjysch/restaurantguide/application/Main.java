package ch.romainjysch.restaurantguide.application;

import ch.romainjysch.restaurantguide.business.Restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.debug("main#start");
        cli();
        logger.debug("main#stop");
    }

    private static void cli() {
        Restaurant restaurant = new Restaurant(1, "Romain");
        System.out.println(restaurant);
    }

}
