package com.sdf.age.Student.Discussion.Forum.Service;


import com.sdf.age.Student.Discussion.Forum.Model.SignUpRequest;
import com.sdf.age.Student.Discussion.Forum.Model.User;

public interface UserService {

    public User signUp(SignUpRequest signUpRequest);

    public User findById(String userId);

    public User findByUserName(String userName);

    public User findByPhone(String userPhone);

    public User save(User newUser);

    public User login(String phoneNumber, String password);

    public void deleteUser(String userId);

}
