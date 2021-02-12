package id.raidnav.products.eureka.domain;

import lombok.Data;
import org.joda.time.DateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Administration {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String uuid;

  private DateTime createdAt;
  private DateTime updatedAt;
}
