package id.raidnav.products.eureka.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

// TODO: revisit again
@AllArgsConstructor
@Getter
public class Security {
    private final boolean isLoginVerificationEnabled;
    private final boolean isTrustedDevice;
}
