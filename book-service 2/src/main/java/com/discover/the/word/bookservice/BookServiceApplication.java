package com.discover.the.word.bookservice;

import com.discover.the.word.bookservice.model.Book;
import com.discover.the.word.bookservice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Arrays;

@SpringBootApplication
@EnableEurekaClient
public class BookServiceApplication implements CommandLineRunner {
	private final BookRepository bookRepository;

	public BookServiceApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("Dunyanin Gozu", 2000, "2001", "Deneme", "AC2323");
		Book book2 = new Book("Dunyanin ADI", 2001, "2011", "Her Kimse", "AC3232");
		Book book3 = new Book("Dunyanin SANI", 2002, "2001", "Deneme", "45767");
		bookRepository.saveAll(Arrays.asList(book1,book2,book3));
	}
}
