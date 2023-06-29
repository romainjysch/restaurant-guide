package ch.romainjysch.restaurantguide.business;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class RestaurantTestAddBasicEvaluation {

    private Restaurant restaurant;
    private BasicEvaluation basicEvaluation;

    @BeforeEach
    void setUp() {
        restaurant = new Restaurant(1, "Fleur-de-Lys", null, null, null, new City(), new RestaurantType());
        basicEvaluation = new BasicEvaluation(1, LocalDate.now(), new Restaurant(), true, null);
        restaurant.addEvaluation(basicEvaluation);
    }

    @Test
    void addEvaluation_GivenNewBasicEvaluation_RestaurantEvaluationsSizeShouldBe1() {
        assertThat(restaurant.getEvaluations().size()).isEqualTo(1);
    }

    @Test
    void addEvaluation_GivenNewBasicEvaluation_RestaurantFirstEvaluationIdShouldBe1() {
        assertThat(restaurant.getEvaluations().stream().findFirst().get().getId()).isEqualTo(1);
    }

    @Test
    void addEvaluation_GivenNewBasicEvaluation_RestaurantFirstEvaluationInstanceShouldBeBasicEvaluationClass() {
        assertThat(restaurant.getEvaluations().stream().findFirst().get()).isInstanceOf(BasicEvaluation.class);
    }

    @Test
    void addEvaluation_GivenNewBasicEvaluation_RestaurantFirstBasicEvaluationLikeShouldBeTrue() {
        assertThat(restaurant.getEvaluations().stream().map(BasicEvaluation.class::cast).findFirst().get().isLikeRestaurant()).isEqualTo(true);
    }

    @Test
    void addEvaluation_GivenNewBasicEvaluation_EvaluationRestaurantIdShouldBe1() {
        assertThat(basicEvaluation.getRestaurant().getId()).isEqualTo(1);
    }

    @Test
    void addEvaluation_GivenNewBasicEvaluation_EvaluationRestaurantNameShouldBeFleurDeLys() {
        assertThat(basicEvaluation.getRestaurant().getName()).isEqualTo("Fleur-de-Lys");
    }

}
