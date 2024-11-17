package com.sdf.age.Student.Discussion.Forum.Controller;

import com.sdf.age.Student.Discussion.Forum.Exception.ApiResponse;
import com.sdf.age.Student.Discussion.Forum.Model.SignUpRequest;
import com.sdf.age.Student.Discussion.Forum.Model.User;
import com.sdf.age.Student.Discussion.Forum.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sdf/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signUpUrl")
    public ApiResponse<User> signUp(@RequestBody SignUpRequest signUpRequest){
        return new ApiResponse<>(userService.signUp(signUpRequest), HttpStatus.ACCEPTED);
    }

    @PostMapping("/login")
    public ApiResponse<User> login(@RequestParam String phoneNumber, @RequestParam String password){
        return new ApiResponse<>(userService.login(phoneNumber,password), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam String userId){
        userService.deleteUser(userId);
    }
}
