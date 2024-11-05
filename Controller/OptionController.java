package com.sdf.age.Controller;

import com.sdf.age.Model.Option;
import com.sdf.age.Service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sdf/option")
@CrossOrigin(origins = "*")
public class OptionController {
    @Autowired
    private final OptionService optionService;

    public OptionController(OptionService optionService){
        this.optionService = optionService;
    }

    @PostMapping("/addOption/")
    public Option createOption(@RequestParam String option , @RequestParam String questionId){
        return optionService.createOption(option , questionId);
    }

}


