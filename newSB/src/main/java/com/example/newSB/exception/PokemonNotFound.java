package com.example.newSB.exception;

public class PokemonNotFound extends RuntimeException{
    public static final long serialversionUID=1;

    public PokemonNotFound(String msg)
    {
        super(msg);
    }
}
