package id.raidnav.products.eureka.domain.payment;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class PaymentOption implements Serializable {
  @Id
  private Long id;
  private String provider;
  private String number;
  private Date expirationDate;
}