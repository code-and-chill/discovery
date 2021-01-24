package id.raidnav.products.eureka.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "price")
public class Price {
    @EmbeddedId
    private PriceKey priceKey;
    private String description;
    private Double amount;
}
