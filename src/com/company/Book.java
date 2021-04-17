package com.company;

import javax.xml.bind.annotation.*;

@XmlType( propOrder = { "name", "author" } )
@XmlRootElement( name = "book")
public class Book {

    String name;
    String author;
    private boolean isMatch;

    public Book(){
    }
    @XmlElement( name = "name" )
    public void setName( String name )
    {
        this.name = name;
    }
    @XmlElement( name = "author" )
    public void setAuthor( String author )
    {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public boolean getIsMatch() { return isMatch; }

    public void isMatch(boolean isMatch) { this.isMatch = isMatch; }
}
