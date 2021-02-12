package id.raidnav.products.eureka.repository;

import id.raidnav.products.eureka.domain.booking.Booking;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import org.joda.time.DateTime;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

  @Query(
      value = "SELECT b FROM Booking b WHERE b.username = :username AND b.createdAt BETWEEN :from AND :to ORDER BY :pageable",
      countQuery = "SELECT b FROM Booking b WHERE b.username = :username AND b.createdAt BETWEEN :from AND :to"
  )
  Page<Booking> findByUsername(String username, DateTime from, DateTime to, Pageable pageable);
}
