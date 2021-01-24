package id.raidnav.products.eureka.domain.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContentPreference implements Serializable {
  private String country;
  private String currency;
  private String language;
}
