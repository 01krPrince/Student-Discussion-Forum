package com.sdf.age.Service.Impl;

import com.sdf.age.Model.Question;
import com.sdf.age.Model.User;
import com.sdf.age.Repository.OptionRepository;
import com.sdf.age.Repository.QuestionRepository;
import com.sdf.age.Service.QuestionService;
import com.sdf.age.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final UserService userService;
    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;

    @Autowired
    public QuestionServiceImpl(UserService userService, QuestionRepository questionRepository, OptionRepository optionRepository) {
        this.userService = userService;
        this.questionRepository = questionRepository;
        this.optionRepository = optionRepository;
    }

    @Override
    public Question postQuestion(String userId, String title, String description , String tag) {
        User user = userService.findById(userId);
        if (user != null && user.getUserId().equals(userId)) {
            Question newQuestion = new Question();
            newQuestion.setUserId(userId);
            newQuestion.setTitle(title);
            newQuestion.setDescription(description);
            newQuestion.setTag(tag);

            newQuestion.setDateTime(LocalDateTime.now());

            questionRepository.save(newQuestion);

            user.getQuestionList().add(newQuestion);
            userService.save(user);

            return newQuestion;
        }
        return null;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getAllQuestionByUserId(String userId) {
        return questionRepository.findByUserId(userId);
    }

    @Override
    public Question getQuestionById(String id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(String userID, String questionId, String updatedQuestion) {
        User user = userService.findById(userID);
        if (user != null) {
            Question question = getQuestionById(questionId);
            if (question != null && question.getUserId().equals(userID)) {
                question.setDescription(updatedQuestion);
                return questionRepository.save(question);
            }
        }
        return null;
    }

}
