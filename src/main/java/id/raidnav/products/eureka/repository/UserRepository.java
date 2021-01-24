package id.raidnav.products.eureka.repository;

import id.raidnav.products.eureka.domain.user.Account;
import io.micronaut.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Account, Long> {
}
