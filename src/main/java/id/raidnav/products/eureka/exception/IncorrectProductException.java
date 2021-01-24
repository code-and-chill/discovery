package id.raidnav.products.eureka.exception;

import lombok.Getter;

@Getter
public class IncorrectProductException extends Exception {

  private final String message;

  public IncorrectProductException(String message) {
    this.message = message;
  }
}
