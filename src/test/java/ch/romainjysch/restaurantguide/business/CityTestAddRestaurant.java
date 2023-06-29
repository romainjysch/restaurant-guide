package ch.romainjysch.restaurantguide.business;

import static org.assertj.core.api.Assertions.assertThat;

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
    void addRestaurant_GivenRestaurant_CityRestaurantsSizeShouldBe1() {
        assertThat(city.getRestaurants().size()).isEqualTo(1);
    }

    @Test
    void addRestaurant_GivenRestaurant_CityFirstRestaurantIdShouldBe1() {
        assertThat(city.getRestaurants().stream().findFirst().get().getId()).isEqualTo(1);
    }

    @Test
    void addRestaurant_GivenRestaurant_CityFirstRestaurantNameShouldBeFleurDeLys() {
        assertThat(city.getRestaurants().stream().findFirst().get().getName()).isEqualTo("Fleur-de-Lys");
    }

    @Test
    void addRestaurant_GivenRestaurant_RestaurantZipCodeShouldBe2000() {
        assertThat(restaurant.getZipCode()).isEqualTo("2000");
    }

    @Test
    void addRestaurant_GivenRestaurant_RestaurantCityNameShouldBeNeuchatel() {
        assertThat(restaurant.getCityName()).isEqualTo("Neuchâtel");
    }

}
