package com.sdf.age.Repository;

import com.sdf.age.Model.Option;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OptionRepository extends MongoRepository<Option, String> {

    public List<Option> findAllByQuestionId(String questionId);

}
