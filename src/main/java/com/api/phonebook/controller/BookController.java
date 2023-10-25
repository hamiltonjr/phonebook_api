package com.api.phonebook.controller;
import com.api.phonebook.model.BookModel;
import com.api.phonebook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private BookService ibs;

    @GetMapping("/")
    public String index() {
        return "API works!";
    }

    @GetMapping("/read")
    public Iterable<BookModel> read() {
        return ibs.read();
    }

}
