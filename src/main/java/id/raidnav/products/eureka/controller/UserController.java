package id.raidnav.products.eureka.controller;

import id.raidnav.products.eureka.domain.user.Account;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;

import javax.validation.Valid;

@Controller("/users")
public class UserController {

  @Post()
  public HttpResponse<?> saveUser(@Body @Valid Account Account) {
    return HttpResponse.status(HttpStatus.CREATED).body(Account);
  }

  @Get(value = "/{username}")
  public HttpResponse<?> getUser(@PathVariable(value = "username") String name) {
    return HttpResponse.status(HttpStatus.OK).body(name);
  }

  @Put("/{id}")
  public HttpResponse<?> updateUser(@PathVariable(value = "id") String id, @Body @Valid Account Account) {
    return HttpResponse.status(HttpStatus.ACCEPTED).body(Account);
  }

  @Delete("/{username}")
  public HttpResponse<?> deleteUser(@PathVariable(value = "username") String name) {
    return HttpResponse.status(HttpStatus.NO_CONTENT);
  }
}
