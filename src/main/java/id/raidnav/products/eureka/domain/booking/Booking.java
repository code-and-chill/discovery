package id.raidnav.products.eureka.domain.booking;

import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;
import lombok.Data;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Booking implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String username;
  private BookingStatus status;
  @OneToMany
  private List<BookingItem> items;
  @TypeDef(type = DataType.JSON)
  private String additionalData;
  private DateTime createdAt;
  private DateTime updatedAt;
}

