package ch.romainjysch.restaurantguide.persistence;

public class DAOBasicEvaluation {

    private static DAOBasicEvaluation instance;

    private DAOBasicEvaluation() {}

    public static DAOBasicEvaluation getInstance() {
        if (instance == null)
            return new DAOBasicEvaluation();
        return instance;
    }

}
