package id.raidnav.products.eureka.domain.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Payment {

    private final Long id;
    private final Double amount;
    private final PaymentDetail details;
}

