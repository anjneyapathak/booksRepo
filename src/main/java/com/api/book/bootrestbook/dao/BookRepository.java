package com.api.book.bootrestbook.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.book.bootrestbook.entities.book;

public interface BookRepository extends CrudRepository<book,Integer> {

    public book findById(int id);
    
} 
