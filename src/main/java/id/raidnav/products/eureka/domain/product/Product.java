package id.raidnav.products.eureka.domain.product;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
public class Product implements Serializable {
  @Id
  private Long id;
  @NotNull
  private ProductType type;
  private String description;
  @Min(0)
  private Integer quantity;
  @Min(0)
  private Double price;
}
