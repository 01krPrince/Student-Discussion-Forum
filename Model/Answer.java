package com.sdf.age.Model;

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
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Answer")
public class Answer {
    @Id
    private String id;
    private User user; // who answered the question
    private String QuestionId;
    private String answer;
    private int likeCount;
    private List<User> likedByUserList = new ArrayList<>();
}
