package com.dataart.project.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataart.project.repositories.Book;
import com.dataart.project.repositories.BookRepository;
 
import java.util.List;
 
@Service
public class BookService {
 
    @Autowired
    protected BookRepository repository;
 
    public List<Book> getBooks() {
        return repository.getBooks();
    }
 
    public void createBook(Book book) {
        repository.createBook(book);
    }
}