package com.sales.services;

import com.sales.models.Customer;
import com.sales.models.CustomerView;
import com.sales.models.SaveResult;
import com.sales.repositories.CustomerRepository;
import com.sales.repositories.LoanRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository custRepo;

    @Mock
    private LoanRepository loanRepo;

    @InjectMocks
    private CustomerService custService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        custService.setRepos(custRepo, loanRepo);
    }

    @Test
    public void saveCustomer() {

        SaveResult expectedResult = new SaveResult();
        expectedResult.setErrorMsg("");
        expectedResult.setSaved(true);

        Customer cust = new Customer();
        cust.setcId(0L);
        cust.setcName("Test");
        cust.setLoanPeriod(100L);
        SaveResult resultService = custService.saveCustomer(cust);
        Assertions.assertThat(expectedResult.getErrorMsg().equalsIgnoreCase(resultService.getErrorMsg())).isTrue();
        Assertions.assertThat(resultService.getSaved()).isTrue();
    }


    @Test
    public void getCustomers() {
        List<Customer> custs = new ArrayList<>();
        custs.add( new Customer() );
        custs.get(0).setcId(1L);
        custs.get(0).setcName("test");
        custs.get(0).setLoanPeriod(100L);

        when(custRepo.findAll()).thenReturn(custs);
        List<CustomerView> customers = custService.getCustomers();

        Assertions.assertThat( customers.size() == 1 );
    }

    @Test
    public void deleteCustomer() {
        Customer cust = new Customer();
        cust.setcId(1L);
        cust.setcName("Test");
        cust.setLoanPeriod(10L);

        SaveResult result = custService.deleteCustomer(cust);

        Assertions.assertThat( result.getSaved() );
    }
}
