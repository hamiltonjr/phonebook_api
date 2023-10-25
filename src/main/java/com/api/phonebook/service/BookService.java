package com.api.phonebook.service;
import com.api.phonebook.model.BookModel;
import com.api.phonebook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository ibr;

    public Iterable<BookModel> read() {
        return ibr.findAll();
    }

}
