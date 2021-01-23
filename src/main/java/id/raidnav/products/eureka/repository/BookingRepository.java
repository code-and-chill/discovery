package id.raidnav.products.eureka.repository;


import id.raidnav.products.eureka.domain.booking.Booking;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import org.joda.time.DateTime;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

  @Query("SELECT b FROM Booking b WHERE b.username = :username AND b.createdAt BETWEEN :from AND :to")
  List<Booking> findByUsername(String username, DateTime from, DateTime to);
}
