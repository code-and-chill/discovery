package id.raidnav.products.eureka.controller.request;

import id.raidnav.products.eureka.domain.booking.BookingItem;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AddBookingRequest implements Serializable {
  private String username;
  private List<BookingItem> bookingItems;
  private String additionalData;
}
