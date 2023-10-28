package com.api.phonebook.service;
import com.api.phonebook.model.BookModel;
import com.api.phonebook.model.ResponseModel;
import com.api.phonebook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository br;

    @Autowired
    private ResponseModel rm;

    public Iterable<BookModel> read() {
        return br.findAll();
    }

    public ResponseEntity<?> create(BookModel pm) {

        // validation
        if (pm.getName().equals("")) {
            rm.setMessage("Name is mandatory");
            return new ResponseEntity<>(rm, HttpStatus.BAD_REQUEST);
        } else if (pm.getEmail().equals("")) {
            rm.setMessage("Email is mandatory");
            return new ResponseEntity<>(rm, HttpStatus.BAD_REQUEST);
        } else if (pm.getPhone().equals("")) {
            rm.setMessage("Phone is mandatory");
            return new ResponseEntity<>(rm, HttpStatus.BAD_REQUEST);
        }

        rm.setMessage("Contact was created");
        return new ResponseEntity<>(br.save(pm), HttpStatus.CREATED);

    }

    public ResponseEntity<?> update(BookModel pm) {

        // validation
        if (pm.getName().equals("")) {
            rm.setMessage("Name is mandatory");
            return new ResponseEntity<>(rm, HttpStatus.BAD_REQUEST);
        } else if (pm.getEmail().equals("")) {
            rm.setMessage("Email is mandatory");
            return new ResponseEntity<>(rm, HttpStatus.BAD_REQUEST);
        } else if (pm.getPhone().equals("")) {
            rm.setMessage("Phone is mandatory");
            return new ResponseEntity<>(rm, HttpStatus.BAD_REQUEST);
        }

        rm.setMessage("Contact was updated");
        return new ResponseEntity<>(br.save(pm), HttpStatus.OK);

    }


    public ResponseEntity<ResponseModel> delete(Long id) {
        br.deleteById(id);
        rm.setMessage("Contact was removed!");
        return new ResponseEntity<>(rm, HttpStatus.OK);
    }

}
