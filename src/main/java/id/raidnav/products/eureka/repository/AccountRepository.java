package id.raidnav.products.eureka.repository;

import id.raidnav.products.eureka.domain.user.User;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface AccountRepository extends JpaRepository<User, String> {
  User findByUsername(String username);
}
