package id.raidnav.products.eureka.service.booking;

import id.raidnav.products.eureka.controller.request.AddBookingRequest;
import id.raidnav.products.eureka.controller.request.EditBookingRequest;
import id.raidnav.products.eureka.converter.ProductSpecValidator;
import id.raidnav.products.eureka.domain.booking.Booking;
import id.raidnav.products.eureka.domain.booking.BookingItem;
import id.raidnav.products.eureka.domain.booking.BookingStatus;
import id.raidnav.products.eureka.exception.DataNotFoundException;
import id.raidnav.products.eureka.exception.InvalidProductSpecException;
import id.raidnav.products.eureka.repository.BookingRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.Sort;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Singleton
public class BookingService {

  @Inject
  private BookingRepository bookingRepository;

  @Inject
  private ProductSpecValidator resolver;

  public Booking createBooking(AddBookingRequest bookingRequest) throws Exception {
    Booking booking = new Booking();
    List<BookingItem> items = new ArrayList<>();
    for (BookingItem item : bookingRequest.getBookingItems()) {
      if (!resolver.hasMatchingType(item.getType(), item.getData()))
        throw new InvalidProductSpecException(String.format("Invalid spec for booking item: %d", item.getId()));
    }
    booking.setItems(items);
    booking.setAdditionalData(bookingRequest.getAdditionalData());
    booking.setCreatedAt(DateTime.now());
    return bookingRepository.save(booking);
  }

  public Booking getBooking(Long id) throws Exception {
    // redis, db
    Optional<Booking> booking = bookingRepository.findById(id);
    if (booking.isPresent()) {
      return booking.get();
    }
    throw new DataNotFoundException(String.format("Booking id: %d was not found.", id));
  }

  public Page<Booking> getBookings(String username, DateTime from, DateTime to, int page, int size, String sortDirection) throws Exception {
    // redis, db
    Sort sort = Sort.of(Collections.singletonList(new Sort.Order("createdAt", Sort.Order.Direction.valueOf(sortDirection), true)));
    Page<Booking> bookings = bookingRepository.findByUsername(username, from, to, Pageable.from(page, size, sort));
    if (bookings.isEmpty()) {
      throw new DataNotFoundException("");
    }
    return bookings;
  }

  public Booking updateBooking(Long id, EditBookingRequest request) throws Exception {
    Booking booking;
    try {
      booking = getBooking(id);
    } catch (DataNotFoundException dnfe) {
      throw new InvalidProductSpecException(String.format("Unable to modify non-existent booking: %d", id));
    }
    for (Map.Entry<Long, BookingStatus> itemStatus : request.getBookingItemStatus().entrySet()) {
      Long itemId = itemStatus.getKey();
      BookingStatus newStatus = itemStatus.getValue();
      for (BookingItem item : booking.getItems()) {
        if (item.getId().equals(itemId)) {
          item.setStatus(newStatus);
        }
      }
    }
    booking.setStatus(request.getStatus());
    booking.setUpdatedAt(DateTime.now());
    return bookingRepository.save(booking);
  }
}
