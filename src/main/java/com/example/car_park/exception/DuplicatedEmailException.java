package com.example.car_park.exception;

public class DuplicatedEmailException extends RuntimeException{
    public DuplicatedEmailException(String msg){
        super(msg);
    }
}
