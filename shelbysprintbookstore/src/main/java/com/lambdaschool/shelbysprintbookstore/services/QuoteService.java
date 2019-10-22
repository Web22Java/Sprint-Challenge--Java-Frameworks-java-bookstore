package com.lambdaschool.shelbysprintbookstore.services;

import com.lambdaschool.shelbysprintbookstore.models.Quote;
import java.util.List;

public interface QuoteService
{
    List<Quote> findAll();

    Quote findQuoteById(long id);

    List<Quote> findByUserName(String username);

    void delete(long id);

    Quote save(Quote quote);
}