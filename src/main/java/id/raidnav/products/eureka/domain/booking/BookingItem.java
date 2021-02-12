package id.raidnav.products.eureka.domain.booking;

import id.raidnav.products.eureka.validation.ProductConstraint;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@NoArgsConstructor
@Data
@Entity
public class BookingItem {
  @Id
  private Long id;
  private BookingType type;
  @ProductConstraint
  private String data;
  private BookingStatus status;
}
