package com.sdf.age.Repository;

import com.sdf.age.Model.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnswerRepository extends MongoRepository<Answer , String> {

}
