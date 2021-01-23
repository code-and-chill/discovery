package id.raidnav.products.eureka.domain.booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Booking {

    @Id
    private Long id;
    private String username;
    private String details;
    private BookingStatus status;
    private String additionalBookingDetail;
    private DateTime createdAt;
}

