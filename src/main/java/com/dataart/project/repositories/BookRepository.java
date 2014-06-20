package com.dataart.project.repositories;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import java.util.List;
 
@Repository
@Transactional
public class BookRepository {
 
    @Autowired
    protected SessionFactory sessionFactory;
 
    @SuppressWarnings("unchecked")
    public List<Book> getBooks() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Book b")
                .list();
    }
 
    public void createBook(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }
}