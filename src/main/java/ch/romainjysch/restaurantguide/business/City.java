package ch.romainjysch.restaurantguide.business;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@ToString
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "address.city")
    private Set<Restaurant> restaurants;

    public City() {}

    public void addRestaurant(Restaurant restaurant) {
        this.getRestaurants().add(restaurant);
        restaurant.getAddress().setCity(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(zipCode, city.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipCode);
    }


}
