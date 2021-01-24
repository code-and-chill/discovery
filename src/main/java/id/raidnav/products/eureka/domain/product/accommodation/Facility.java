package id.raidnav.products.eureka.domain.product.accommodation;

import lombok.Data;

import javax.persistence.ElementCollection;
import java.io.Serializable;
import java.util.List;

@Data
public class Facility implements Serializable {
    private String name;
    private Integer amount;
    private String iconUrl;
    @ElementCollection
    private List<String> descriptions;
}
