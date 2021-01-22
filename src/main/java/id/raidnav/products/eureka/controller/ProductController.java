package id.raidnav.products.eureka.controller;

import id.raidnav.products.eureka.domain.product.Product;
import id.raidnav.products.eureka.repository.ProductRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.validation.Validated;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@Validated
@Controller("/products")
public class ProductController {

    @Inject
    private ProductRepository productRepository;

    @Post()
    public HttpResponse<?> saveProduct(@Body @Valid Product product) {
        this.productRepository.createProduct(product);
        return HttpResponse.status(HttpStatus.CREATED).body(product);
    }

    @Get(value = "?type={type}&page={page}&limit={limit}")
    public HttpResponse<?> getProducts(@PathVariable(value = "type") String type,
                                       @PathVariable(value = "page") int page,
                                       @PathVariable(value = "limit") int limit) {
        List<Product> products = this.productRepository.getProducts(type, page, limit);
        return HttpResponse.status(HttpStatus.OK).body(products);
    }

    @Put("/{id}")
    public HttpResponse<?> updateProduct(@PathVariable(value = "id") String id, @Body @Valid Product product) {
        this.productRepository.updateProduct(id, product);
        return HttpResponse.status(HttpStatus.ACCEPTED).body(product);
    }

    @Delete("/{id}")
    public HttpResponse<?> deleteProduct(@PathVariable(value = "id") String id) {
        this.productRepository.deleteProduct(id);
        return HttpResponse.status(HttpStatus.NO_CONTENT);
    }
}
