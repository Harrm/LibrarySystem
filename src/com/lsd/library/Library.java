package com.lsd.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/* This is the class of the library (main of the implementation),
from here the booking and checkout of the documents are implemented
 */
public class Library {
//This is a simple method that will allow us to see the quantity of copies left of a certain document
    int itemsLeft(Document document){
        int number;
        number = document.numberOfAvailableCopies - borrowChecker.get(document);
        return number;
    }
  /* This is the constructor of the class, private as the library doesn't have to be used anywhere else,
  and it contains the 3 main lists implemented for now
   */
    private Library() {
        documents = new ArrayList<>();
        borrowChecker = new HashMap<>();
        users = new ArrayList<>();
    }

    public ArrayList<Users> getUsers() {
        return users;
    }
    //Part of the singleton class implementation, we initialize ''instance'' as a new library
    static {
        instance = new Library();
    }
//getter of the object instance
    public static Library getInstance() {
        return instance;
    }

    /*This is the main method to perform the Booking of a document in the system
     */

    void borrow(Document document, Patron patron) {//the booking will be done with the document's name and the Patron who requests it
        Document file = null; //we create a file to initially say that the document is not present
        for (Document doc: documents) { //with this data we iterate across the list of documents to see if in fact, the library contains the book
            if(doc.getTitle().equals(document.getTitle())) { //if the document is found, then we inform it
                System.out.println("Found");
                file = doc;
                break;
            }
        }
        if (file == null){ // if the document is not present, then we just return from the search
            return;
        }

        // Here, the conditional means that we have the book in our system
        if(borrowChecker.containsKey(file)){
            int value = borrowChecker.get(file); //value is the number of copies of a document that are checked out
            if(value + 1 >= file.numberOfAvailableCopies){ // if all the copies were checked out, then we send a message:
                System.out.println("Books out of stock");
                return;
            } else{
                borrowChecker.put(file, value + 1);// With this, we are registering the number of copies of a document that are lent
            }
        } else {
            borrowChecker.put(file, 1); //here we're talking about the case of the first copy that is checked out
        }

        /* This command does the following: Once that we check out the document, we register the document as checked out by a
        certain patron, and we insert it in the patron's list of checked out documents. And we map the document as ''true'' meaning
        that the document has been checked out.
         */
        patron.getUserItems1().put(file, true);

        /*Here are the drafts for the future implementations of the methods to determine whether or not a book will
        is a bestseller and the time allowed for each borrowing of a document */

        if (file instanceof Book){
            if(((Book) file).isBestSeller() && patron.isAStudent()){
                // checkOutForTwoWeeks();
                System.out.println("Checked out for 2 weeks");

            } else if(!patron.isAStudent()){
                //checkOutForFourWeeks();
                System.out.println("Checked out for 4 weeks");
            } else{
                // checkOutForThreeWeeks();
                System.out.println("Checked out for 3 weeks");
            }
        } else if(file instanceof AVMaterials || file instanceof JournalArticle){
            // checkOutForTwoWeeks();
            System.out.println("Checked out for 2 weeks");
        }
    }
//getter of the documents that are stored in the library
    public ArrayList<Document> getDocuments() {
        return documents;
    }

    /* In this section we create a list ''Document'' to store the different documents. Also,
    borrowChecker is a map that contains the different documents that are lent to a user,
    and they are mapped to Integer, which is the number of copies per document that are lent.
    In the array ''users'', it stores the users of the library (Patrons and Librarians).*/

    private ArrayList<Document> documents;
    private HashMap<Document, Integer> borrowChecker;
    ArrayList<Users> users;
    private static Library instance; // Singleton class, because we should create only one library
}

  

