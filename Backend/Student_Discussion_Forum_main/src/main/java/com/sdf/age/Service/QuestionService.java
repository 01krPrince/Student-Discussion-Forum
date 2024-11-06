package com.sdf.age.Service;

import com.sdf.age.Model.Question;

import java.util.List;

public interface QuestionService {

    public Question postQuestion(String userId , String title , String description , String tag);

    public List<Question> getAllQuestions();

    public List<Question> getAllQuestionByUserId(String userId);

    public Question getQuestionById(String id);

    public Question save(Question question);

    public Question updateQuestion(String userID, String questionId, String updatedQuestion);

}
