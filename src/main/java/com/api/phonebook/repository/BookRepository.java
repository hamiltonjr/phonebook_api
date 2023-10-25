package com.api.phonebook.repository;
import com.api.phonebook.model.BookModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookModel, Long> {}
