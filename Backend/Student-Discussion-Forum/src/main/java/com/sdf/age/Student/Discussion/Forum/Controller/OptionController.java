//package com.sdf.age.Student.Discussion.Forum.Controller;
//
//import com.sdf.age.Student.Discussion.Forum.Model.Option;
//import com.sdf.age.Student.Discussion.Forum.Service.OptionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/sdf/option")
//@CrossOrigin(origins = "*")
//public class OptionController {
//
//    @Autowired
//    private OptionService optionService;
//
//    @PostMapping("/addOption/")
//    public Option createOption(@RequestParam String option , @RequestParam String questionId){
//        return optionService.createOption(option , questionId);
//    }
//
//}
//
//
