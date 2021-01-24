package id.raidnav.products.eureka.service.booking;

import id.raidnav.products.eureka.domain.booking.Booking;
import id.raidnav.products.eureka.exception.DataNotFoundException;
import id.raidnav.products.eureka.repository.BookingRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Slf4j
public class BookingService {

  @Inject
  private TransportationBookingService transportationService;

  @Inject
  private AccommodationBookingService accommodationService;

  @Inject
  private FinancialBookingService financialService;

  @Inject
  private ExperienceBookingService experienceService;

  @Inject
  private BookingRepository bookingRepository;


  public Booking createBooking(Object spec) {
//    switch (spec.getBookingType()) {
//      case TRANSPORTATION:
//        return transportationService.create();
//      case ACCOMMODATION:
//        return accommodationService.create();
//      case EXPERIENCE:
//        return experienceService.create();
//      case FINANCIAL:
//        return financialService.create();
//      default:
//        throw new UnsupportedTypeException("");
//    }
    return null;
  }

  public Booking getBooking(Long id) throws Exception {
    // redis, db
    Optional<Booking> booking = bookingRepository.findById(id);
    if (booking.isPresent()) {
      return booking.get();
    }
    throw new DataNotFoundException("");
  }

  public List<Booking> getBookings(String username, DateTime from, DateTime to) {
    return bookingRepository.findByUsername(username, from, to);
  }
}
