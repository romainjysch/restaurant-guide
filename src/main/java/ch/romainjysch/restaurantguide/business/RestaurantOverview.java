package ch.romainjysch.restaurantguide.business;

public class RestaurantOverview  implements IAmRestaurant {

    private final Integer id;
    private final String name;
    private final String street;
    private final String zipCode;
    private final String cityName;

    public RestaurantOverview(Integer id, String name, String street, String zipCode, String cityName) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.cityName = cityName;
        this.zipCode = zipCode;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public String getCityName() {
        return cityName;
    }

    @Override
    public String toString() {
        return "RestaurantOverview{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }

}
