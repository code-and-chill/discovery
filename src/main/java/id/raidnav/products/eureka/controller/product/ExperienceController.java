package id.raidnav.products.eureka.controller.product;

import id.raidnav.products.eureka.domain.product.experience.Experience;
import id.raidnav.products.eureka.repository.ProductRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
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
@Controller("/products/experiences")
public class ExperienceController {

    @Inject
    private ProductRepository productRepository;

    @Post()
    public HttpResponse<?> saveProduct(@Body @Valid Experience experience) {
        return HttpResponse.status(HttpStatus.CREATED).body(experience);
    }

    @Get(value = "?type={type}&page={page}&limit={limit}")
    public HttpResponse<?> getProducts(@PathVariable(value = "type") String type,
                                       @PathVariable(value = "page") int page,
                                       @PathVariable(value = "limit") int limit) {
        Pageable pagination = Pageable.from(page, limit);
        Page<Experience> experiences = this.productRepository.getProducts(type, pagination);
        return HttpResponse.status(HttpStatus.OK).body(experiences);
    }

    @Put("/{id}")
    public HttpResponse<?> updateProduct(@PathVariable(value = "id") String id,
                                         @Body @Valid Experience experience) {
        return HttpResponse.status(HttpStatus.ACCEPTED).body(experience);
    }

    @Delete("/{id}")
    public HttpResponse<?> deleteProduct(@PathVariable(value = "id") String id) {
        return HttpResponse.status(HttpStatus.NO_CONTENT);
    }
}
