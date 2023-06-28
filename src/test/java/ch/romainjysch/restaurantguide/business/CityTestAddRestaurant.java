package ch.romainjysch.restaurantguide.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CityTestAddRestaurant {

    private City city;
    private Restaurant restaurant;

    @BeforeEach
    void setUp() {
        city = new City("2000", "Neuchâtel");
        restaurant = new Restaurant(1, "Fleur-de-Lys", null, null, null, new City(), new RestaurantType());
        city.addRestaurant(restaurant);
    }

    @Test
    void addRestaurant_GivenNewRestaurant_SizeShouldBe1() {
        Assertions.assertEquals(1, city.getRestaurants().size());
    }

    @Test
    void addRestaurant_GivenNewRestaurant_IdShouldBe1() {
        Assertions.assertEquals(1, city.getRestaurants().iterator().next().getId());
    }

    @Test
    void addRestaurant_GivenNewRestaurant_NameShouldBeFleurDeLys() {
        Assertions.assertEquals("Fleur-de-Lys", city.getRestaurants().iterator().next().getName());
    }

    @Test
    void addRestaurant_GivenNewRestaurant_ZipCodeShouldBe2000() {
        Assertions.assertEquals("2000", restaurant.getZipCode());
    }

    @Test
    void addRestaurant_GivenNewRestaurant_CityNameShouldBeNeuchatel() {
        Assertions.assertEquals("Neuchâtel", restaurant.getCityName());
    }

}
