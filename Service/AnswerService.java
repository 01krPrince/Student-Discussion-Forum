package com.sdf.age.Service;

import com.sdf.age.Model.Answer;

public interface AnswerService {

    public Answer postAnswer(String userId, String questionId, String answer);

    public void save(Answer answer);

    public Answer findById(String answerId);

}
