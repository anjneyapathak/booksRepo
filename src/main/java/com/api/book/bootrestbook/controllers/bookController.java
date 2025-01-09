package com.api.book.bootrestbook.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.api.book.bootrestbook.entities.book;
import com.api.book.bootrestbook.services.bookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class bookController {

    @Autowired
private bookService bookService;
 
// Get all books handler
  @GetMapping("/books")
    public ResponseEntity<List<book>> getBooks() {
  
    List<book> list= this.bookService.getAllBooks();
    if (list.size()<=0) {
       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    } return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<book> getBook(@PathVariable("id") int id) {
        book b1= bookService.getBookById(id);
        if(b1==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(b1));
    }
    
    @PostMapping("/books")
    public book addBook(@RequestBody book b){

       book b1= this.bookService.addBook(b);
        return b1;

    }
    // delete book
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int id){
      
        this.bookService.deleteBookById(id);

    }
// Update book
    @PutMapping("books/{id}")
    public book updateBook(@RequestBody book b,@PathVariable("id") int id) {
        
        this.bookService.updateBookById(b,id);
        return b;

    }


}
