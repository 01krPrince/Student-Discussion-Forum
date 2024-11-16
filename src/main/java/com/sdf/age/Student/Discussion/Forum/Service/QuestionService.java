package com.sdf.age.Student.Discussion.Forum.Service;


import com.sdf.age.Student.Discussion.Forum.Model.Question;
import com.sdf.age.Student.Discussion.Forum.Model.QuestionResponse;

import java.util.List;

public interface QuestionService {

    public Question postQuestion(QuestionResponse questionResponse);

    public List<Question> getAllQuestions();

    public List<Question> getAllQuestionByUserId(String userId);

    public Question getQuestionById(String id);

    public Question save(Question question);

    public Question updateQuestion(String userID, String questionId, String updatedQuestion);

}
