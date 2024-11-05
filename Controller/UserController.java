package com.sdf.age.Controller;

import com.sdf.age.Model.SignUpRequest;
import com.sdf.age.Model.User;
import com.sdf.age.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sdf/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signUp")
    public User signUp(@RequestBody SignUpRequest signUpRequest){
        return userService.signUp(signUpRequest);
    }

    @PostMapping("/login")
    public User login(@RequestParam String phoneNumber, @RequestParam String password){
        return userService.login(phoneNumber,password);
    }

}
