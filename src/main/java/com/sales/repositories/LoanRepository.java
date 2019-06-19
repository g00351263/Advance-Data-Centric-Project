//Author Raja Naseer Ahmed Khan G00351263, Data Centric 2019 Project //
//These are the JPA repositories to manage actual database calls and queries - Loan Repository

package com.sales.repositories;

import com.sales.models.Loan;
import com.sales.models.LoanView;
import com.sales.models.MaxID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoanRepository extends CrudRepository<Loan, Long> {

    @Query(value = "Select l.lid, c.cid, b.bid, c.cname, b.title, b.author, l.duedate From loans l inner join customers c on l.cid = c.cid inner join books b on l.bid = b.bid", nativeQuery = true)
    public List<LoanView> getLoans();

    @Query(value = "Select MAX(lid) as id FROM loans", nativeQuery = true)
    List<MaxID> getMaxId();

    Loan findByBook_Bid(Long bid);

    Loan findByCust_cId(Long cId);
}