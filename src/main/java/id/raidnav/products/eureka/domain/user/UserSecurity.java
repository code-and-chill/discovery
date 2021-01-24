package id.raidnav.products.eureka.domain.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserSecurity implements Serializable {
  private boolean isLoginVerificationEnabled;
  private boolean isTrustedDevice;
}
