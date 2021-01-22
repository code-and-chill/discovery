package id.raidnav.products.eureka.domain.booking;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Booking<T> {

    private final Long id;
    private final String userId;
    private final List<BookingDetail<T>> details;
}

