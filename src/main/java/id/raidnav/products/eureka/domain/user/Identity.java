package id.raidnav.products.eureka.domain.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Identity implements Serializable {
  private String type;
  private String number;
  private String title;
  private String firstName;
  private String midName;
  private String lastName;
  private Date availabilityDate;
  private List<String> photoUrls;
}
