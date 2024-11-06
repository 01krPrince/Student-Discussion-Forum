package com.sdf.age.Service.Impl;

import com.sdf.age.Model.Answer;
import com.sdf.age.Model.Question;
import com.sdf.age.Model.User;
import com.sdf.age.Repository.AnswerRepository;
import com.sdf.age.Service.AnswerService;
import com.sdf.age.Service.QuestionService;
import com.sdf.age.Service.UserService;
import org.springframework.stereotype.Service;

@Service
public class  AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final UserService userService;
    private final QuestionService questionService;
    public AnswerServiceImpl(AnswerRepository answerRepository , UserService userService , QuestionService questionService){
        this.answerRepository = answerRepository;
        this.userService = userService;
        this.questionService = questionService;
    }
    @Override
    public Answer postAnswer(String userId, String questionId, String answer) {
        User user = userService.findById(userId);
        Question question = questionService.getQuestionById(questionId);
        if (user != null && question != null) {
            Answer newAnswer = new Answer();
            newAnswer.setUserId(userId);
            newAnswer.setQuestionId(questionId);
            newAnswer.setAnswer(answer);

            newAnswer = answerRepository.save(newAnswer);
            question.getAnswerList().add(newAnswer);
            questionService.save(question);
            return newAnswer;
        }
        return null;
    }


    @Override
    public void save(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public Answer findById(String answerId) {
        return answerRepository.findById(answerId).orElse(null);
    }


}
