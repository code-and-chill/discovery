package id.raidnav.products.eureka.domain.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class EmailSettings implements Serializable {
  @Id
  private Long id;
  private String address;
  private boolean isSubscribed;
}
