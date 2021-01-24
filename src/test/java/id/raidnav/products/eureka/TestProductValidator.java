package id.raidnav.products.eureka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.Assert;
import id.raidnav.products.eureka.domain.product.accommodation.Accommodation;
import id.raidnav.products.eureka.domain.product.experience.Experience;
import id.raidnav.products.eureka.validation.ProductValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestProductValidator {

  private ProductValidator productValidator;

  @BeforeEach
  public void before() {
    productValidator = new ProductValidator();
  }

  @Test
  public void testIsNotValidEmptyString() {
    String str = "[]";
    Assert.assertFalse(productValidator.isValid(str, null), "");
  }

  @Test
  public void testIsValid() throws JsonProcessingException {
    Experience experience = new Experience();
    Accommodation accommodation = new Accommodation();
    ObjectMapper objectMapper = new ObjectMapper();
    String expStr = objectMapper.writeValueAsString(experience);
    String accmStr = objectMapper.writeValueAsString(accommodation);
    Assert.assertTrue(productValidator.isValid(expStr, null), "");
    Assert.assertTrue(productValidator.isValid(accmStr, null), "");
  }
}
