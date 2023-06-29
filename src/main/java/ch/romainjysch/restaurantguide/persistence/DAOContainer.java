package ch.romainjysch.restaurantguide.persistence;

public class DAOContainer {

    public final DAOBasicEvaluation daoBasicEvaluation;
    public final DAOCity daoCity;
    public final DAOCompleteEvaluation daoCompleteEvaluation;
    public final DAOEvaluationCriteria daoEvaluationCriteria;
    public final DAOGrade daoGrade;
    public final DAORestaurant daoRestaurant;
    public final DAORestaurantType daoRestaurantType;

    public DAOContainer(
            DAOBasicEvaluation daoBasicEvaluation,
            DAOCity daoCity,
            DAOCompleteEvaluation daoCompleteEvaluation,
            DAOEvaluationCriteria daoEvaluationCriteria,
            DAOGrade daoGrade,
            DAORestaurant daoRestaurant,
            DAORestaurantType daoRestaurantType) {
        this.daoBasicEvaluation = daoBasicEvaluation;
        this.daoCity = daoCity;
        this.daoCompleteEvaluation = daoCompleteEvaluation;
        this.daoEvaluationCriteria = daoEvaluationCriteria;
        this.daoGrade = daoGrade;
        this.daoRestaurant = daoRestaurant;
        this.daoRestaurantType = daoRestaurantType;
    }

}
