package ch.romainjysch.restaurantguide.business;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@ToString
@Entity
@Table(name = "VILLES")
@NamedQuery(name = "City.researchAll", query = "select c from City c")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VILLES")
    @SequenceGenerator(name = "SEQ_VILLES", sequenceName = "SEQ_VILLES", allocationSize = 1)
    @Column(name="numero", nullable = false, length = 10)
    private Integer id;

    @Column(name="code_postal", nullable = false, length = 100)
    private String zipCode;

    @Column(name="nom_ville", nullable = false, length = 100)
    private String cityName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "address.city", fetch = FetchType.EAGER)
    private Set<Restaurant> restaurants;

    public City() {}

    public City(String zipCode, String cityName) {
        this.zipCode = zipCode;
        this.cityName = cityName;
        this.restaurants = new HashSet<>();
    }

    public void addRestaurant(Restaurant restaurant) {
        this.restaurants.add(restaurant);
        restaurant.getAddress().setCity(this);
    }

    public void removeRestaurant(Restaurant restaurant) {
        this.restaurants.remove(restaurant);
        restaurant.getAddress().setCity(null);
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
