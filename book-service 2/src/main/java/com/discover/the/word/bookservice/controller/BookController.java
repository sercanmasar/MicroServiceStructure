package com.discover.the.word.bookservice.controller;

import com.discover.the.word.bookservice.dto.BookDto;
import com.discover.the.word.bookservice.dto.BookIdDto;
import com.discover.the.word.bookservice.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("v1/book")
@Validated
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBook(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookIdDto> getBookByIsbn(@NotEmpty @PathVariable("isbn") String isbn){
        return ResponseEntity.ok(bookService.getBookByIsbn(isbn));
    }

    @GetMapping("/book/{id}")
    public  ResponseEntity<BookDto> getBookById(@NotEmpty @PathVariable("id") String id){
        return ResponseEntity.ok(bookService.findBookDetailsById(id));
    }

}
