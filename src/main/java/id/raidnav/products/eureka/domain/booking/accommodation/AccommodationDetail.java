package id.raidnav.products.eureka.domain.booking.accommodation;

import id.raidnav.products.eureka.domain.booking.BookingStatus;
import id.raidnav.products.eureka.domain.product.experience.Experience;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AccommodationDetail {

    private Long id;
    private Long bookingId;
    private Experience experience;
    private Double price;
    private Integer quantity;
    private BookingStatus status;
}
