package com.api.phonebook.controller;
import com.api.phonebook.model.BookModel;
import com.api.phonebook.model.ResponseModel;
import com.api.phonebook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class BookController {
    @Autowired
    private BookService bs;

    @GetMapping("/")
    public String index() {
        return "API works!";
    }

    @GetMapping("/read")
    public Iterable<BookModel> read() {
        return bs.read();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody BookModel bm) {
        return bs.create(bm);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody BookModel bm) {
        return bs.update(bm);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseModel> delete(@PathVariable Long id) {
        return bs.delete(id);
    }

}
