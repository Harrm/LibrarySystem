package com.lsd.library;

import sun.font.TrueTypeFont;

import java.util.ArrayList;
import java.util.Scanner;

public class TestCase3 {

    public static void main(String[] args) {


        Patron facultyMember = new Patron("Roberto", "Innopolis 72", "+7919" );
        Patron student = new Patron("Godfred", "Innopolis 44", "+7920");
        Librarian librarian = new Librarian("Ala", "Innopolis 23", "+7921");
        Book book = new Book(new ArrayList<String>() {{ add("AB"); add("BC");}}, "Mc-Graw Hill",
                "Java The Complete Complete Reference",
                2017, "10th Edition", 8, 1500);

        Library library = Library.getInstance();
        Scanner sc = new Scanner(System.in);

        student.setAsStudent();
        System.out.println(facultyMember.getCardNumber());

        Main.checkOutBook();











    }

    //method to check out the documents
    static void checkOutBook() {
        System.out.println("Welcome to the book checkout system. " +
                "Please enter the ID of the person who wants to check out a book for: ");
        int cardNumber = sc.nextInt();
        Patron p = null;
        for(Users user: library.getUsers()) {
            if (user.getCardNumber() == cardNumber) {
                p = (Patron) user;
                System.out.println(p.name);
                break;

            }

        }

        //here you select the books based on the number that is assigned to the book
        System.out.println("Enter the number of the book you want as displayed: ");
        System.out.println();
        int i = 1;
        for(Document doc: library.getDocuments()) {
            System.out.println(i + ": " + doc.getTitle());
            i = i + 1;

        }
        cardNumber = sc.nextInt();
        Document temp = library.getDocuments().get(cardNumber - 1);
        System.out.println(temp.getTitle());
        System.out.println(temp.getEdition());
        System.out.println(temp.getNumberOfAvailableCopies());
        System.out.println(temp.getPublicationYear());
        for(String author: temp.getAuthors()) {
            System.out.print(author + ", ");
        }

        System.out.println("\nAre you sure that you want to borrow this book in the name of " + p.getName() + "? (Y/N)");

        char c = sc.next(".").charAt(0);
        if(c == 'Y' || c == 'y') {
            library.borrow(temp, p);
        }



    }





}
