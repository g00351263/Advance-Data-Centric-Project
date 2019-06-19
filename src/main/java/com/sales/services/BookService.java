//Author Raja Naseer Ahmed Khan G00351263, Data Centric 2019 Project //

// Book service is responsible for managing database operations on book table

package com.sales.services;

import com.sales.models.Book;
import com.sales.models.MaxID;
import com.sales.models.SaveResult;
import com.sales.repositories.BookRepository;
import com.sales.repositories.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository = null;

    private LoanRepository loanRepository = null;

    public void setRepositories(BookRepository bookRepo, LoanRepository loanRepo) {
        this.bookRepository = bookRepo;
        this.loanRepository = loanRepo;
    }

    public Iterable<Book> getBooks() {

        Iterable<Book> books = null;

        if ( bookRepository != null )
            books = bookRepository.findAll();

        return books;
    }

    public SaveResult saveBook(Book book) {

        SaveResult result = new SaveResult();
        result.setSaved(false);
        result.setErrorMsg("");

        if ( bookRepository != null ) {
            if (book.getBid() > 0) {
                //update case
            } else {
                //add case
            	
            	
                if (book.getTitle() == null || book.getTitle().isEmpty() && book.getAuthor() == null || book.getAuthor().isEmpty()) {
                    result.appendErrorMsg("Please enter Book title and author.");
            	
                }else if (book.getTitle() == null || book.getTitle().isEmpty()) {
                    result.appendErrorMsg("Please enter Book title.");
                    
                } else if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
                    result.appendErrorMsg("Please enter Book author.");
                
                } else if (!bookRepository.findBookByTitleAndAuthor(book.getTitle(), book.getAuthor()).isEmpty()) {
                    result.appendErrorMsg("This book already exists.");
                }
            }

            if (result.getErrorMsg().isEmpty()) {
                //generate next id
                Long newId = 1L;
                List<MaxID> ids = bookRepository.getMaxId();
                if ( !ids.isEmpty() )
                    newId = ids.get(0).getId() + 1;
                book.setBid(newId);
                bookRepository.save(book);
                result.setSaved(true);
            }
        }
        return result;
    }

    public SaveResult deleteBook(Book book) {
        SaveResult result = new SaveResult();

        result.setSaved(false);
        result.setErrorMsg("");

        if ( bookRepository != null ) {
            if (book != null && book.getBid() > 0) {
                //valid book to be deleted

                //check if the book is not associated with any loan
                if (loanRepository != null) {
                    if (loanRepository.findByBook_Bid(book.getBid()) == null) {
                        bookRepository.delete(book);
                    } else {
                        result.appendErrorMsg("This Book is associated with active loan. Can't delete.");
                    }
                } else {
                    result.appendErrorMsg("Server error.");
                }
            } else {
                result.appendErrorMsg("Invalid book ID");
            }
        } else {
            result.appendErrorMsg("Server error.");
        }

        if ( result.getErrorMsg().length() == 0 ) {
            result.setSaved(true);
        }

        return result;
    }
}
