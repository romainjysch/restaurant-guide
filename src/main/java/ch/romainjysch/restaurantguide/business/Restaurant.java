package ch.romainjysch.restaurantguide.business;

public class Restaurant {

    private Integer id;

    private String name;

    public Restaurant() {}

    public Restaurant(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
