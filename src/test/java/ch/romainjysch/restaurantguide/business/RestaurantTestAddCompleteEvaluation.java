package ch.romainjysch.restaurantguide.business;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class RestaurantTestAddCompleteEvaluation {

    private Restaurant restaurant;
    private CompleteEvaluation completeEvaluation;

    @BeforeEach
    void setUp() {
        restaurant = new Restaurant(1, "Fleur-de-Lys", null, null, null, new City(), new RestaurantType());
        completeEvaluation = new CompleteEvaluation(2, LocalDate.now(), new Restaurant(), "Top", null);
        restaurant.addEvaluation(completeEvaluation);
    }

    @Test
    void addEvaluation_GivenCompleteEvaluation_RestaurantEvaluationsSizeShouldBe1() {
        assertThat(restaurant.getEvaluations().size()).isEqualTo(1);
    }

    @Test
    void addEvaluation_GivenCompleteEvaluation_RestaurantFirstEvaluationIdShouldBe2() {
        assertThat(restaurant.getEvaluations().stream().findFirst().get().getId()).isEqualTo(2);
    }

    @Test
    void addEvaluation_GivenCompleteEvaluation_RestaurantFirstEvaluationInstanceShouldBeCompleteEvaluationClass() {
        assertThat(restaurant.getEvaluations().stream().findFirst().get()).isInstanceOf(CompleteEvaluation.class);
    }

    @Test
    void addEvaluation_GivenCompleteEvaluation_RestaurFirstCompleteEvaluationCommentShouldBeTop() {
        assertThat(restaurant.getEvaluations().stream().map(CompleteEvaluation.class::cast).findFirst().get().getComment()).isEqualTo("Top");
    }

    @Test
    void addEvaluation_GivenCompleteEvaluation_EvaluationRestaurantIdShouldBe1() {
        assertThat(completeEvaluation.getRestaurant().getId()).isEqualTo(1);
    }

    @Test
    void addEvaluation_GivenCompleteEvaluation_EvaluationRestaurantNameShouldBeFleurDeLys() {
        assertThat(completeEvaluation.getRestaurant().getName()).isEqualTo("Fleur-de-Lys");
    }

}
