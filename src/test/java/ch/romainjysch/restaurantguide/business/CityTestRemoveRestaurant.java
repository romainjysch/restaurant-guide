package ch.romainjysch.restaurantguide.business;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CityTestRemoveRestaurant {

    private City city;
    private Restaurant restaurant;

    @BeforeEach
    void setUp() {
        city = new City("2000", "Neuchâtel");
        restaurant = new Restaurant(1, "Fleur-de-Lys", null, null, null, city, new RestaurantType());
        city.removeRestaurant(restaurant);
    }

    @Test
    void removeRestaurant_GivenRestaurant_SizeShouldBe0() {
        assertThat(city.getRestaurants().size(), is(0));
    }

    @Test
    void removeRestaurant_GivenRestaurant_ZipCodeShouldThrowNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> restaurant.getZipCode());
    }

    @Test
    void removeRestaurant_GivenRestaurant_CityNameShouldThrowNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> restaurant.getCityName());
    }

}
