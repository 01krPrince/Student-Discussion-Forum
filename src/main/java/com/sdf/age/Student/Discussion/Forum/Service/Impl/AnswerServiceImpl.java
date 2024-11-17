package com.sdf.age.Student.Discussion.Forum.Service.Impl;

import com.sdf.age.Student.Discussion.Forum.Exception.MyException;
import com.sdf.age.Student.Discussion.Forum.Model.Answer;
import com.sdf.age.Student.Discussion.Forum.Model.Question;
import com.sdf.age.Student.Discussion.Forum.Model.User;
import com.sdf.age.Student.Discussion.Forum.Repository.AnswerRepository;
import com.sdf.age.Student.Discussion.Forum.Service.AnswerService;
import com.sdf.age.Student.Discussion.Forum.Service.QuestionService;
import com.sdf.age.Student.Discussion.Forum.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final UserService userService;
    private final QuestionService questionService;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository, UserService userService, QuestionService questionService) {
        this.answerRepository = answerRepository;
        this.userService = userService;
        this.questionService = questionService;
    }

    @Override
    public Answer postAnswer(String userId, String questionId, String answer) {
        User user = userService.findById(userId);
        Question question = questionService.getQuestionById(questionId);
        if (user != null) {
            if ( question != null){
                Answer newAnswer = new Answer();
                newAnswer.setUserId(userId);
                newAnswer.setUserName(user.getUserName());
                newAnswer.setQuestionId(questionId);
                newAnswer.setAnswer(answer);

                newAnswer = answerRepository.save(newAnswer);
                question.getAnswerList().add(newAnswer);
                questionService.save(question);
                return newAnswer;
            }
            throw new MyException("Question not found");
        }
        throw new MyException("User not found");
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
