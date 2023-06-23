package ch.romainjysch.restaurantguide.persistence;

public class DAOCompleteEvaluation {

    private static DAOCompleteEvaluation instance;

    private DAOCompleteEvaluation() {}

    public static DAOCompleteEvaluation getInstance() {
        if (instance == null)
            instance = new DAOCompleteEvaluation();
        return instance;
    }

}
