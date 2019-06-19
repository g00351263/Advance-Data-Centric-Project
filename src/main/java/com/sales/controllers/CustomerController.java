//Author Raja Naseer Ahmed Khan G00351263, Data Centric 2019 Project //
//This is to  manage the operations on Customers such as view, add and delete

package com.sales.controllers;


import com.sales.models.Customer;
import com.sales.models.CustomerView;
import com.sales.models.SaveResult;
import com.sales.repositories.CustomerRepository;
import com.sales.repositories.LoanRepository;
import com.sales.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import javax.validation.Valid;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository custRepo;

    private String errors = "";

    @Autowired
    private LoanRepository loanRepo;

    @Autowired
    private CustomerService custService;

    @GetMapping("/showCustomers")
    public String showCustomers(Model model) {

        custService.setRepos(custRepo, loanRepo);
        List<CustomerView> customers = custService.getCustomers();

        model.addAttribute("customers", customers);
        model.addAttribute("error", errors);
        errors = "";
        return "showcustomers";
    }

    @GetMapping("/addCustomer")
    public String addCustomer(Model model) {
        Customer customer =  new Customer();
        model.addAttribute("customer", customer);
        model.addAttribute("error", errors);
        errors = "";
        return "addcustomer";
    }

    @RequestMapping(value = "/saveCustomer", method=RequestMethod.POST)
    public String saveCustomer(Model model, @ModelAttribute("customer") @Valid Customer customer, BindingResult result) {

        custService.setRepos(custRepo, loanRepo);
        
        custService.saveCustomer(customer);

        if ( result.hasErrors() ) {
            
        	return "addcustomer";
        } else {
            return "redirect:showCustomers";
        }
    }


    @PostMapping("/deleteCustomer")
    public String deleteCustomer(Model model, @ModelAttribute("Customer") Customer customer) {

        errors = "";
        //try delete the book
        SaveResult result = custService.deleteCustomer(customer);
        errors = result.getErrorMsg();
        return "redirect:showCustomers";
    }
}

