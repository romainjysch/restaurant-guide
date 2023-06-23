package ch.romainjysch.restaurantguide.persistence;

public class DAOEvaluationCriteria {

    private static DAOEvaluationCriteria instance;

    private DAOEvaluationCriteria() {}

    public static DAOEvaluationCriteria getInstance() {
        if (instance == null)
            instance = new DAOEvaluationCriteria();
        return instance;
    }

}
