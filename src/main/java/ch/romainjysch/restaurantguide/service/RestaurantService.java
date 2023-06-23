package ch.romainjysch.restaurantguide.service;

import ch.romainjysch.restaurantguide.business.City;
import ch.romainjysch.restaurantguide.business.Restaurant;
import ch.romainjysch.restaurantguide.persistence.*;

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

    public Restaurant researchRestaurantById(int id) {
        return database.inTransaction(() -> daoRestaurant.findRestaurantById(id));
    }

    public City researchCityById(int id) {
        return database.inTransaction(() -> daoCity.findCityById(id));
    }

}
