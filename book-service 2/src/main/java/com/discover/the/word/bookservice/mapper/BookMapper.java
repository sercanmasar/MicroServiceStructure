package com.discover.the.word.bookservice.mapper;

import com.discover.the.word.bookservice.dto.BookDto;
import com.discover.the.word.bookservice.dto.BookIdDto;
import com.discover.the.word.bookservice.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookMapper {

    public BookDto toBookDto(Book book){
    return new BookDto(
            new BookIdDto(book.getId(), book.getIsbn()),
            book.getTitle(),
            book.getBookYear(),
            book.getAuthor(),
            book.getPressName(),
            book.getIsbn());
    }
}
