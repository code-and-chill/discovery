package id.raidnav.products.eureka.domain.product;

import lombok.Data;

import java.io.Serializable;

@Data
public class CancellationPolicy implements Serializable {
  private String description;
  private Integer hour;
  private String type;
  private Double amount;
}

