package id.raidnav.products.eureka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.Assert;
import id.raidnav.products.eureka.domain.product.accommodation.Accommodation;
import id.raidnav.products.eureka.domain.product.experience.Experience;
import id.raidnav.products.eureka.domain.product.vehicle.Vehicle;
import id.raidnav.products.eureka.exception.DataNotFoundException;
import id.raidnav.products.eureka.validation.ProductValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestProductValidator {

  private ProductValidator productValidator;
  private final ObjectMapper objectMapper = new ObjectMapper();

  @BeforeEach
  public void before() {
    productValidator = new ProductValidator();
  }

  @Test
  public void testIsNotValidEmptyString() throws JsonProcessingException {
    String str = "[]";
    Assert.assertFalse(productValidator.isValid(str, null), "");
    Assert.assertFalse(productValidator.isValid(objectMapper.writeValueAsString(new DataNotFoundException("")), null), "");
  }

  @Test
  public void testIsValid() throws JsonProcessingException {
    Assert.assertTrue(productValidator.isValid(objectMapper.writeValueAsString(new Experience()), null), "");
    Assert.assertTrue(productValidator.isValid(objectMapper.writeValueAsString(new Accommodation()), null), "");
    Assert.assertTrue(productValidator.isValid(objectMapper.writeValueAsString(new Vehicle()), null), "");
  }
}
