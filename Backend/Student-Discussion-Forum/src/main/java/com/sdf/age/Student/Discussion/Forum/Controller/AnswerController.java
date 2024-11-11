package com.sdf.age.Student.Discussion.Forum.Controller;

import com.sdf.age.Student.Discussion.Forum.Model.Answer;
import com.sdf.age.Student.Discussion.Forum.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sdf/answer")
@CrossOrigin(origins = "*")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/postAnswer")
    public Answer postAnswer(@RequestParam String userId , @RequestParam String questionId , @RequestParam String answer){
        return answerService.postAnswer(userId , questionId , answer);
    }

}
