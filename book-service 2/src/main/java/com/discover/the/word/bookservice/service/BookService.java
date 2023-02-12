package com.discover.the.word.bookservice.service;

import com.discover.the.word.bookservice.dto.BookDto;
import com.discover.the.word.bookservice.dto.BookIdDto;
import com.discover.the.word.bookservice.exception.BookNotFoundException;
import com.discover.the.word.bookservice.mapper.BookMapper;
import com.discover.the.word.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }
    public List<BookDto> getAllBooks(){
       return bookRepository.findAll().stream().map(bookMapper::toBookDto).collect(Collectors.toList());
    }
    public BookIdDto getBookByIsbn(String isbn){
        return bookRepository.findBookByIsbn(isbn).map(book -> new BookIdDto(book.getId(), Objects.requireNonNull(book.getIsbn())))
                .orElseThrow(()-> new BookNotFoundException("Book could not found by isbn:" + isbn));
    }
    public BookDto findBookDetailsById(String id){
        return bookRepository.findById(id).map(bookMapper::toBookDto).orElseThrow(()-> new BookNotFoundException("Book Could not found by id:" + id));
    }
}
