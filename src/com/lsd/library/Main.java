package com.lsd.library;

import java.util.ArrayList;
import java.util.Scanner;

//This is the main class, where we implement the methods for the booking system
public class Main {
    static Scanner sc;
    static Library library;

    public static void main(String[] args) {
        System.out.println("\t\t Welcome to the Innopolis Library Management System");

        System.out.println("Enter login credentials: ");
        sc = new Scanner(System.in);
        String input;
        while(true) {
            input = sc.nextLine();
            input = input.trim();
            if(input.equalsIgnoreCase("admin")) {
                System.out.println("Login successful");
                break;
            } else {
                System.out.println("wrong credentials. try again");
            }

        }



        library = Library.getInstance();
        initStub();



    //Option variable, to select the different cases of our documents
        int option;

        //crud = create, update, and delete, Docs = documents

        do {
            System.out.println("\t *******Enter your choice*******");
            System.out.println("1.Search \n2.Add, modify or delete document \n3." +
                    "Add, modify or delete user \n4.Check out document. \n5.Return document " +
                    "\n6.Quit");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    //  searchBook();
                    System.out.println("Search to be done later");

                    break;

                case 2:
                    //  crudDocs();
                    System.out.println("To be done later");
                    break;

                case 3:
                    // crudUser();
                    System.out.println("To be done later");
                    break;
                case 4:
                    checkOutBook();
                    break;
                case 5:
                    // returnBook();
                    System.out.println("To be done later");
                    break;
                case 6:
                    System.out.println("Exiting app...");
                    System.exit(0);
                default:
                    System.out.println("Incorrect info entered");
                    break;
            }

        }while(!(option >= 1 && option <= 6));
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


    static void initStub() { //it creates mock data and adds it to the library
        //initialize library


        Patron user1 = new Patron("Godfred Asamoah", "1-209", "+7-937-042-7194");
        user1.setAsStudent();

        Patron user2 = new Patron("Elvis Solomon", "1-219", "+7-937-042-7194");
        user2.setAsStudent();

        Patron user3 = new Patron("Mario Kojo", "1-249", "+7-937-042-7194");
        user3.setAsStudent();

        Patron user4 = new Patron("Nana Kwame", "1-259", "+7-937-042-7194");
        user4.setAsStudent();

        Patron user5 = new Patron("Joseph Osei", "1-269", "+7-937-042-7194");
        user5.setAsStudent();

        Patron user6 = new Patron("Seth Adams", "1-279", "+7-937-042-7194");
        user6.setAsStudent();

        Patron user7 = new Patron("Stark Nuakoh", "3-299", "+7-937-042-7194");
        user7.setAsStudent();

        Patron user8 = new Patron("Eleazar Offei", "4-485", "+7-937-042-7194");
        user8.setAsStudent();

        Patron user9 = new Patron("Lasu Gaspard", "2-245", "+7-937-042-7194");
        user9.setAsStudent();

        ArrayList<String> author1 = new ArrayList<>();
        author1.add("Herbert Shildt");

        ArrayList<String> author2 = new ArrayList<>();
        author2.add("Garry Sussman");
        author2.add("Harold Abelson");
        author2.add("Julie Sussman");

        ArrayList<String> author3 = new ArrayList<>();
        author3.add("Thomas Cormen");
        author3.add("Charles Leiserson");
        author3.add("Ronald Rivest");
        author3.add("Clifford Stein");

        ArrayList<String> author4 = new ArrayList<>();
        author4.add("Alfred Aho");
        author4.add("Monica Lam");
        author4.add("Ravi Seth");
        author4.add("Jeffrey Ullman");

        ArrayList<String> author5 = new ArrayList<>();
        author5.add("Matthias Felleisen");
        author5.add(" Robert Bruce Findler");
        author5.add("Matthew Flatt");
        author5.add("Shriram Krishnamurthi");

        ArrayList<String> author6 = new ArrayList<>();
        author6.add("Alan Turing");

        ArrayList<String> author7 = new ArrayList<>();
        author7.add("Alonzo Church");


        Book book1 = new Book(author1, "Mc-Graw Hill",
                "Java The Complete Complete Reference",
                2017, "10th Edition", 10, 2000);

        Book book2 = new Book(author2, "MIT Press",
                "Structure and Interpretation of Computer Programs",
                1998, "2nd Edition", 7, 2500);

        Book book3 = new Book(author3, "MIT Press",
                "Introduction to Algorithms",
                2009, "2nd Edition", 10, 2000);

        Book book4 = new Book(author4, "Mc-Graw Hill",
                "Compilers: Principles, Techniques and Tools",
                1970, "1st Edition", 5, 2000);


        Book book5 = new Book(author5, "The MIT Press",
                "How to Design Programs: An Introduction to Programming and Computing",
                2017, "1st Edition", 10, 2000);


        JournalArticle journal6 = new JournalArticle(author6, "Nature",
                "On Computable Numbers with an Application to the Entscheidungsproblem", 1930,
                "1st Edition", 2, "Nature", "Nature", 100);

        JournalArticle journal7 = new JournalArticle(author7, "Nature",
                "Alternatives to Zermelo's Assumption", 1940,
                "1st Edition", 6, "Nature", "Nature", 1000);

        library.getUsers().add(user1);
        library.getUsers().add(user2);
        library.getUsers().add(user3);
        library.getUsers().add(user4);
        library.getUsers().add(user5);
        library.getUsers().add(user6);
        library.getUsers().add(user7);
        library.getUsers().add(user8);
        library.getUsers().add(user9);

        library.getDocuments().add(book1);
        library.getDocuments().add(book2);
        library.getDocuments().add(book3);
        library.getDocuments().add(book4);
        library.getDocuments().add(book5);
        library.getDocuments().add(journal6);
        library.getDocuments().add(journal7);



        System.out.println(user1.getCardNumber());


    }
}