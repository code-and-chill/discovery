package id.raidnav.products.eureka.domain.activity;

import id.raidnav.products.eureka.domain.product.Product;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Activity implements Serializable {
    @Id
    private Long id;
    private String username;
    @OneToMany
    private List<Product> products;
}
