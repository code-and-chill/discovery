package id.raidnav.products.eureka.service.booking;

import id.raidnav.products.eureka.domain.booking.Booking;
import id.raidnav.products.eureka.repository.BookingRepository;

import javax.inject.Inject;

public class AccommodationBookingService {

  @Inject
  private BookingRepository bookingRepository;

  public Booking create() {
    return new Booking();
  }
}
