package id.raidnav.products.eureka.domain.product.accommodation;

import id.raidnav.products.eureka.domain.product.CancellationPolicy;
import id.raidnav.products.eureka.domain.product.Price;
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
    private String geoLocation; // TODO: change data type
    private String checkInTime;
    private String checkOutTime;
    @ElementCollection
    private List<Price> prices;
    @ElementCollection
    private List<Facility> facilities;
    @ElementCollection
    private List<CancellationPolicy> cancellationPolicies;
}

