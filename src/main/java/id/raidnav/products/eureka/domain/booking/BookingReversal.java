package id.raidnav.products.eureka.domain.booking;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class BookingReversal implements Serializable {
  @Id
  private Long id;
}
