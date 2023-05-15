package com.example.demo.error;

public class NotFoundById extends Exception{
    public NotFoundById(String error){
        super(error);
    }
}