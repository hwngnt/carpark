package com.example.car_park.advice;

import com.example.car_park.exception.DuplicatedAccountException;
import com.example.car_park.exception.DuplicatedEmailException;
import com.example.car_park.exception.DuplicatedPhoneException;
import com.example.car_park.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class APIExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<String> listOfErrors(MethodArgumentNotValidException e){
        List<String> exceptionalErrors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        return exceptionalErrors;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String notFoundErr(NotFoundException e){
        String notFoundError = e.getMessage();
        return notFoundError;
    }

    @ExceptionHandler(DuplicatedAccountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String duplicatedAccount(DuplicatedAccountException e){
        String err = e.getMessage();
        return err;
    }

    @ExceptionHandler(DuplicatedPhoneException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String duplicatedPhone(DuplicatedPhoneException e){
        String err = e.getMessage();
        return err;
    }

    @ExceptionHandler(DuplicatedEmailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String duplicatedEmail(DuplicatedEmailException e){
        String err = e.getMessage();
        return err;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String unknownException(Exception e){
        String err = e.getMessage();
        return err;
    }
}
