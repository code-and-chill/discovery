package id.raidnav.products.eureka.domain.booking.accommodation;

import id.raidnav.products.eureka.domain.booking.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AccommodationBooking {

    private Long id;
    private String userId;
    private List<AccommodationDetail> details;
    private BookingStatus status;
    private String additionalBookingDetail;
}

