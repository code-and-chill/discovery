package id.raidnav.products.eureka.domain.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class User implements Serializable {
  @Id
  private String username;
  private String email;
  private String password;
  @OneToMany
  private List<UserProvider> providers;
}
