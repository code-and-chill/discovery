package id.raidnav.products.eureka.domain.booking.request;

import id.raidnav.products.eureka.domain.booking.BookingType;
import id.raidnav.products.eureka.domain.product.ProductType;
import lombok.Getter;

@Getter
public class CreateBookingSpec {
    private String userId;
    private BookingType bookingType;
    private ProductType productType;
    private String bookingDetail;
}
