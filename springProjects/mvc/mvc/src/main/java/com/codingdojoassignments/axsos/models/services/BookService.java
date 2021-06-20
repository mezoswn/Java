package com.codingdojoassignments.axsos.models.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojoassignments.axsos.models.Book;
import com.codingdojoassignments.axsos.models.repositories.BookRepository;
@Service
public class BookService {
	// adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
        
    }
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	// TODO Auto-generated method stub
    	Book book = this.findBook(id);
    	book.setId(id);
    	book.setDescription(desc);
    	book.setLanguage(lang);
    	book.setNumberOfPages(numOfPages);
    	book.setTitle(title);
    	return bookRepository.save(book);
    }
    public void deleteBook(Long id) {
    	// TODO Auto-generated method stub
    	this.deleteBook(id);
    	
    }
        
    }


