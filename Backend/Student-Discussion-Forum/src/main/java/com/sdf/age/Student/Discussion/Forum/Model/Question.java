package com.sdf.age.Student.Discussion.Forum.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Question")
public class Question {
    @Id
    private String id;
    private String userId;
    private String userName;
    private String title;
    private String description;
    private String tag = "";

    private String date;
    private String time;

    private List<Answer> answerList = new ArrayList<>();
    private int noOfOption = 0;
    private List<String> optionList = new ArrayList<>();
    private int likeCount = 0;
    private List<String> likedByUserId = new ArrayList<>();

    public void setDateTime(LocalDateTime dateTime) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.date = dateTime.format(dateFormatter);
        this.time = dateTime.format(timeFormatter);
    }
}
