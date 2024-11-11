package com.sdf.age.Student.Discussion.Forum.Service.Impl;

import com.sdf.age.Student.Discussion.Forum.Model.SignUpRequest;
import com.sdf.age.Student.Discussion.Forum.Model.User;
import com.sdf.age.Student.Discussion.Forum.Repository.UserRepository;
import com.sdf.age.Student.Discussion.Forum.Service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public User signUp(SignUpRequest signUpRequest) {
        if(findByPhone(signUpRequest.getPhone()) == null){
            User newUser = new User();
            newUser.setUserName(signUpRequest.getUsername());
            newUser.setPhone(signUpRequest.getPhone());
            newUser.setPassword(signUpRequest.getPassword());
            return userRepository.save(newUser);
        }
        return null;
    }

    public User findById(String userId){
        return userRepository.findByUserId(userId);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User findByPhone(String userPhone){
        return userRepository.findByPhone(userPhone);
    }

    @Override
    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User login(String phoneNumber, String password) {
        User user = this.findByPhone(phoneNumber);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteByUserId(new ObjectId(userId));
    }
}
