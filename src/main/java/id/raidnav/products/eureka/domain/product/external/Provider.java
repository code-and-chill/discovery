package id.raidnav.products.eureka.domain.product.external;

import lombok.Data;

import java.io.Serializable;

@Data
public class Provider implements Serializable {
  private String id;
  private String name;
}
