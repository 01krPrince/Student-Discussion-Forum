package com.sdf.age.Repository;

import com.sdf.age.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByUserId(String userId);

    public User findByPhone(String userPhone);

    public User findByUserName(String userName);

}
