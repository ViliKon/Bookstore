package com.myproject.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.myproject.bookstore.domain.Book;
import com.myproject.bookstore.domain.BookRepository;
import com.myproject.bookstore.domain.Category;
import com.myproject.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {

			crepository.save(new Category("Drama"));
			crepository.save(new Category("Dystopian"));
			crepository.save(new Category("Fantasy"));

			Book b1 = new Book("Scott Fitzgerald", "The Great Gatsby", "936288362", 1925,
					crepository.findByName("Drama").get(0));
			Book b2 = new Book("Harper Lee", "To Kill a Mockingbird", "637229934", 1960,
					crepository.findByName("Drama").get(0));
			Book b3 = new Book("George Orwell", "1984", "236217342", 1949, crepository.findByName("Dystopian").get(0));

			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
		};
	}

}
