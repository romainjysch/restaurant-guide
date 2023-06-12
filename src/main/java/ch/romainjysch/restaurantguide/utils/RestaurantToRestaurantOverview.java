package ch.romainjysch.restaurantguide.utils;

import ch.romainjysch.restaurantguide.business.Restaurant;
import ch.romainjysch.restaurantguide.business.RestaurantOverview;

public class RestaurantToRestaurantOverview {

    public static RestaurantOverview convert(Restaurant restaurant) {
        return new RestaurantOverview(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getStreet(),
                restaurant.getZipCode(),
                restaurant.getCityName()
        );
    }

}
