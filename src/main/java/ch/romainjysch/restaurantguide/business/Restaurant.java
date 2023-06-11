package ch.romainjysch.restaurantguide.business;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "RESTAURANTS")
public class Restaurant {

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

    @Transient
    private Set<Evaluation> evaluations;

    @Embedded
    private Localisation address;

    @ManyToOne
    @JoinColumn(name = "FK_TYPE")
    private RestaurantType type;

    public Restaurant() {}

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", website='" + website + '\'' +
                ", evaluations=" + evaluations +
                ", address=" + address +
                ", type=" + type +
                '}';
    }

}
