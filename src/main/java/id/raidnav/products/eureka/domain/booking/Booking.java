package id.raidnav.products.eureka.domain.booking;

import id.raidnav.products.eureka.domain.Administration;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "booking",
    uniqueConstraints = @UniqueConstraint(columnNames = {"id"}),
    indexes = {
        @Index(name = "", columnList = "id")
    }
)
public class Booking extends Administration {
  private Long id;
  private String username;
  @Enumerated(EnumType.STRING)
  private BookingStatus status;
  @OneToMany
  private List<BookingItem> items;
  @TypeDef(type = DataType.JSON)
  private String additionalData;
}

