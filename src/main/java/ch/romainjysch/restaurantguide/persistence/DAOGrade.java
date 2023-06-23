package ch.romainjysch.restaurantguide.persistence;

public class DAOGrade {

    private static DAOGrade instance;

    private DAOGrade() {}

    public static DAOGrade getInstance() {
        if (instance == null)
            instance = new DAOGrade();
        return instance;
    }

}
