package com.sdf.age.Service.Impl;

import com.sdf.age.Model.Option;
import com.sdf.age.Model.Question;
import com.sdf.age.Repository.OptionRepository;
import com.sdf.age.Service.OptionService;
import com.sdf.age.Service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {

    private final QuestionService questionService;
    private final OptionRepository optionRepository;
    public OptionServiceImpl(QuestionService questionService , OptionRepository optionRepository){
        this.questionService = questionService;
        this.optionRepository = optionRepository;
    }

    @Override
    public Option createOption(String option, String questionId) {
        Question question = questionService.getQuestionById(questionId);
        if (question != null) {
            Option newOption = new Option();
            newOption.setOptionValue(option);
            newOption.setQuestionId(questionId);

            question.getOptionList().add(newOption);

            question.setNoOfOption(question.getNoOfOption() + 1);

            newOption = optionRepository.save(newOption);

            questionService.save(question);

            return newOption;
        }

        return null;
    }


    @Override
    public List<Option> getAllOptionByQuestionId(String questionId) {
        return List.of();
    }

    @Override
    public Option getOptionById(String id) {
        return null;
    }

    @Override
    public void deleteOption(String optionId, String questionId) {
        Question question = questionService.getQuestionById(questionId);
        if(question != null){
            Option option = getOptionById(optionId);
            if (option != null){
                optionRepository.deleteById(optionId);
                question.getOptionList().remove(option);
                question.setNoOfOption(question.getNoOfOption() - 1);
                questionService.save(question);
            }
        }
    }

}
