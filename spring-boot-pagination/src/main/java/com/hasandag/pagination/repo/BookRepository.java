package com.hasandag.pagination.repo;

import com.hasandag.pagination.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
