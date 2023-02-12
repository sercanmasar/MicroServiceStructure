package com.discover.the.word.libraryservice.exception;

public record ExceptionMessage(
        String timestamp,
        Integer status,
        String error,
        String message,
        String path){}
