package com.lambdaschool.shelbysprintbookstore.repository;

import com.lambdaschool.shelbysprintbookstore.models.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

}