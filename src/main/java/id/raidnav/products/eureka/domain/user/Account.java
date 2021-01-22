package id.raidnav.products.eureka.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Account {

    private final String provider;
    private final String id;
}
