package com.lambdaschool.shelbysprintbookstore.services;

import com.lambdaschool.shelbysprintbookstore.models.Author;
import com.lambdaschool.shelbysprintbookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService
{
    @Autowired
    private AuthorRepository repo;


    @Override
    public List<Author> findAll(Pageable pageable) {
        List<Author> authorList = new ArrayList<>();
        repo.findAll().iterator().forEachRemaining(authorList::add);
        return authorList;
    }

    @Override
    public void save(Author author) {
        repo.save(author);
    }
}