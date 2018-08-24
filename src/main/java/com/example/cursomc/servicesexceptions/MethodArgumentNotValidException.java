package com.example.cursomc.servicesexceptions;

public class MethodArgumentNotValidException extends RuntimeException{
    private  static final long serialVersionUID = 1L;
    public MethodArgumentNotValidException(String msg){
        super(msg);
    }
    public MethodArgumentNotValidException(String msg, Throwable cause){
        super(msg,cause);
    }
}
