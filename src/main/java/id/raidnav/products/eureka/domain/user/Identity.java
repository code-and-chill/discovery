package id.raidnav.products.eureka.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
public class Identity {

    private final String type;
    private final String number;
    private final String title;
    private final String firstName;
    private final String midName;
    private final String lastName;
    private final Date availabilityDate;
    private final List<String> photoUrls;
}
