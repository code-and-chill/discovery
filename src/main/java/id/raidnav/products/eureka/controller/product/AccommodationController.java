package id.raidnav.products.eureka.controller.product;

import id.raidnav.products.eureka.domain.product.ProductType;
import id.raidnav.products.eureka.domain.product.accommodation.Accommodation;
import id.raidnav.products.eureka.exception.UnsupportedTypeException;
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

@Validated
@Controller("/products/accommodations")
public class AccommodationController {

    @Inject
    private ProductRepository productRepository;

    @Post()
    public HttpResponse<?> saveProduct(@Body @Valid Accommodation Accommodation) {
        return HttpResponse.status(HttpStatus.CREATED).body(Accommodation);
    }

    @Get(value = "?type={type}&page={page}&limit={limit}")
    public HttpResponse<?> getProducts(@PathVariable(value = "type") ProductType type,
                                       @PathVariable(value = "page") int page,
                                       @PathVariable(value = "limit") int limit) {
        switch (type) {
            case HOTEL:
            case VILLA:
            default:
                return HttpResponse
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new UnsupportedTypeException("").getMessage());
        }
    }

    @Put("/{id}")
    public HttpResponse<?> updateProduct(@PathVariable(value = "id") String id,
                                         @Body @Valid Accommodation Accommodation) {
        return HttpResponse.status(HttpStatus.ACCEPTED).body(Accommodation);
    }

    @Delete("/{id}")
    public HttpResponse<?> deleteProduct(@PathVariable(value = "id") String id) {
        return HttpResponse.status(HttpStatus.NO_CONTENT);
    }
}
