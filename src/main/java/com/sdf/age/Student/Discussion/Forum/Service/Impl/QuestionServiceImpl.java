package com.sdf.age.Student.Discussion.Forum.Service.Impl;

import com.sdf.age.Student.Discussion.Forum.Exception.MyException;
import com.sdf.age.Student.Discussion.Forum.Model.Question;
import com.sdf.age.Student.Discussion.Forum.Model.QuestionResponse;
import com.sdf.age.Student.Discussion.Forum.Model.User;
import com.sdf.age.Student.Discussion.Forum.Repository.QuestionRepository;
import com.sdf.age.Student.Discussion.Forum.Service.QuestionService;
import com.sdf.age.Student.Discussion.Forum.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final UserService userService;
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(UserService userService, QuestionRepository questionRepository) {
        this.userService = userService;
        this.questionRepository = questionRepository;
    }

    private static final Logger logger = Logger.getLogger(QuestionService.class.getName());

    @Override
    public Question postQuestion(QuestionResponse questionResponse) {
        User user = userService.findById(questionResponse.getUserId());
        if (user != null) {
            if (user.getUserId().equals(questionResponse.getUserId())) {
                Question newQuestion = new Question();
                newQuestion.setUserId(questionResponse.getUserId());
                newQuestion.setUserName(user.getUserName());
                newQuestion.setTitle(questionResponse.getTitle());
                newQuestion.setDescription(questionResponse.getDescription());
                newQuestion.setTag(questionResponse.getTag());

                String optionsString = questionResponse.getOption();
                if (optionsString != null && !optionsString.isEmpty()) {
                    String[] optionsArray = optionsString.split(",,");

                    List<String> optionList = new ArrayList<>();
                    int i=0;
                    for (String option : optionsArray) {
                        i++;
                        optionList.add(option.trim());
                    }
                    newQuestion.setNoOfOption(i);
                    newQuestion.setOptionList(optionList);
                }

                newQuestion.setDateTime(LocalDateTime.now());
                questionRepository.save(newQuestion);

                user.getQuestionList().add(newQuestion);
                userService.save(user);

                return newQuestion;
            } else {
                throw new MyException("Not an authorized user.");
            }
        } else {
            throw new MyException("User not found.");
        }
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
