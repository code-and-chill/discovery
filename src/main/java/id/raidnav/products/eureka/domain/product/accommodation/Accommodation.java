package id.raidnav.products.eureka.domain.product.accommodation;

import id.raidnav.products.eureka.domain.product.CancellationPolicy;
import id.raidnav.products.eureka.domain.product.Price;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Accommodation {
    private Long id;
    private String name;
    private AccommodationType type;
    private String description;
    private List<String> imageUrls;
    private String geoLocation; // TODO: change data type
    private String checkInTime;
    private String checkOutTime;
    private List<Price> prices;
    private List<Facility> facilities;
    private List<CancellationPolicy> cancellationPolicies;
}

