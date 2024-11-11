package com.sdf.age.Student.Discussion.Forum.Repository;


import com.sdf.age.Student.Discussion.Forum.Model.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnswerRepository extends MongoRepository<Answer, String> {

}
