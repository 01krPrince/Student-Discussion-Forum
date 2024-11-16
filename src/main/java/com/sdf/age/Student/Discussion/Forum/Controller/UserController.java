package com.sdf.age.Student.Discussion.Forum.Controller;

import com.sdf.age.Student.Discussion.Forum.Model.SignUpRequest;
import com.sdf.age.Student.Discussion.Forum.Model.User;
import com.sdf.age.Student.Discussion.Forum.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sdf/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signUpUrl")
    public User signUp(@RequestBody SignUpRequest signUpRequest){
        return userService.signUp(signUpRequest);
    }

    @PostMapping("/login")
    public User login(@RequestParam String phoneNumber, @RequestParam String password){
        return userService.login(phoneNumber,password);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam String userId){
        userService.deleteUser(userId);
    }
}
