package ch.romainjysch.restaurantguide.business;

import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "RESTAURANTS")
@NamedQueries({
        @NamedQuery(name = "Restaurant.researchAll",
                query = "select r from Restaurant r"),
        @NamedQuery(name = "Restaurant.researchById",
                query = "select r from Restaurant r " +
                        "where r.id = :id"),
        @NamedQuery(name = "Restaurant.researchByName",
                query = "select r from Restaurant r " +
                        "where r.name like :name"),
        @NamedQuery(name = "Restaurant.researchByCityName",
                query = "select r from Restaurant r " +
                        "where r.address.city.cityName = :cityName"),
        @NamedQuery(name = "Restaurant.researchByRestaurantType",
                query = "select r from Restaurant r " +
                        "where r.restaurantType = :restaurantType")
})
public class Restaurant implements IAmRestaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RESTAURANTS")
    @SequenceGenerator(name = "SEQ_RESTAURANTS", sequenceName = "SEQ_RESTAURANTS", allocationSize = 1)
    @Column(name="NUMERO", nullable = false)
    private Integer id;

    @Column(name = "NOM", nullable = false, length = 100)
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="SITE_WEB", length = 100)
    private String website;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "restaurant")
    private Set<Evaluation> evaluations;

    @Embedded
    private Localisation address;

    @ManyToOne
    @JoinColumn(name = "FK_TYPE")
    private RestaurantType restaurantType;

    public Restaurant() {}

    public Restaurant(Integer id, String name, String description, String website, String street,
                      City city, RestaurantType restaurantType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.website = website;
        this.evaluations = new HashSet<>();
        this.address = new Localisation(street, city);
        this.restaurantType = restaurantType;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getZipCode() {
        return address.getCity().getZipCode();
    }

    public String getStreet() {
        return address.getStreet();
    }

    public String getCityName() {
        return address.getCity().getCityName();
    }

    public void addEvaluation(Evaluation evaluation) {
        this.getEvaluations().add(evaluation);
        evaluation.setRestaurant(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 42;
    }

}
