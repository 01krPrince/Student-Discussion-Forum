package com.sdf.age.Student.Discussion.Forum.Controller;

import com.sdf.age.Student.Discussion.Forum.Exception.ApiResponse;
import com.sdf.age.Student.Discussion.Forum.Exception.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    // this api hits when app is throw internal server error {worked when 500}
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ApiResponse<Object> generalException(Exception e) {
        ApiResponse<Object> response = new ApiResponse<>(HttpStatus.OK);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        response.setErrorMessage("INTERNAL_SERVER_ERROR");
        return response;
    }

    // when user input is wrong {worked when 400}
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MyException.class)
    public ApiResponse<Object> badRequestExceptionHandler(MyException e) {
        ApiResponse<Object> response = new ApiResponse<>(HttpStatus.OK);
        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setErrorMessage(e.getMessage());
        return response;
    }

}