package com.lambdaschool.shelbysprintbookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "Book", description = "The Book Model")
@Entity
@Table(name = "book")
public class Book extends Auditable {

    // Fields, state of the class, attributes

    @ApiModelProperty(name = "bookid", value = "Primary key for the book", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @ApiModelProperty(name = "booktitle", value = "Book Title", required = true, example = "Astrophysics for People in a Hurry")
    private String booktitle;

    @ApiModelProperty(name = "ISBN", value = "The ISBN number of the book", example = "9780393609394")
    private String ISBN;

    @ApiModelProperty(name = "copy", value = "The year the book was published (copyright date)", example = "2017")
    private int copy;

    @ManyToMany
    @JsonIgnoreProperties(value = "books")
    @JoinTable(name = "author_book", joinColumns = {@JoinColumn(name = "bookid")}, inverseJoinColumns = {@JoinColumn(name = "authorid")})
    List<Author> authors = new ArrayList<>();

    // constructors
    public Book() {
    }

    public Book(String booktitle, String ISBN, int copy) {
        this.booktitle = booktitle;
        this.ISBN = ISBN;
        this.copy = copy;
    }

    public Book(String booktitle, String ISBN, int copy, List<Author> authors) {
        this.booktitle = booktitle;
        this.ISBN = ISBN;
        this.copy = copy;
        this.authors = authors;
    }

    // Methods, behaviors
    // getters and setters
    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
