//Loan service is responsible for managing database operations on loan table


package com.sales.services;

import com.sales.models.*;
import com.sales.repositories.BookRepository;
import com.sales.repositories.CustomerRepository;
import com.sales.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CustomerRepository custRepository;

    public List<LoanView> getLoans() {

        List<LoanView> loans = loanRepository.getLoans();

        return loans;
    }

    public SaveResult saveLoan(NewLoanModel newLoan) {

        SaveResult result = new SaveResult();
        result.setSaved(false);
        result.setErrorMsg("");

        if ( newLoan != null && newLoan.getCustId() != null && newLoan.getBookId() != null ) {
            Optional<Customer> customer = custRepository.findById(newLoan.getCustId());
            Optional<Book> book = bookRepository.findById(newLoan.getBookId());

            //valid customer
            if (!customer.isPresent())
                result.appendErrorMsg("Invalid customer ID");

            //valid book
            if (!book.isPresent())
                result.appendErrorMsg("Invalid book ID");

            //check if book is already assigned or not
            if (loanRepository.findByBook_Bid(newLoan.getBookId()) != null)
                result.appendErrorMsg("This loan ID is already booked");

            if (result.getErrorMsg().isEmpty()) {
                //populate loan
                Loan loan = new Loan();
                loan.setLid(loanRepository.getMaxId().get(0).getId() + 1);
                loan.setBook(book.get());
                loan.setCust(customer.get());
                LocalDate dt = LocalDate.now();
                dt = dt.plusDays(customer.get().getLoanPeriod());
                //format date
                loan.setDueDate(String.valueOf(dt.getYear()) + "-" + String.valueOf(dt.getMonthValue()) + "-" + String.valueOf(dt.getDayOfMonth()));
                loanRepository.save(loan);
                result.setSaved(true);
            }
        } else {
            result.appendErrorMsg("Invalid Book ID and/or Customer ID");
        }

        return result;
    }

    public SaveResult deleteLoan(Loan loan) {

        SaveResult result = new SaveResult();
        result.setSaved(false);
        result.setErrorMsg("");

        if ( loan != null && loan.getLid() > 0 ) {
            //valid id
            loanRepository.delete(loan);

        } else {
            result.appendErrorMsg("Invalid loan.");
        }

        if ( result.getErrorMsg().isEmpty() ) {
            result.setSaved(true);
        }

        return result;
    }
}
