package id.raidnav.products.eureka.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Price {

    private String name;
    private String description;
    private Double amount;
}
