package ch.romainjysch.restaurantguide.business;

import ch.romainjysch.restaurantguide.persistence.BooleanConverter;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Setter
@Getter
@ToString
@Entity
@Table(name = "LIKES")
public class BasicEvaluation extends Evaluation {

    @Column(name = "APPRECIATION", nullable = false, length = 1)
    @Convert(converter = BooleanConverter.class)
    private boolean likeRestaurant;

    @Column(name = "ADRESSE_IP", nullable = false, length = 100)
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

}
