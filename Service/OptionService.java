package com.sdf.age.Service;

import com.sdf.age.Model.Option;

import java.util.List;

public interface OptionService {

    public Option createOption(String option, String questionId);

    public List<Option> getAllOptionByQuestionId(String questionId);

    public Option getOptionById(String id);

}
