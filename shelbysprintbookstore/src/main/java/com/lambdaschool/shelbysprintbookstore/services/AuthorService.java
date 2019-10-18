package com.lambdaschool.shelbysprintbookstore.services;
import com.lambdaschool.shelbysprintbookstore.models.Author;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService {

    List<Author> findAll(Pageable pageable);
    void save(Author author);
}