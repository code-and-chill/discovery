package id.raidnav.products.eureka.domain.payment;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class PaymentDetail implements Serializable {
  @Id
  private Long id;
}
