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
    void addRestaurant_GivenNewRestaurant_SizeShouldBe1() {
        assertThat(city.getRestaurants().size()).isEqualTo(1);
    }

    @Test
    void addRestaurant_GivenNewRestaurant_IdShouldBe1() {
        assertThat(city.getRestaurants().iterator().next().getId()).isEqualTo(1);
    }

    @Test
    void addRestaurant_GivenNewRestaurant_NameShouldBeFleurDeLys() {
        assertThat(city.getRestaurants().iterator().next().getName()).isEqualTo("Fleur-de-Lys");
    }

    @Test
    void addRestaurant_GivenNewRestaurant_ZipCodeShouldBe2000() {
        assertThat(restaurant.getZipCode()).isEqualTo("2000");
    }

    @Test
    void addRestaurant_GivenNewRestaurant_CityNameShouldBeNeuchatel() {
        assertThat(restaurant.getCityName()).isEqualTo("Neuchâtel");
    }

}
