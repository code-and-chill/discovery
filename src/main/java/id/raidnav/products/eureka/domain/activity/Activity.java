package id.raidnav.products.eureka.domain.activity;

import id.raidnav.products.eureka.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Activity {

    private Long id;
    private String username;
    private List<Product> products;
}
