package ch.romainjysch.restaurantguide.business;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "RESTAURANTS")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RESTAURANTS")
    @SequenceGenerator(name = "SEQ_RESTAURANTS", sequenceName = "SEQ_RESTAURANTS", allocationSize = 1)
    private Integer id;

    @Column(name = "NOM")
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="SITE_WEB")
    private String website;

    public Restaurant() {}

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", website='" + website + '\'' +
                '}';
    }

}
