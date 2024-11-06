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

    private String  userId; // who answered the question

    private String questionId;

    private String answer;
    private int likeCount = 0;
    private List<String > likedByUserIdList = new ArrayList<>();
}
