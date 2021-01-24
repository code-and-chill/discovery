package id.raidnav.products.eureka.domain.product;

import id.raidnav.products.eureka.validation.ProductConstraint;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Product implements Serializable {
  @Id
  private Long id;
  private ProductType type;
  private String description;
  @Min(0)
  private Integer quantity;
  @ProductConstraint
  private String detail;
  @ElementCollection
  private List<Fare> prices;
  @ElementCollection
  private List<CancellationPolicy> cancellationPolicies;
  private String termsAndConditions;
}
