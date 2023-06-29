package ch.romainjysch.restaurantguide.service;

import ch.romainjysch.restaurantguide.business.*;
import ch.romainjysch.restaurantguide.persistence.*;

import java.util.Set;

public class RestaurantService {

    private static RestaurantService instance;
    private final Database database;
    private final DAOContainer daoContainer;

    private RestaurantService(Database database, DAOContainer daoContainer) {
        this.database = database;
        this.daoContainer = daoContainer;
    }

    public static RestaurantService getInstance(Database database, DAOContainer daoContainer) {
        if (instance == null)
            instance = new RestaurantService(database, daoContainer);
        return instance;
    }

    public Set<RestaurantOverview> researchAllRestaurants() {
        return database.inTransaction(daoContainer.daoRestaurant::findAll);
    }

    public Restaurant researchRestaurantById(int id) {
        return database.inTransaction(() -> daoContainer.daoRestaurant.findById(id));
    }

    public Set<RestaurantOverview> researchRestaurantsByName(String name) {
        return database.inTransaction(() -> daoContainer.daoRestaurant.findByName(name));
    }

    public Set<RestaurantOverview> researchRestaurantsByCityName(String name) {
        return database.inTransaction(() -> daoContainer.daoRestaurant.findByCityName(name));
    }

    public Set<RestaurantOverview> researchRestaurantsByType(RestaurantType restaurantType) {
        return database.inTransaction(() -> daoContainer.daoRestaurant.findByRestaurantType(restaurantType));
    }

    public Set<RestaurantType> researchAllRestaurantTypes() {
        return database.inTransaction(daoContainer.daoRestaurantType::findAll);
    }

    public Set<City> researchAllCities() {
        return database.inTransaction(daoContainer.daoCity::findAll);
    }

    public Set<EvaluationCriteria> researchAllEvaluationCriteria() {
        return database.inTransaction(daoContainer.daoEvaluationCriteria::findAll);
    }

    public void insertCity(City city) {
        database.inTransaction(() -> daoContainer.daoCity.insert(city));
    }

    public void insertBasicEvaluation(BasicEvaluation basicEvaluation) {
        database.inTransaction(() -> daoContainer.daoBasicEvaluation.insert(basicEvaluation));
    }

    public void insertCompleteEvaluation(CompleteEvaluation completeEvaluation) {
        database.inTransaction(() -> daoContainer.daoCompleteEvaluation.insert(completeEvaluation));
    }

    public void insertRestaurant(Restaurant restaurant) {
        database.inTransaction(() -> daoContainer.daoRestaurant.insert(restaurant));
    }

    public void updateRestaurant(Restaurant restaurant) {
        database.inTransaction(() -> daoContainer.daoRestaurant.update(restaurant));
    }

    public void deleteRestaurant(Restaurant restaurant) {
        database.inTransaction(() -> {
            //restaurant.getEvaluations().stream().filter(CompleteEvaluation.class::isInstance).map(CompleteEvaluation.class::cast).forEach();
            restaurant.getEvaluations().stream().filter(CompleteEvaluation.class::isInstance)
                    .map(CompleteEvaluation.class::cast).forEach(daoContainer.daoCompleteEvaluation::delete);
            restaurant.getEvaluations().stream().filter(BasicEvaluation.class::isInstance)
                    .map(BasicEvaluation.class::cast).forEach(daoContainer.daoBasicEvaluation::delete);
            daoContainer.daoRestaurant.delete(restaurant);
        });
    }

}
