package id.raidnav.products.eureka.controller;

import id.raidnav.products.eureka.domain.booking.Booking;
import id.raidnav.products.eureka.domain.booking.request.CreateBookingSpec;
import id.raidnav.products.eureka.exception.DataNotFoundException;
import id.raidnav.products.eureka.exception.IncorrectProductException;
import id.raidnav.products.eureka.exception.UnsupportedTypeException;
import id.raidnav.products.eureka.repository.BookingRepository;
import id.raidnav.products.eureka.service.booking.BookingService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.validation.Validated;
import org.joda.time.DateTime;

import javax.inject.Inject;
import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@Validated
@Controller("bookings")
public class BookingController {

    @Inject
    private BookingService bookingService;

    @Inject
    private BookingRepository bookingRepository;

    @Post()
    public HttpResponse<?> createBooking(@Body @Valid CreateBookingSpec bookingSpec) {
        try {
            Booking booking = this.bookingService.createBooking(bookingSpec);
            return HttpResponse.status(HttpStatus.CREATED).body(booking);
        } catch (IncorrectProductException | UnsupportedTypeException e) {
            return HttpResponse.status(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Get(value = "/{id}")
    public HttpResponse<?> getBooking(@PathVariable(value = "id") Long id) {
        try {
            Booking booking = this.bookingService.getBooking(id);
            return HttpResponse.status(HttpStatus.OK).body(booking);
        } catch (DataNotFoundException dnfe) {
            return HttpResponse.status(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Get(value = "?username={username}&from={from}&to={to}")
    public HttpResponse<?> getBookings(@PathVariable(value = "username") String username,
                                       @PathVariable(value = "from") String from,
                                       @PathVariable(value = "to") String to) {
        List<Booking> booking = this.bookingService.getBookings(username, DateTime.parse(from), DateTime.parse(to));
        return HttpResponse.status(HttpStatus.OK).body(booking);
    }

    @Put("/{id}")
    public HttpResponse<?> updateBooking(@PathVariable(value = "id") String id,
                                         @Body @Valid Booking booking) {
        this.bookingRepository.save(booking);
        return HttpResponse.status(HttpStatus.ACCEPTED).body(booking);
    }

    @Delete("/{id}")
    public HttpResponse<?> cancelBooking(@PathVariable(value = "id") String name, @Body String reason) {
        return HttpResponse.status(HttpStatus.NO_CONTENT);
    }
}
