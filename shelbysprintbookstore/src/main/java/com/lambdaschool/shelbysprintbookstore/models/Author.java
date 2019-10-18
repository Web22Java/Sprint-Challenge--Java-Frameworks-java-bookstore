package com.lambdaschool.shelbysprintbookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "Author", description = "The Author Model")
@Entity
@Table(name = "author")
public class Author {

    // Fields, state of the class, attributes

    @ApiModelProperty(name = "authorid", value = "The primary key for Author", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    @ApiModelProperty(name = "firstname", value = "Author's First Name", required = true, example = "Andrew")
    private String firstname;

    @ApiModelProperty(name = "lastname", value = "Author's Last Name", required = true, example = "Brudnak")
    private String lastname;

    @ManyToMany(mappedBy = "authors")
    @JsonIgnoreProperties("authors")
    private List<Book> books = new ArrayList<>();

    // constructors
    public Author() {
    }

    public Author(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Author(String firstname, String lastname, List<Book> books) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.books = books;
    }

    // Methods, behaviors
    // getters and setters
    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}