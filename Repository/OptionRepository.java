package com.sdf.age.Repository;

import com.sdf.age.Model.Option;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OptionRepository extends MongoRepository<Option, String> {

}
