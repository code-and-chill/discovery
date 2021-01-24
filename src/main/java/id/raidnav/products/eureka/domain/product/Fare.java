package id.raidnav.products.eureka.domain.product;

import lombok.Data;
import org.joda.money.Money;

import java.io.Serializable;
import java.util.Map;

@Data
public class Fare implements Serializable {
  private FareType type;
  private Map<?, Money> prices;
}
