package com.myproject.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.myproject.bookstore.domain.Book;
import com.myproject.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book b1 = new Book("Scott Fitzgerald", "The Great Gatsby", 936288362, 1925);
			Book b2 = new Book("Harper Lee", "To Kill a Mockingbird", 637229934, 1960);
			Book b3 = new Book("1984", "George Orwell", 936288362, 1949);
			
			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
		};
	}

}
