package id.raidnav.products.eureka.domain.product.vehicle;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Vehicle implements Serializable {
  @Id
  private Long id;

}
