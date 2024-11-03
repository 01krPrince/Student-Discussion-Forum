package com.sdf.age;

import com.sdf.age.Model.SignUpRequest;
import com.sdf.age.Model.User;

public interface UserService {

    User signUp(SignUpRequest signUpRequest);

    public User findById(String userId);

    public User findByUserName(String userName);

    public User findByPhone(String userPhone);

    public User save(User newUser);

    public User login(String phoneNumber, String password);
}
