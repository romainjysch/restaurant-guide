package ch.romainjysch.restaurantguide.business;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "TYPES_GASTRONOMIQUES")
@NamedQuery(name = "RestaurantType.researchAll", query = "select rt from RestaurantType rt")
public class RestaurantType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TYPES_GASTRONOMIQUES")
    @SequenceGenerator(name = "SEQ_TYPES_GASTRONOMIQUES", sequenceName = "SEQ_TYPES_GASTRONOMIQUES", allocationSize = 1)
    @Column(name="numero", nullable = false, length = 10)
    private Integer id;

    @Column(name = "libelle", unique = true, nullable = false, length = 100)
    private String label;

    @Column(name = "description", nullable = false)
    @Lob
    private String description;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "restaurantType", fetch = FetchType.EAGER)
    private Set<Restaurant> restaurants;

    public RestaurantType() {}

    public void addRestaurant(Restaurant restaurant) {
        this.getRestaurants().add(restaurant);
        restaurant.setRestaurantType(this);
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public Set<Restaurant> getRestaurants() {
        return restaurants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantType that = (RestaurantType) o;
        return Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

}
