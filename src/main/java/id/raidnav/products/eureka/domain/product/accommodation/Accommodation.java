package id.raidnav.products.eureka.domain.product.accommodation;

import id.raidnav.products.eureka.domain.geo.GeoLocation;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Accommodation implements Serializable {
    @Id
    private Long id;
    private Long productId;
    private String name;
    private AccommodationType type;
    private String description;
    @ElementCollection
    private List<String> imageUrls;
    private String city;
    private String country;
    private GeoLocation geoLocation;
    private String checkInTime;
    private String checkOutTime;
    @ElementCollection
    private List<Facility> facilities;
}

