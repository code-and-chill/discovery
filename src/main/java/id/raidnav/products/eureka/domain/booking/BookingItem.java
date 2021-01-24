package id.raidnav.products.eureka.domain.booking;

import id.raidnav.products.eureka.validation.ProductConstraint;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class BookingItem {
  @Id
  private Long id;
  @ProductConstraint
  private String item;
}
