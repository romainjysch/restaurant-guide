package ch.romainjysch.restaurantguide.business;

import ch.romainjysch.restaurantguide.persistence.BooleanConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "LIKES")
public class BasicEvaluation extends Evaluation {

    @Column(name = "appreciation", nullable = false, length = 1)
    @Convert(converter = BooleanConverter.class)
    private boolean likeRestaurant;

    @Column(name = "adresse_ip", nullable = false, length = 100)
    private String ipAddress;

    public BasicEvaluation() {}

    public BasicEvaluation(Integer id,
                           LocalDate visitDate,
                           Restaurant restaurant,
                           boolean likeRestaurant,
                           String ipAddress) {
        super(id, visitDate, restaurant);
        this.likeRestaurant = likeRestaurant;
        this.ipAddress = ipAddress;
    }

    public boolean isLikeRestaurant() {
        return likeRestaurant;
    }

}
