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
	protected SessionFactory sessionFactoryMySQL; 
	/* change to sessionFactory if using HSQL in memory DB */

	@SuppressWarnings("unchecked")
	public List<Book> getBooks() {
		return sessionFactoryMySQL.getCurrentSession().createQuery("FROM Book b")
				.list();
	}

	public void createBook(Book book) {
		sessionFactoryMySQL.getCurrentSession().save(book);
	}
}