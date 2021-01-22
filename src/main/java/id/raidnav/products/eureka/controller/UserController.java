package id.raidnav.products.eureka.controller;

import id.raidnav.products.eureka.domain.user.User;
import id.raidnav.products.eureka.repository.UserRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller("/users")
public class UserController {

    @Inject
    private UserRepository userRepository;

    @Post()
    public HttpResponse<?> saveUser(@Body @Valid User User) {
        this.userRepository.createUser(User);
        return HttpResponse.status(HttpStatus.CREATED).body(User);
    }

    @Get(value = "/{username}")
    public HttpResponse<?> getUser(@PathVariable(value = "username") String name) {
        User user = this.userRepository.getUser(name);
        return HttpResponse.status(HttpStatus.OK).body(user);
    }

    @Put("/{id}")
    public HttpResponse<?> updateUser(@PathVariable(value = "id") String id, @Body @Valid User User) {
        this.userRepository.updateUser(id, User);
        return HttpResponse.status(HttpStatus.ACCEPTED).body(User);
    }

    @Delete("/{username}")
    public HttpResponse<?> deleteUser(@PathVariable(value = "username") String name) {
        this.userRepository.deleteUser(name);
        return HttpResponse.status(HttpStatus.NO_CONTENT);
    }
}
