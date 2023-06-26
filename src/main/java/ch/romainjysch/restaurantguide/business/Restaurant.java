package ch.romainjysch.restaurantguide.business;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "RESTAURANTS")
@NamedQueries({
        @NamedQuery(name = "Restaurant.researchAll",
                query = "select res " +
                        "from Restaurant res " +
                        "left join fetch res.restaurantType typ " +
                        "left join fetch res.address.city cit " +
                        "left join fetch res.evaluations eva " +
                        "left join fetch eva.grades gra " +
                        "left join fetch gra.evaluationCriteria cri "),
        @NamedQuery(name = "Restaurant.researchById",
                query = "select res " +
                        "from Restaurant res " +
                        "left join fetch res.restaurantType typ " +
                        "left join fetch res.address.city cit " +
                        "left join fetch res.evaluations eva " +
                        "left join fetch eva.grades gra " +
                        "left join fetch gra.evaluationCriteria cri " +
                        "where res.id = :id"),
        @NamedQuery(name = "Restaurant.researchByName",
                query = "select res " +
                        "from Restaurant res " +
                        "left join fetch res.restaurantType typ " +
                        "left join fetch res.address.city cit " +
                        "left join fetch res.evaluations eva " +
                        "left join fetch eva.grades gra " +
                        "left join fetch gra.evaluationCriteria cri " +
                        "where res.name like :name"),
        @NamedQuery(name = "Restaurant.researchByCityName",
                query = "select res " +
                        "from Restaurant res " +
                        "left join fetch res.restaurantType typ " +
                        "left join fetch res.address.city cit " +
                        "left join fetch res.evaluations eva " +
                        "left join fetch eva.grades gra " +
                        "left join fetch gra.evaluationCriteria cri " +
                        "where res.address.city.cityName like :cityName"),
        @NamedQuery(name = "Restaurant.researchByRestaurantType",
                query = "select res " +
                        "from Restaurant res " +
                        "left join fetch res.restaurantType typ " +
                        "left join fetch res.address.city cit " +
                        "left join fetch res.evaluations eva " +
                        "left join fetch eva.grades gra " +
                        "left join fetch gra.evaluationCriteria cri " +
                        "where res.restaurantType = :restaurantType")
})
public class Restaurant implements IAmRestaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RESTAURANTS")
    @SequenceGenerator(name = "SEQ_RESTAURANTS", sequenceName = "SEQ_RESTAURANTS", allocationSize = 1)
    @Column(name="numero", nullable = false, length = 10)
    private Integer id;

    @Column(name = "nom", nullable = false, length = 100)
    private String name;

    @Column(name="description")
    @Lob
    private String description;

    @Column(name="site_web", length = 100)
    private String website;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "restaurant")
    private Set<Evaluation> evaluations;

    @Embedded
    private Localisation address;

    @ManyToOne
    @JoinColumn(name = "fk_type", nullable = false)
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

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Set<Evaluation> getEvaluations() {
        return evaluations;
    }

    public Localisation getAddress() {
        return address;
    }

    public RestaurantType getRestaurantType() {
        return restaurantType;
    }

    public void setRestaurantType(RestaurantType restaurantType) {
        this.restaurantType = restaurantType;
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
