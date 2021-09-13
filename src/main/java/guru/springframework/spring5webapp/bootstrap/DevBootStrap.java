package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.respositories.AuthorRepository;
import guru.springframework.spring5webapp.respositories.BookRepository;
import guru.springframework.spring5webapp.respositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
            initData();
    }
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){

        Publisher publisher= new Publisher();
        publisher.setName("foo");

        publisherRepository.save(publisher);
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd= new Book ("Domian Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author rod= new Author("Rod", "Johnson");
        Book noEjb=new Book("J2EEE Development without ejb","23444", publisher );
        rod.getBooks().add(noEjb);

        authorRepository.save(rod);
        bookRepository.save(noEjb);

    }


}
