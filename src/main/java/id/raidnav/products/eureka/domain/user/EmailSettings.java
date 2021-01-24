package id.raidnav.products.eureka.domain.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmailSettings implements Serializable {
  private Long id;
  private String address;
  private boolean isSubscribed;
}
