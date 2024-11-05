package com.sdf.age.Model;

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
@Document(collection = "question")
public class Question {
    @Id
    private String id;
    private String userId;
    private String title;
    private String description;

    private String date;
    private String time;

    private List<Answer> answerList = new ArrayList<>();
    private int noOfOption = 0;
    private List<Option> optionList = new ArrayList<>();
    private int likeCount = 0;
    private List<User> likedByUserList = new ArrayList<>();

    public void setDateTime(LocalDateTime dateTime) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.date = dateTime.format(dateFormatter);
        this.time = dateTime.format(timeFormatter);
    }
}
