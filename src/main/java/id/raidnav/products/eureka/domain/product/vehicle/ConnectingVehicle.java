package id.raidnav.products.eureka.domain.product.vehicle;

import lombok.Data;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.List;

@Data
public class ConnectingVehicle implements Serializable {
  private Long id;
  private List<Vehicle> vehicles;
  private List<DateTime> transitTimes;
}
