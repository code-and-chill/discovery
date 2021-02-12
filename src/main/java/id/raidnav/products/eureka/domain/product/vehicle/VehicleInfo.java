package id.raidnav.products.eureka.domain.product.vehicle;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@NoArgsConstructor
@Data
public class VehicleInfo implements Serializable {
  private String craft;
  private String seatLayout;
  private String seatPitch;
  private List<Baggage> baggages;
  private boolean hasMeal;
  private boolean hasEntertainment;
}
