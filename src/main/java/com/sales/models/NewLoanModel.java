//Author Raja Naseer Ahmed Khan G00351263, Data Centric 2019 Project //


package com.sales.models;

public class NewLoanModel {

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    private Long custId;
    private Long bookId;
}
