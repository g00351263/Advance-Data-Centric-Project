//Author Raja Naseer Ahmed Khan G00351263, Data Centric 2019 Project //
//This is to manage loans operations such as view, add and delete


package com.sales.controllers;


import com.sales.models.Loan;
import com.sales.models.LoanView;
import com.sales.models.NewLoanModel;
import com.sales.models.SaveResult;
import com.sales.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LoanController {

    @Autowired
    private LoanService loanService;

    private String errors = "";

    @GetMapping("/showLoans")
    public String showLoans(Model model) {

        List<LoanView> loans = loanService.getLoans();

        model.addAttribute("loans", loans);
        model.addAttribute("error", errors);
        errors = "";
        return "showloans";
    }

    @GetMapping("/newLoan")
    public String newLoan(Model model) {

        NewLoanModel loan = new NewLoanModel();

        model.addAttribute("loan", loan);
        model.addAttribute("error", errors);
        errors = "";
        return "newloan";
    }

    @PostMapping("/saveLoan")
    public String saveLoan(Model model, @ModelAttribute("loan") NewLoanModel loan) {
        errors = "";
        SaveResult result = loanService.saveLoan(loan);

        if ( result.getSaved() == false ) {
            errors = result.getErrorMsg();
            return "redirect:newLoan";
        } else {
            return "redirect:showLoans";
        }
    }

    @GetMapping("/deleteLoan")
    public String deleteLoan(Model model) {

        Loan loan = new Loan();

        model.addAttribute("loan", loan);
        model.addAttribute("error", errors);
        errors = "";
        return "deleteloan";
    }

    @PostMapping("/deleteLoanCommit")
    public String deleteLoanCommit(Model model, @ModelAttribute("loan") Loan loan) {

        SaveResult result = loanService.deleteLoan(loan);
        errors = "";

        if ( result.getSaved() == false ) {
            errors = result.getErrorMsg();
            return "redirect:deleteLoan";
        } else {
            return "redirect:showLoans";
        }
    }
}

