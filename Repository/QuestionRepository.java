package com.sdf.age.Repository;

import com.sdf.age.Model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepository extends MongoRepository<Question, String> {

    List<Question> findByUserId(String userId);

}
