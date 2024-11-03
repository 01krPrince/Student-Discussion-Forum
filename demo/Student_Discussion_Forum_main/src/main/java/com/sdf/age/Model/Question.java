package com.sdf.age.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Question")
public class Question {
    @Id
    private String id;
    private String title;
    private String discription;
    private Date date;
    private Time time;
    private List<Answer> answerList = new ArrayList<>();
    private int noOfOption;
    private List<String> optionList = new ArrayList<>();
    private int likeCount;
    private List<User> likedByUserList = new ArrayList<>();
}
