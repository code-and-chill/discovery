package id.raidnav.products.eureka.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Email {

    private final String address;
    private final boolean isSubscribed;
}
