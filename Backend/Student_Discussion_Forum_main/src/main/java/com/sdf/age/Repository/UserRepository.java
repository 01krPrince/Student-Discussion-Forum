package com.sdf.age.Student.Discussion.Forum.Repository;

import com.sdf.age.Student.Discussion.Forum.Model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByUserId(String userId);

    public User findByPhone(String userPhone);

    public User findByUserName(String userName);

    public void deleteByUserId(ObjectId id);

}
