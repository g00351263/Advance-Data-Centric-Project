//Author Raja Naseer Ahmed Khan G00351263, Data Centric 2019 Project //


package com.sales.models;

import java.util.List;

public class CustomerView {

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Long getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(Long loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public List<LoanView> getLoansView() {
        return loansView;
    }

    public void setLoansView(List<LoanView> loansView) {
        this.loansView = loansView;
    }

    private long custId;
    private String custName;
    private Long loanPeriod;
    private List<LoanView> loansView;
}
