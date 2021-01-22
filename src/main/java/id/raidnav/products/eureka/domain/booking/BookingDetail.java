package id.raidnav.products.eureka.domain.booking;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookingDetail<T> {

    private final Long id;
    private final Long bookingId;
    private final String productId;
    private final Double price;
    private final Integer quantity;
    private final T extras;
}
