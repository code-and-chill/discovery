package id.raidnav.products.eureka.domain.product;

import lombok.Data;
import org.joda.time.DateTime;

import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
public class Price implements Serializable {
  private Long productId;
  private String description;
  @Min(0)
  private Double amount;
  private DateTime createdAt;
  private DateTime updatedAt;
}
