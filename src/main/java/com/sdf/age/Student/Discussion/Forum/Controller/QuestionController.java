package com.sdf.age.Student.Discussion.Forum.Controller;

import com.sdf.age.Student.Discussion.Forum.Exception.ApiResponse;
import com.sdf.age.Student.Discussion.Forum.Model.Question;
import com.sdf.age.Student.Discussion.Forum.Model.QuestionResponse;
import com.sdf.age.Student.Discussion.Forum.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sdf/question")
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/newQuestion")
    public ApiResponse<Question> postQuestion(@RequestBody QuestionResponse questionResponse) {
        return new ApiResponse<>(questionService.postQuestion(questionResponse), HttpStatus.ACCEPTED);
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