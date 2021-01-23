package id.raidnav.products.eureka.controller;

import id.raidnav.products.eureka.domain.activity.Activity;
import id.raidnav.products.eureka.repository.ActivityRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;

import javax.inject.Inject;
import javax.validation.Valid;

@Validated
@Controller("/activities")
public class ActivityController {

    @Inject
    private ActivityRepository ActivityRepository;

    @Post()
    public HttpResponse<?> saveActivity(@Body @Valid Activity activity) {
        this.ActivityRepository.createActivity(activity);
        return HttpResponse.status(HttpStatus.CREATED).body(activity);
    }

    @Get(value = "/{id}")
    public HttpResponse<?> getActivity(@PathVariable(value = "id") Long id) {
        Activity Activity = this.ActivityRepository.getActivity(id);
        return HttpResponse.status(HttpStatus.OK).body(Activity);
    }
}
