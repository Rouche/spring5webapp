package com.resolutech.spring5webapp.repositories;

import com.resolutech.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
