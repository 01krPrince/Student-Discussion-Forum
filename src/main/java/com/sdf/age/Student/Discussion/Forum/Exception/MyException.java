package com.sdf.age.Student.Discussion.Forum.Exception;

import org.springframework.context.ApplicationContextException;

public class MyException extends ApplicationContextException {
    public MyException(String message){
        super(message);
    }
}