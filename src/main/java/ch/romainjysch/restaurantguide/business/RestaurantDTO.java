package ch.romainjysch.restaurantguide.business;

public record RestaurantDTO(Integer id, String name, String street, String zipCode, String cityName) implements IAmRestaurant {

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String getCityName() {
        return cityName;
    }

    @Override
    public String toString() {
        return "RestaurantDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }

}
