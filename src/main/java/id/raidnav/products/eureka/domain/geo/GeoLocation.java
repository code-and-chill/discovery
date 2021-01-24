package id.raidnav.products.eureka.domain.geo;

import lombok.Data;

import java.io.Serializable;

@Data
public class GeoLocation implements Serializable {
  private double latitude;
  private double longitude;
}
