package id.raidnav.products.eureka.repository;

import id.raidnav.products.eureka.domain.product.Product;
import id.raidnav.products.eureka.domain.product.experience.Experience;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.type = :type ")
    Page<Experience> getProducts(String type, Pageable pageable);

}
