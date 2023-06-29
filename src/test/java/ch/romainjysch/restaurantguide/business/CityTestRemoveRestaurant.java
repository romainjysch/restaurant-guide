package ch.romainjysch.restaurantguide.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void removeRestaurant_GivenRestaurant_CityRestaurantsSizeShouldBe0() {
        assertThat(city.getRestaurants().size()).isEqualTo(0);
    }

    @Test
    void removeRestaurant_GivenRestaurant_RestaurantZipCodeShouldThrowNullPointerException() {
        assertThatThrownBy(() -> restaurant.getZipCode()).isInstanceOf(NullPointerException.class);
    }

    @Test
    void removeRestaurant_GivenRestaurant_RestaurantCityNameShouldThrowNullPointerException() {
        assertThatThrownBy(() -> restaurant.getCityName()).isInstanceOf(NullPointerException.class);
    }

}
