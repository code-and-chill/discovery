package id.raidnav.products.eureka.domain.user;

import id.raidnav.products.eureka.domain.payment.PaymentOption;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class User {

    private final String id;
    private final String type;
    private final Visibility visibility;
    private final String photoUrl;
    private final Contact contact;
    private final Identity identity;
    private final Security security;
    private final ContentPreference contentPreference;
    private final Map<String, Boolean> pushNotifications;
    private final Map<String, Boolean> newsletterSubscriptions;
    private final List<Identity> relatives;
    private final Loyalty loyalty;
    private final Long rewards;
    private final List<PaymentOption> paymentOptions;
    private final Date joinedDate;

}


