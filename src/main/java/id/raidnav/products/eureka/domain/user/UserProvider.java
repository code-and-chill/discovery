package id.raidnav.products.eureka.domain.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class UserProvider implements Serializable {
  @Id
  private String id;
  private String name;
  private String credentials;
}
