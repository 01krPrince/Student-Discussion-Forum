package com.sdf.age.Student.Discussion.Forum.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "User")
public class User {
    @Id
    private String userId;
    private String userName;
    private String phone;
    private String password;
    private List<Question> questionList = new ArrayList<>();
    private List<Answer> answeredList = new ArrayList<>();
}
