package id.raidnav.products.eureka.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CancellationPolicy {

    private String description;
    private Integer hour;
    private String type;
    private Double amount;
}

