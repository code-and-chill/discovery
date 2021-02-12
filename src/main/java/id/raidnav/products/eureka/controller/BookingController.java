package id.raidnav.products.eureka.controller;

import id.raidnav.products.eureka.controller.request.AddBookingRequest;
import id.raidnav.products.eureka.controller.request.EditBookingRequest;
import id.raidnav.products.eureka.domain.booking.Booking;
import id.raidnav.products.eureka.exception.DataNotFoundException;
import id.raidnav.products.eureka.exception.InvalidProductSpecException;
import id.raidnav.products.eureka.exception.UnsupportedTypeException;
import id.raidnav.products.eureka.service.booking.BookingService;
import io.micrometer.core.annotation.Timed;
import io.micronaut.data.model.Page;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.validation.Validated;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

import javax.inject.Inject;
import javax.management.Query;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@Timed
@Validated
@Controller("bookings")
public class BookingController {

  @Inject
  private BookingService bookingService;

  @Post()
  public HttpResponse<?> createBooking(@Body @Valid AddBookingRequest request) {
    try {
      Booking booking = this.bookingService.createBooking(request);
      return HttpResponse.status(HttpStatus.CREATED).body(booking);
    } catch (InvalidProductSpecException | UnsupportedTypeException inv) {
      return HttpResponse.status(HttpStatus.BAD_REQUEST).body(inv.getMessage());
    } catch (Exception e) {
      return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @Get(value = "/{id}")
  public HttpResponse<?> getBooking(@PathVariable(value = "id") Long id) {
    try {
      Booking booking = this.bookingService.getBooking(id);
      return HttpResponse.status(HttpStatus.OK).body(booking);
    } catch (DataNotFoundException dnfe) {
      return HttpResponse.status(HttpStatus.NOT_FOUND).body(dnfe.getMessage());
    } catch (Exception e) {
      return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @Get(value = "?username={username}&from={from}&to={to}")
  public HttpResponse<?> getBookings(@PathVariable(value = "username") String username,
                                     @PathVariable(value = "from") String from,
                                     @PathVariable(value = "to") String to,
                                     @QueryValue(defaultValue = "1") Integer page,
                                     @QueryValue(defaultValue = "8") Integer size,
                                     @QueryValue(defaultValue = "ASC") String sortDirection) {
    try {
      Page<Booking> booking = this.bookingService.getBookings(username, DateTime.parse(from), DateTime.parse(to), page, size, sortDirection);
      return HttpResponse.status(HttpStatus.OK).body(booking);
    } catch (DataNotFoundException dnfe) {
      return HttpResponse.status(HttpStatus.NOT_FOUND).body(dnfe.getMessage());
    } catch (Exception e) {
      log.error(String.format("[BookingController] getBookings - %s", e.getMessage()));
      return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Put("/{id}")
  public HttpResponse<?> updateBooking(@PathVariable(value = "id") Long id,
                                       @Body @Valid EditBookingRequest request) {
    try {
      Booking booking = this.bookingService.updateBooking(id, request);
      return HttpResponse.status(HttpStatus.OK).body(booking);
    } catch (InvalidProductSpecException ipse) {
      return HttpResponse.status(HttpStatus.BAD_REQUEST).body(ipse.getMessage());
    } catch (Exception e) {
      return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @Delete("/{id}")
  public HttpResponse<?> cancelBooking(@PathVariable(value = "id") Long id, @Body EditBookingRequest reason) {
    try {
      this.bookingService.updateBooking(id, reason);
    } catch (InvalidProductSpecException ipse) {
      return HttpResponse.status(HttpStatus.BAD_REQUEST).body(ipse.getMessage());
    } catch (Exception e) {
      log.error(String.format("[BookingController] cancelBooking - %s", e.getMessage()));
      return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return HttpResponse.status(HttpStatus.NO_CONTENT);
  }
}
