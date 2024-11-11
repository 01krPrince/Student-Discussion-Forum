package com.sdf.age.Student.Discussion.Forum.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {
    private String userId;
    private String title;
    private String description;
    private String tag;
    private String option;
}
