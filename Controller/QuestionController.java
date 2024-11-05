package com.sdf.age.Controller;

import com.sdf.age.Model.Question;
import com.sdf.age.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sdf/question")
@CrossOrigin(origins = "*")
public class QuestionController {
    @Autowired
    private final QuestionService questionService;
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @PostMapping("/newQuestion")
    public Question postQuestion(@RequestParam String userId , @RequestParam String title , @RequestParam String description ){
        return questionService.postQuestion(userId , title, description);
    }

    @PutMapping("/update")
    public Question updateQuestion(@RequestParam String userID , @RequestParam String questionId , @RequestParam String updatedQuestion){
        return questionService.updateQuestion(userID , questionId , updatedQuestion);
    }

    @GetMapping("/viewAllQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/viewMyQuestions")
    public List<Question> getAllQuestionByUserId(@RequestParam String userId){
        return questionService.getAllQuestionByUserId(userId);
    }

    @GetMapping("/byId")
    public Question getQuestionById(@RequestParam String id){
        return questionService.getQuestionById(id);
    }

}