package com.resolutech.spring5webapp.bootstrap;

import com.resolutech.spring5webapp.model.Author;
import com.resolutech.spring5webapp.model.Book;
import com.resolutech.spring5webapp.model.Publisher;
import com.resolutech.spring5webapp.repositories.AuthorRepository;
import com.resolutech.spring5webapp.repositories.BookRepository;
import com.resolutech.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository pubRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository pubRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.pubRepository = pubRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //Publishers
        Publisher hc = new Publisher("Harper Collins");
        Publisher w = new Publisher("Wrox");
        pubRepository.save(hc);
        pubRepository.save(w);


        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", hc);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", w);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
