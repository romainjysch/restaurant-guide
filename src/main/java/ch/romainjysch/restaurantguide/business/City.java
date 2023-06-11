package ch.romainjysch.restaurantguide.business;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "VILLES")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VILLES")
    @SequenceGenerator(name = "SEQ_VILLES", sequenceName = "SEQ_VILLES", allocationSize = 1)
    @Column(name="NUMERO", nullable = false, length = 10)
    private Integer id;

    @Column(name="CODE_POSTAL")
    private String zipCode;

    @Column(name="NOM_VILLE")
    private String cityName;

    @Transient
    private Set<Restaurant> restaurants;

    public City() {}

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", zipCode='" + zipCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", restaurants=" + restaurants +
                '}';
    }

}
