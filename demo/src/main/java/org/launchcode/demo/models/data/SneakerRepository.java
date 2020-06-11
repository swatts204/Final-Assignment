package org.launchcode.demo.models.data;

import org.launchcode.demo.models.Sneaker;
import org.springframework.data.repository.CrudRepository;

public interface SneakerRepository extends CrudRepository<Sneaker, Integer> {
}
