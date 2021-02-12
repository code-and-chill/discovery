package id.raidnav.products.eureka.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class InvalidProductSpecException extends Exception {
  private String message;
}
