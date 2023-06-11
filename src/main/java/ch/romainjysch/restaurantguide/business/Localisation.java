package ch.romainjysch.restaurantguide.business;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Localisation {

    @Column(name = "adresse", nullable = false, length = 100)
    private String street;

    @ManyToOne
    @JoinColumn(name = "FK_VILL")
    private City city;

    public Localisation() {}

    @Override
    public String toString() {
        return "Localisation{" +
                "street='" + street + '\'' +
                ", city=" + city +
                '}';
    }

}
