package id.raidnav.products.eureka.exception;

import lombok.Getter;

@Getter
public class UnsupportedTypeException extends Exception {

  private final String message = "Unsupported product type";

  public UnsupportedTypeException() {
  }
}
