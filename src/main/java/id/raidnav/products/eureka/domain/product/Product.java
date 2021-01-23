package id.raidnav.products.eureka.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product {

    private Long id;
    private ProductType type;
    private Object detail;
}
