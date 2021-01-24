package id.raidnav.products.eureka.service.product;

import id.raidnav.products.eureka.domain.product.external.Provider;

public interface ProductFactory {

    void fetch(Provider provider, Object spec);
}
