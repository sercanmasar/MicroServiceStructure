package com.discover.the.word.bookservice.dto;

public record BookDto(
        BookIdDto bookIdDto,
        String title,
        int bookYear,
        String author,
        String pressName,
        String isbn
){}