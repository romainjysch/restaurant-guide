package ch.romainjysch.restaurantguide.persistence;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean s) {
        return Boolean.TRUE.equals(s) ? "T" : "F";
    }

    @Override
    public Boolean convertToEntityAttribute(String s) {
        return "T".equals(s);
    }

}
