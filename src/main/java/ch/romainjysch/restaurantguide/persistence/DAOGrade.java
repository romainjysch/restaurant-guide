package ch.romainjysch.restaurantguide.persistence;

import ch.romainjysch.restaurantguide.business.Grade;

import static ch.romainjysch.restaurantguide.persistence.Database.getEntityManager;

public class DAOGrade {

    private static DAOGrade instance;

    private DAOGrade() {}

    public static DAOGrade getInstance() {
        if (instance == null)
            instance = new DAOGrade();
        return instance;
    }

    public void delete(Grade grade) {
        Grade merged = getEntityManager().merge(grade);
        getEntityManager().remove(merged);
    }

}
