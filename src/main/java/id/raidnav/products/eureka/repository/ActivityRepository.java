package id.raidnav.products.eureka.repository;


import id.raidnav.products.eureka.domain.activity.Activity;
import io.micronaut.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface ActivityRepository extends CrudRepository<Activity, Long> {
}
