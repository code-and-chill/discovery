package id.raidnav.products.eureka.domain.product.vehicle;

import id.raidnav.products.eureka.domain.geo.GeoLocation;
import lombok.Data;

import java.io.Serializable;

@Data
public class Port implements Serializable {
  private String code;
  private String name;
  private GeoLocation geoLocation;
  private String city;
  private String country;
}
