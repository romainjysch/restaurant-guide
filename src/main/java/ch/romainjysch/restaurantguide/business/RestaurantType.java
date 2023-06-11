package ch.romainjysch.restaurantguide.business;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TYPES_GASTRONOMIQUES")
public class RestaurantType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TYPES_GASTRONOMIQUES")
    @SequenceGenerator(name = "SEQ_TYPES_GASTRONOMIQUES", sequenceName = "SEQ_TYPES_GASTRONOMIQUES", initialValue = 1, allocationSize = 1)
    @Column(name="NUMERO", nullable = false)
    private Integer id;

    @Column(name = "libelle", unique = true, nullable = false, length = 100)
    private String label;

    @Column(name = "description", nullable = false)
    private String description;

    @Transient
    private Set<Restaurant> restaurants;

    public RestaurantType() {}

    @Override
    public String toString() {
        return "RestaurantType{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", restaurants=" + restaurants +
                '}';
    }

}
