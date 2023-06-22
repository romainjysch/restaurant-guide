package ch.romainjysch.restaurantguide.utils;

import ch.romainjysch.restaurantguide.business.Restaurant;
import ch.romainjysch.restaurantguide.business.RestaurantDTO;

public class RestaurantToRestaurantDTO {

    public static RestaurantDTO convert(Restaurant restaurant) {
        return new RestaurantDTO(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getStreet(),
                restaurant.getZipCode(),
                restaurant.getCityName()
        );
    }

}
