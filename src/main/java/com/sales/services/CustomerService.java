
//Customer service is responsible for managing database operations on customer table


package com.sales.services;

import com.sales.models.*;
import com.sales.repositories.CustomerRepository;
import com.sales.repositories.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private CustomerRepository custRepository = null;

    private LoanRepository loanRepository = null;

    public void setRepos(CustomerRepository custRepo, LoanRepository loanRepo) {
        this.custRepository = custRepo;
        this.loanRepository = loanRepo;
    }

    public List<CustomerView> getCustomers() {

        List<CustomerView> customersView = new ArrayList<>();

        if ( custRepository != null && loanRepository != null ) {
            List<LoanView> loansView = loanRepository.getLoans();

            Iterable<Customer> customers = custRepository.findAll();
            //iterate all customers and populate View
            for (Customer cust : customers) {
                CustomerView custView = new CustomerView();
                custView.setCustId(cust.getcId());
                custView.setCustName(cust.getcName());
                custView.setLoanPeriod(cust.getLoanPeriod());

                //filter loans based on current customer in the loop
                custView.setLoansView(loansView.stream().filter(p -> (p.getCId() == cust.getcId())).collect(Collectors.toList()));
                customersView.add(custView);
            }
        }
        return customersView;
    }


    public SaveResult saveCustomer(Customer customer) {

        SaveResult result = new SaveResult();
        result.setSaved(false);
        result.setErrorMsg("");

        if ( custRepository != null && loanRepository != null && customer != null
                && customer.getcName() != null && customer.getLoanPeriod() != null ) {
            if (customer.getcId() > 0) {
                //update case
            } else {
                //add case
                if (customer.getcName().isEmpty()) {
                    result.appendErrorMsg("Please enter customer's name.");
                } else if (customer.getLoanPeriod() < 1) {
                    result.appendErrorMsg("Please enter loan period > 0.");
                } else if (!custRepository.findByCName(customer.getcName()).isEmpty()) {
                    result.appendErrorMsg("This customer already exists.");
                }
            }

            if (result.getErrorMsg().isEmpty()) {
                //generate next id
                List<MaxID> ids = custRepository.getMaxId();
                Long newId = 1L;
                if ( !ids.isEmpty() )
                    newId = ids.get(0).getId() + 1;
                customer.setcId(newId);
                custRepository.save(customer);
                result.setSaved(true);
            }
        } else {
            result.appendErrorMsg("Invalid customer.");
        }
        return result;
    }

    public SaveResult deleteCustomer(Customer customer) {
        SaveResult result = new SaveResult();

        result.setSaved(false);
        result.setErrorMsg("");

        if ( custRepository != null && customer != null ) {
            if (customer.getcId() > 0) {
                //valid customer to be deleted

                //check if the customer is not associated with any loan
                if (loanRepository != null) {
                    if (loanRepository.findByCust_cId(customer.getcId()) == null) {
                        custRepository.delete(customer);
                    } else {
                        result.appendErrorMsg("This customer is associated with active loan. Can't delete.");
                    }
                } else {
                    result.appendErrorMsg("Server error.");
                }
            } else {
                result.appendErrorMsg("Invalid customer ID");
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
