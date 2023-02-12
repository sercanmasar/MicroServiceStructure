package com.discover.the.word.libraryservice.exception;

public class BookNotFoundException extends RuntimeException {
    private ExceptionMessage exceptionMessage;
    public BookNotFoundException(String s) {
        super(s);
    }

    public BookNotFoundException(ExceptionMessage exceptionMessage){
        this.exceptionMessage = exceptionMessage;
    }
    public BookNotFoundException(String message, ExceptionMessage exceptionMessage){
        super(message);
        this.exceptionMessage = exceptionMessage;
    }
    public ExceptionMessage getExceptionMessage(){
        return exceptionMessage;
    }
}
