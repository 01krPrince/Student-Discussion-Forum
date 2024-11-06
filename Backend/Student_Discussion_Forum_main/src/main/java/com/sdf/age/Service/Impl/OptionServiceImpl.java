package com.sdf.age.Service.Impl;

import com.sdf.age.Model.Option;
import com.sdf.age.Model.Question;
import com.sdf.age.Repository.OptionRepository;
import com.sdf.age.Repository.QuestionRepository;
import com.sdf.age.Service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionServiceImpl implements OptionService {

    private final QuestionRepository questionRepository;  // Inject QuestionRepository directly
    private final OptionRepository optionRepository;

    @Autowired
    public OptionServiceImpl(QuestionRepository questionRepository, OptionRepository optionRepository) {
        this.questionRepository = questionRepository;
        this.optionRepository = optionRepository;
    }

    @Override
    public Option createOption(String optionValue, String questionId) {
        Question question = questionRepository.findById(questionId).orElse(null);
        if (question != null) {
            Option newOption = new Option();
            newOption.setOptionValue(optionValue);
            newOption.setQuestionId(questionId);

            Option savedOption = optionRepository.save(newOption);
            question.getOptionList().add(savedOption);
            question.setNoOfOption(question.getNoOfOption() + 1);
            questionRepository.save(question);

            return savedOption;
        }
        return null;
    }

    @Override
    public List<Option> getAllOptionByQuestionId(String questionId) {
        return optionRepository.findAllByQuestionId(questionId);
    }

    @Override
    public Option getOptionById(String id) {
        return optionRepository.findById(id).orElse(null);
    }

}
