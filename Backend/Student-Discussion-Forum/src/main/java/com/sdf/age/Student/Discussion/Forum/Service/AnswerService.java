package com.sdf.age.Student.Discussion.Forum.Service;


import com.sdf.age.Student.Discussion.Forum.Model.Answer;

public interface AnswerService {

    public Answer postAnswer(String userId, String questionId, String answer);

    public void save(Answer answer);

    public Answer findById(String answerId);

}
