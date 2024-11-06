package com.sdf.age.Controller;

import com.sdf.age.Model.Answer;
import com.sdf.age.Service.AnswerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sdf/answer")
@CrossOrigin(origins = "*")
public class AnswerController {

    private final AnswerService answerService;
    public AnswerController(AnswerService answerService){
        this.answerService = answerService;
    }

    @PostMapping("/postAnswer")
    public Answer postAnswer(@RequestParam String userId , @RequestParam String questionId , @RequestParam String answer){
        return answerService.postAnswer(userId , questionId , answer);
    }

}
