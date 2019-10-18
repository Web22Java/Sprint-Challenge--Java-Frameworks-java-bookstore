package com.lambdaschool.shelbysprintbookstore.repository;

import com.lambdaschool.shelbysprintbookstore.models.Quote;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepository extends CrudRepository<Quote, Long>
{

}
