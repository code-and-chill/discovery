package id.raidnav.products.eureka.domain.product.accommodation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import id.raidnav.products.eureka.domain.product.CancellationPolicy;
import id.raidnav.products.eureka.domain.product.Price;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "accommodation")
public class Accommodation {
    @Id
    private Long id;
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_PRODUCT_ID"))
    private Long productId;
    private String name;
    private AccommodationType type;
    private String description;
    @JsonIgnore
    @OneToMany
    private List<String> imageUrls;
    private String geoLocation; // TODO: change data type
    private String checkInTime;
    private String checkOutTime;
    @JsonIgnore
    private List<Price> prices;
    private List<Facility> facilities;
    private List<CancellationPolicy> cancellationPolicies;
}

