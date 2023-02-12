package com.discover.the.word.libraryservice.service;

import com.discover.the.word.libraryservice.dto.AddBookRequest;
import com.discover.the.word.libraryservice.dto.LibraryDto;
import com.discover.the.word.libraryservice.exception.LibraryNotFoundException;
import com.discover.the.word.libraryservice.feign.BookServiceClient;
import com.discover.the.word.libraryservice.library.LibraryRepository;
import com.discover.the.word.libraryservice.model.Library;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LibraryService {
    private final LibraryRepository repository;
    private final BookServiceClient client;
    public LibraryService(LibraryRepository repository, BookServiceClient client) {
        this.repository = repository;
        this.client = client;
    }

    public LibraryDto getAllBooksInLibraryById(String id){
        Library library = repository.findById(id).orElseThrow(()-> new LibraryNotFoundException("Library not found"));
        return new LibraryDto(library.getId(), library.getUserBook()
                .stream()
                .map(client::getBookById).map(ResponseEntity::getBody).collect(Collectors.toList()));
    }

    public LibraryDto createLibrary(){
        Library library = repository.save(new Library());
        return new LibraryDto(Objects.requireNonNull(library.getId()));
    }

    public void addBookToLibrary(AddBookRequest addBookRequest){
        final var bookId = client.getBookByIsbn(addBookRequest.getIsbn()).getBody().getId();
        Library library = repository.findById(addBookRequest.getId())
                .orElseThrow(() -> new LibraryNotFoundException("Library not found by id :" + addBookRequest.getId()));
        library.getUserBook().add(bookId);
        repository.save(library);
    }
}
