package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher1 = new Publisher("John", "Paris");
        Publisher publisher2 = new Publisher("Mark", "London");

        publisherRepository.save(publisher1);
        publisherRepository.save(publisher2);


        Author author1 = new Author("Eric", "Evans");
        Book book1 = new Book("Domain Driven Design", "123");

        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);

        book1.setPublisher(publisher1);
        publisher1.getBooks().add(book1);

        authorRepository.save(author1);
        bookRepository.save(book1);

        Author author2 = new Author("John", "Higgins");
        Book book2 = new Book("Design Patterns", "456");

        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        book2.setPublisher(publisher2);
        publisher2.getBooks().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book2);

        System.out.println("Started in Bootstrap");


        System.out.println("books: " + bookRepository.count());
        System.out.println("Publishers: " + publisherRepository.findAll());
    }
}
