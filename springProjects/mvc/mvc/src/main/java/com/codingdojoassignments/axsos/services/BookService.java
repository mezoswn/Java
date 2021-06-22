package com.codingdojoassignments.axsos.services;


import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.codingdojoassignments.axsos.models.Book;
import com.codingdojoassignments.axsos.repositories.BookRepository;
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
            public Book updateBook(Long id , String title, String desc, String lang, int pages){
                Optional<Book> optionalBook = bookRepository.findById(id);
                if(optionalBook.isPresent()) {
                    Book book = optionalBook.get();
                    book.setTitle(title);
                    book.setDescription(desc);
                    book.setLanguage(lang);
                    book.setNumberOfPages(pages);
                    bookRepository.save(book);
                    return book;

                }
                else{
                    return null;
                }
            }
            public void deleteBook(Long id){
                Optional<Book> optionalBook = bookRepository.findById(id);
                if(optionalBook.isPresent()) {
                    bookRepository.deleteById(id);
                }
            }
}

            


