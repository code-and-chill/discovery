package id.raidnav.products.eureka.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class PaymentOption {

    private final String provider;
    private final String number;
    private final Date expirationDate;

}