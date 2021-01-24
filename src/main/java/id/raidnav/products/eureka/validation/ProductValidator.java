package id.raidnav.products.eureka.validation;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.raidnav.products.eureka.domain.product.accommodation.Accommodation;
import id.raidnav.products.eureka.domain.product.experience.Experience;
import lombok.SneakyThrows;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductValidator implements ConstraintValidator<ProductConstraint, String> {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @SneakyThrows
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    List<Class<?>> clazz = new ArrayList<>(Arrays.asList(Accommodation.class, Experience.class));
    for (Class<?> c : clazz) {
      try {
        objectMapper.readValue(value, c);
        return true;
      } catch (JsonMappingException ignored) {
      }
    }
    return false;
  }
}
