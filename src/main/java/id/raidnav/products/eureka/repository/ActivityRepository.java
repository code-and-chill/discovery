package id.raidnav.products.eureka.repository;

import id.raidnav.products.eureka.domain.activity.Activity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {
}
