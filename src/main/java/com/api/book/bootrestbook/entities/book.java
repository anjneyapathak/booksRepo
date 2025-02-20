package com.api.book.bootrestbook.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Book_Id")
    private int id;
    private String title;
    private Author author;
    
    
    
    @Override
    public String toString() {
        return "book [id=" + id + ", title=" + title + ", author=" + author + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public book() {
    }

    public book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

}
