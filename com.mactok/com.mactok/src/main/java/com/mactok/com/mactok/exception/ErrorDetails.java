package com.mactok.com.mactok.exception;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

public class ErrorDetails {
    //time stamp
    //message
    //details

    private LocalDate timeStamp;
    private String message;
    private String details;

    public ErrorDetails(LocalDate timeStamp,String message,String details){
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
