//Author Raja Naseer Ahmed Khan G00351263, Data Centric 2019 Project //
//This is to manage the operations on books such as view, add and delete

package com.sales.controllers;


import com.sales.models.Book;
import com.sales.models.SaveResult;
import com.sales.repositories.BookRepository;
import com.sales.repositories.LoanRepository;
import com.sales.services.BookService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private LoanRepository loanRepo;

    private String errors = "";

    @Autowired
    private BookService bookService;

    @GetMapping("/showBooks")
    public String showBooks(Model model) {

        this.bookService.setRepositories(bookRepo, loanRepo);

        Iterable<Book> books = bookService.getBooks();

        //set attributes for the page
        model.addAttribute("error", errors);
        model.addAttribute("books", books);

        //remove error once set for the page
        errors = "";
        return "showbooks";
    }

    @GetMapping("/addBook")
    public String addBook(Model model) {

        this.bookService.setRepositories(bookRepo, loanRepo);

        Book book =  new Book();
        model.addAttribute("book", book);
        model.addAttribute("error", errors);
        errors = "";
        return "addbook";
    }

    @RequestMapping(value = "/saveBook", method=RequestMethod.POST)
    public String saveBook(Model model, @ModelAttribute("book") @Valid Book book ,BindingResult result) {

        //errors = "";
        //SaveResult result = bookService.saveBook(book);
    	bookService.saveBook(book);
       // if ( result.getSaved() == false ) {
    	
            //if not able to save, return to add book with error
    	if(result.hasErrors()) {
    		return "addbook";    
    	
        } else {
            return "redirect:showBooks";
        }
    }

    @PostMapping("/deleteBook")
    public String deleteBook(Model model, @ModelAttribute("book") Book book) {

        errors = "";
        //try delete the book
        SaveResult result = bookService.deleteBook(book);
        errors = result.getErrorMsg();
        return "redirect:showBooks";
    }
}


