package id.raidnav.products.eureka.domain.user;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@Getter
@Introspected
public class Contact {

    @Size(min = 6, max = 50)
    private final String fullName;
    private final String gender;
    private final String cityOfResidence;
    private final List<Email> emails;
    private final List<String> phoneNumbers;
    private final List<Account> linkedAccounts;
}
