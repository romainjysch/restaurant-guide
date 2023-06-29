package ch.romainjysch.restaurantguide.persistence;

import ch.romainjysch.restaurantguide.business.Grade;

import static ch.romainjysch.restaurantguide.persistence.Database.getEntityManager;

public class DAOGrade {

    public DAOGrade() {}

    public void delete(Grade grade) {
        Grade merged = getEntityManager().merge(grade);
        getEntityManager().remove(merged);
    }

}
