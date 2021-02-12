package id.raidnav.products.eureka.validation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.Assert;
import id.raidnav.products.eureka.domain.product.accommodation.Accommodation;
import id.raidnav.products.eureka.domain.product.experience.Experience;
import id.raidnav.products.eureka.domain.product.vehicle.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

public class TestProductValidator {

  @Inject
  private ProductValidator productValidator;
  private final ObjectMapper objectMapper = new ObjectMapper();

  @BeforeEach
  public void before() {
    productValidator = new ProductValidator();
  }

  @Test
  public void givenEmptyStringShouldReturnFalse() throws JsonProcessingException {
    Assert.assertFalse(productValidator.isValid(objectMapper.writeValueAsString(BigDecimal.ONE), null), "");
  }

  @Test
  public void givenArbitraryStringShouldReturnFalse() throws JsonProcessingException {
    Assert.assertFalse(productValidator.isValid(objectMapper.writeValueAsString(BigDecimal.ONE), null), "");
  }

  @Test
  public void givenArbitraryListShouldReturnIsNotValid() throws JsonProcessingException {
    Assert.assertFalse(productValidator.isValid(objectMapper.writeValueAsString(new ArrayList<>()), null), "");
    Assert.assertFalse(productValidator.isValid(objectMapper.writeValueAsString(new ArrayList<BigDecimal>()), null), "");
  }

  @Test
  public void givenRegisteredObjectShouldReturnTrue() throws JsonProcessingException {
    Assert.assertTrue(productValidator.isValid(objectMapper.writeValueAsString(new ArrayList<>(Collections.singletonList(new Experience()))), null));
    Assert.assertTrue(productValidator.isValid(objectMapper.writeValueAsString(new Experience()), null), "");
    Assert.assertTrue(productValidator.isValid(objectMapper.writeValueAsString(new Accommodation()), null), "");
    Assert.assertTrue(productValidator.isValid(objectMapper.writeValueAsString(new Vehicle()), null), "");
  }
}
