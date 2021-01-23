package id.raidnav.products.eureka.service.booking.transportation;

import id.raidnav.products.eureka.domain.booking.Booking;
import id.raidnav.products.eureka.repository.BookingRepository;

import javax.inject.Inject;

public class FinancialBookingService {

  @Inject
  private BookingRepository bookingRepository;

  public Booking create() {
    return new Booking();
  }
}
