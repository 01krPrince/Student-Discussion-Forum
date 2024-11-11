package com.sdf.age.Student.Discussion.Forum.Repository;


import com.sdf.age.Student.Discussion.Forum.Model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepository extends MongoRepository<Question, String> {

    List<Question> findByUserId(String userId);

}
