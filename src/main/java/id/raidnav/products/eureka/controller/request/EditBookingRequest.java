package id.raidnav.products.eureka.controller.request;

import id.raidnav.products.eureka.domain.booking.BookingStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class EditBookingRequest implements Serializable {
  private String username;
  private Map<Long, BookingStatus> bookingItemStatus;
  private BookingStatus status;
  private String additionalData;
}
