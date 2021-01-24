package id.raidnav.products.eureka.repository;

import id.raidnav.products.eureka.domain.user.Account;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
  Account findByUsername(String username);
}
