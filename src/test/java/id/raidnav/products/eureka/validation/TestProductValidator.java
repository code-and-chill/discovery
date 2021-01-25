package id.raidnav.products.eureka.validation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.Assert;
import id.raidnav.products.eureka.domain.product.accommodation.Accommodation;
import id.raidnav.products.eureka.domain.product.experience.Experience;
import id.raidnav.products.eureka.domain.product.vehicle.Vehicle;
import id.raidnav.products.eureka.exception.DataNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestProductValidator {

  private ProductValidator productValidator;
  private final ObjectMapper objectMapper = new ObjectMapper();

  @BeforeEach
  public void before() {
    productValidator = new ProductValidator();
  }

  @Test
  public void testIsNotValidEmptyString() throws JsonProcessingException {
    Assert.assertFalse(productValidator.isValid("", null), "");
    Assert.assertFalse(productValidator.isValid(objectMapper.writeValueAsString(BigDecimal.ONE), null), "");
    Assert.assertFalse(productValidator.isValid(objectMapper.writeValueAsString(new ArrayList<DataNotFoundException>()), null), "");
  }

  @Test
  public void testIsValid() throws JsonProcessingException {
    Assert.assertTrue(productValidator.isValid(objectMapper.writeValueAsString(new ArrayList<>(Collections.singletonList(new Experience()))), null));
    Assert.assertTrue(productValidator.isValid(objectMapper.writeValueAsString(new Experience()), null), "");
    Assert.assertTrue(productValidator.isValid(objectMapper.writeValueAsString(new Accommodation()), null), "");
    Assert.assertTrue(productValidator.isValid(objectMapper.writeValueAsString(new Vehicle()), null), "");
  }
}
