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
    private final DAOGrade daoGrade;
    private final DAORestaurant daoRestaurant;
    private final DAORestaurantType daoRestaurantType;

    private RestaurantService(Database database,
                              DAOBasicEvaluation daoBasicEvaluation,
                              DAOCity daoCity,
                              DAOCompleteEvaluation daoCompleteEvaluation,
                              DAOEvaluationCriteria daoEvaluationCriteria,
                              DAOGrade daoGrade,
                              DAORestaurant daoRestaurant,
                              DAORestaurantType daoRestaurantType) {
        this.database = database;
        this.daoBasicEvaluation = daoBasicEvaluation;
        this.daoCity = daoCity;
        this.daoCompleteEvaluation = daoCompleteEvaluation;
        this.daoEvaluationCriteria = daoEvaluationCriteria;
        this.daoGrade = daoGrade;
        this.daoRestaurant = daoRestaurant;
        this.daoRestaurantType = daoRestaurantType;
    }

    public static RestaurantService getInstance(Database database,
                                                DAOBasicEvaluation daoBasicEvaluation,
                                                DAOCity daoCity,
                                                DAOCompleteEvaluation daoCompleteEvaluation,
                                                DAOEvaluationCriteria daoEvaluationCriteria,
                                                DAOGrade daoGrade,
                                                DAORestaurant daoRestaurant,
                                                DAORestaurantType daoRestaurantType) {
        if (instance == null)
            instance = new RestaurantService(database,
                    daoBasicEvaluation,
                    daoCity,
                    daoCompleteEvaluation,
                    daoEvaluationCriteria,
                    daoGrade,
                    daoRestaurant,
                    daoRestaurantType);
        return instance;
    }

    public Set<RestaurantOverview> researchAllRestaurants() {
        throw new UnsupportedOperationException("ToDo");
    }

    public Restaurant researchRestaurantById(int restaurantId) {
        throw new UnsupportedOperationException("ToDo");
    }

    public Set<RestaurantOverview> researchRestaurantsByName(String research) {
        throw new UnsupportedOperationException("ToDo");
    }

    public Set<RestaurantOverview> researchRestaurantsByCityName(String research) {
        throw new UnsupportedOperationException("ToDo");
    }

    public Set<RestaurantOverview> researchRestaurantsByType(RestaurantType restaurantType) {
        throw new UnsupportedOperationException("ToDo");
    }

    public Set<RestaurantType> researchAllRestaurantTypes() {
        throw new UnsupportedOperationException("ToDo");
    }

    public Set<City> researchAllCities() {
        throw new UnsupportedOperationException("ToDo");
    }

    public Set<EvaluationCriteria> researchAllEvaluationCriteria() {
        throw new UnsupportedOperationException("ToDo");
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
        database.inTransaction(() -> daoRestaurant.delete(restaurant));
    }
    
}
