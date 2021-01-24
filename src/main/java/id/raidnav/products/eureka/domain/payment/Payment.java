package id.raidnav.products.eureka.domain.payment;

import lombok.Data;
import org.joda.money.Money;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Payment implements Serializable {
  @Id
  private Long id;
  private Money amount;
}

