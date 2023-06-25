package ch.romainjysch.restaurantguide.service;

import ch.romainjysch.restaurantguide.business.*;
import ch.romainjysch.restaurantguide.persistence.*;

import java.util.Set;

public class RestaurantService {

    private static RestaurantService instance;
    private final Database database;
    private final DAOBasicEvaluation daoBasicEvaluation;
    private final DAOCity daoCity;
    private final DAOCompleteEvaluation daoCompleteEvaluation;
    private final DAOEvaluationCriteria daoEvaluationCriteria;
    private final DAORestaurant daoRestaurant;
    private final DAORestaurantType daoRestaurantType;

    private RestaurantService(Database database,
                              DAOBasicEvaluation daoBasicEvaluation,
                              DAOCity daoCity,
                              DAOCompleteEvaluation daoCompleteEvaluation,
                              DAOEvaluationCriteria daoEvaluationCriteria,
                              DAORestaurant daoRestaurant,
                              DAORestaurantType daoRestaurantType) {
        this.database = database;
        this.daoBasicEvaluation = daoBasicEvaluation;
        this.daoCity = daoCity;
        this.daoCompleteEvaluation = daoCompleteEvaluation;
        this.daoEvaluationCriteria = daoEvaluationCriteria;
        this.daoRestaurant = daoRestaurant;
        this.daoRestaurantType = daoRestaurantType;
    }

    public static RestaurantService getInstance(Database database,
                                                DAOBasicEvaluation daoBasicEvaluation,
                                                DAOCity daoCity,
                                                DAOCompleteEvaluation daoCompleteEvaluation,
                                                DAOEvaluationCriteria daoEvaluationCriteria,
                                                DAORestaurant daoRestaurant,
                                                DAORestaurantType daoRestaurantType) {
        if (instance == null)
            instance = new RestaurantService(database,
                    daoBasicEvaluation,
                    daoCity,
                    daoCompleteEvaluation,
                    daoEvaluationCriteria,
                    daoRestaurant,
                    daoRestaurantType);
        return instance;
    }

    public Set<RestaurantOverview> researchAllRestaurants() {
        return database.inTransaction(daoRestaurant::findAll);
    }

    public Restaurant researchRestaurantById(int id) {
        return database.inTransaction(() -> daoRestaurant.findById(id));
    }

    public Set<RestaurantOverview> researchRestaurantsByName(String name) {
        return database.inTransaction(() -> daoRestaurant.findByName(name));
    }

    public Set<RestaurantOverview> researchRestaurantsByCityName(String name) {
        return database.inTransaction(() -> daoRestaurant.findByCityName(name));
    }

    public Set<RestaurantOverview> researchRestaurantsByType(RestaurantType restaurantType) {
        return database.inTransaction(() -> daoRestaurant.findByRestaurantType(restaurantType));
    }

    public Set<RestaurantType> researchAllRestaurantTypes() {
        return database.inTransaction(daoRestaurantType::findAll);
    }

    public Set<City> researchAllCities() {
        return database.inTransaction(daoCity::findAll);
    }

    public Set<EvaluationCriteria> researchAllEvaluationCriteria() {
        return database.inTransaction(daoEvaluationCriteria::findAll);
    }

    public void insertCity(City city) {
        database.inTransaction(() -> daoCity.insert(city));
    }

    public void insertBasicEvaluation(BasicEvaluation basicEvaluation) {
        database.inTransaction(() -> daoBasicEvaluation.insert(basicEvaluation));
    }

    public void insertCompleteEvaluation(CompleteEvaluation completeEvaluation) {
        database.inTransaction(() -> daoCompleteEvaluation.insert(completeEvaluation));
    }

    public void insertRestaurant(Restaurant restaurant) {
        database.inTransaction(() -> daoRestaurant.insert(restaurant));
    }

    public void updateRestaurant(Restaurant restaurant) {
        database.inTransaction(() -> daoRestaurant.update(restaurant));
    }

    public void deleteRestaurant(Restaurant restaurant) {
        database.inTransaction(() -> {
            restaurant.getEvaluations().stream().filter(CompleteEvaluation.class::isInstance)
                    .map(CompleteEvaluation.class::cast).forEach(daoCompleteEvaluation::delete);
            restaurant.getEvaluations().stream().filter(BasicEvaluation.class::isInstance)
                    .map(BasicEvaluation.class::cast).forEach(daoBasicEvaluation::delete);
            daoRestaurant.delete(restaurant);
        });
    }

}
