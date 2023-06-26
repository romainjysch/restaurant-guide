package ch.romainjysch.restaurantguide.business;

import lombok.Setter;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Setter
@Getter
@Embeddable
public class Localisation {

    @Column(name = "adresse", nullable = false, length = 100)
    private String street;

    @ManyToOne
    @JoinColumn(name = "fk_vill", nullable = false)
    private City city;

    public Localisation() {}

    public Localisation(String street, City city) {
        this.street = street;
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localisation that = (Localisation) o;
        return Objects.equals(street, that.street) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city);
    }

}
