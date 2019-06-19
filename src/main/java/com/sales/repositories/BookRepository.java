//Author Raja Naseer Ahmed Khan G00351263, Data Centric 2019 Project //
//These are the JPA repositoies to manage actual database calls and queires - Book Repository

package com.sales.repositories;

import com.sales.models.Book;
import com.sales.models.MaxID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findBookByTitleAndAuthor(String title, String author);

    @Query(value = "Select MAX(bid) as id FROM books", nativeQuery = true)
    List<MaxID> getMaxId();
}
