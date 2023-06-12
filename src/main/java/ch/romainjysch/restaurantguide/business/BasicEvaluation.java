package ch.romainjysch.restaurantguide.business;

import ch.romainjysch.restaurantguide.persistence.BooleanConverter;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

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

}
