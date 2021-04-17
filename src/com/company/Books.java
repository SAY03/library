package com.company;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement( name = "books" )
public class Books
{
    List<Book> books;

    public List<Book> getBooks()
    {
        return books;
    }

    @XmlElement( name = "book" )
    public void setBooks( List<Book> books )
    {
        this.books = books;
    }

    public void add( Book book ) {
        if (this.books == null) {
            this.books = new ArrayList<Book>();
        }
        this.books.add(book);
    }
}