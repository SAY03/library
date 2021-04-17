package com.company;

import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;
import javax.xml.bind.*;
import javax.xml.parsers.ParserConfigurationException;

public class Main {

    public static Books books;
    public static void main(String[] args) throws JAXBException, ParserConfigurationException, SAXException, IOException {

        try {
            File file = new File("voc.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            books = (Books) unmarshaller.unmarshal(file);
        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }
        Window win = new Window();
        win.pack();
        win.setSize(433,333);
        win.setVisible(true);
        System.exit(0);
    }
}
