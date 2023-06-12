package ch.romainjysch.restaurantguide.business;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Setter
@Getter
@ToString
@Embeddable
public class Localisation {

    @Column(name = "adresse", nullable = false, length = 100)
    private String street;

    @ManyToOne
    @JoinColumn(name = "FK_VILL", nullable = false)
    private City city;

    public Localisation() {}

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