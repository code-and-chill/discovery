package id.raidnav.products.eureka.domain.payment;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@Introspected
public class PaymentReversal implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private Long paymentId;
  private boolean isVerified;
  private DateTime createdAt;
  private DateTime updatedAt;
}
