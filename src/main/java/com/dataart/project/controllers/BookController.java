package com.dataart.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dataart.project.repositories.Book;
import com.dataart.project.services.BookService;
 
import java.util.List;
 
@Controller
public class BookController {
 
    @Autowired
    protected BookService service;
 
    @RequestMapping(value = {"/*", "/books"})
    public String getBooks(Model model) {
        List<Book> books = service.getBooks();
        model.addAttribute("books", books);
        return "books";
    }
 
    @RequestMapping(value = "create-book")
    public String createBookGet(Model model) {
        model.addAttribute("book", new Book());
        return "create-book";
    }
 
    @RequestMapping(value = "create-book", method = RequestMethod.POST)
    public String createBookPost(@ModelAttribute("book") Book book) {
        service.createBook(book);
        return "redirect:books";
    }
}