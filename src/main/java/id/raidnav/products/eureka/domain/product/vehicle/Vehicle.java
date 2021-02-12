package id.raidnav.products.eureka.domain.product.vehicle;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@Data
@Entity
public class Vehicle implements Serializable {
  @Id
  private Long id;
  private VehicleType type;
  private VehicleInfo vehicleInfo;
  private String code;
  private String name;
  private Port departure;
  private Port arrival;
  private DateTime departureTime;
  private DateTime arrivalTime;
  private DateTime vehicleDuration;
  private SeatClass seatClass;
}
