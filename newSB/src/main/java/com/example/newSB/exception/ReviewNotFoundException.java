package com.example.newSB.exception;

public class ReviewNotFoundException extends RuntimeException{

    public static final long serialversionUID=2;

   public ReviewNotFoundException(String msg)
    {
        super(msg);

    }
}
