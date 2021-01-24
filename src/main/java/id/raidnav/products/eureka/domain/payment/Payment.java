package id.raidnav.products.eureka.domain.payment;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@Entity
public class Payment implements Serializable {
  @Id
  private Long id;
  private Double amount;
  @OneToOne
  private PaymentDetail details;
}

