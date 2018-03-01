package resources;

import java.time.LocalDate;

public class CheckoutRecord {

    CheckoutRecord(){



    }

    public User patron; //patrons are the ones who check out documents
    public LocalDate overdue;
    public Book item;


}
