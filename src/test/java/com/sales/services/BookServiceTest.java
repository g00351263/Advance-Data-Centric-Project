package com.sales.services;

import com.sales.FinalProjV1Application;
import com.sales.models.Book;
import com.sales.models.SaveResult;
import com.sales.repositories.BookRepository;
import com.sales.repositories.LoanRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FinalProjV1Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BookServiceTest {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private LoanRepository loanRepo;

    @Autowired
    private BookService bookService;

    @Test
    public void getBooksTest() {
        bookService.setRepositories(bookRepo, loanRepo);

        Iterable<Book> books = bookService.getBooks();
    }

    @Test
    public void saveBookTest() {
        Book book = new Book();

        book.setBid(0L);
        book.setTitle("Test");
        book.setAuthor("Test");

        bookService.setRepositories(bookRepo, loanRepo);

        SaveResult result = bookService.saveBook(book);

        Assertions.assertThat( result.getSaved() );
    }

    @Test
    public void deleteBookTest() {

        Long id = bookRepo.getMaxId().get(0).getId();

        bookService.setRepositories(bookRepo, loanRepo);

        Book book = new Book();
        book.setBid(id);
        SaveResult result = bookService.deleteBook(book);

        Assertions.assertThat( result.getSaved() );
    }

}
