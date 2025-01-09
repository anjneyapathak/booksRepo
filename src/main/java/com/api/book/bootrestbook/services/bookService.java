package com.api.book.bootrestbook.services;

import java.util.*;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.book;


@Component
public class bookService {

    @Autowired
    private BookRepository bookRepository;

    // private static List<book> list=new ArrayList<>();
    // static {
    //     list.add(new book(12,"java books","xyz"));
    //     list.add(new book(22,"python books","qwertyu"));
    //     list.add(new book(32,"kotlin books","asdf"));
    // }

    //get all books
    public List<book> getAllBooks() {
       
       List<book> list=(List<book>) this.bookRepository.findAll();
       return list;
    }

    // get single book by id
    public book getBookById(int id) {
          book book=null;
          try{
            //book=  list.stream().filter(e->e.getId()==id).findFirst().get();
           book= this.bookRepository.findById(id);
          }
          catch(Exception e){
         e.printStackTrace();

          }
        
        return book;

    }

    // adding the book to the list
    public book addBook(book b) {
        book result=bookRepository.save(b);
    //list.add(b);
    return result;
    }

    // delete the book
    public void deleteBookById(int id) {
      
     //  list=list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
          bookRepository.deleteById(id);
   
    }
    // update the book   
    public void updateBookById(book b, int id) {
        b.setId(id);
        bookRepository.save(b);

    //    list= list.stream().map(c->{
    //          if(c.getId()==id){
    //             c.setTitle(b.getTitle());
    //             c.setAuthor(b.getAuthor());
    //          }
    //         return c;
    //     }).collect(Collectors.toList());

    }
}
