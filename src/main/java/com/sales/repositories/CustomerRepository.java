//Author Raja Naseer Ahmed Khan G00351263, Data Centric 2019 Project //
//These are the JPA repositoies to manage actual database calls and queires - Customer Repository

package com.sales.repositories;

import com.sales.models.Customer;
import com.sales.models.MaxID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    public List<Customer> findByCName(String cName);

    @Query(value = "Select MAX(cid) as id FROM customers", nativeQuery = true)
    List<MaxID> getMaxId();
}
