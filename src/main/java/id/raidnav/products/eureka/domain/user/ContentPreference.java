package id.raidnav.products.eureka.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ContentPreference {

    private final String country;
    private final String currency;
    private final String language;
}
