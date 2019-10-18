package com.lambdaschool.shelbysprintbookstore.repository;

import com.lambdaschool.shelbysprintbookstore.models.Author;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {

}