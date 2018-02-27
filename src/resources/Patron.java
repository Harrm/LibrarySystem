package resources;

public class Patron extends User {

    Patron(){
        super();

    }



    public static void main(String[] args) {

        BookBuilder bookBuilder = new BookBuilder();
        bookBuilder.setEdition("rsgfsgs");

        Book book = bookBuilder.build();

        String string;

        string = book.getEdition();
        System.out.println(string);
    }
}
