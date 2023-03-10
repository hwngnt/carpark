package com.example.car_park.exception;

public class DuplicatedAccountException extends RuntimeException{
    public DuplicatedAccountException(String msg){
        super(msg);
    }
}
