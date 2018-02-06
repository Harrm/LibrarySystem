package com.lsd.library;

import java.util.ArrayList;
import java.util.HashMap;

/* class patron, here we define both subclasses of patron: University staff and students */
public class Patron extends Users{
    Patron(String name, String address, String phoneNumber) { //creation of the constructor of the patron, with the features
        super(name, address, phoneNumber);                    // name, address and phoneNumber, that identify them
        this.isStudent = false;
    }

    // With this method, we set if a user will be a student or a faculty member
    void setAsStudent(){
        isStudent = true;
    }



    // With this method, we differentiate whether or not a user will be a student or a faculty member
    boolean isAStudent(){
        return isStudent;
    }

    //This method creates a list - hashmap that will store the list of users with a boolean value showing true for students
    //and false for faculty members
    boolean isStudent;
    HashMap<Document, Boolean> userItems1 = new HashMap<>();


    //Set-up of the getter for the map of the list of users
    public HashMap<Document, Boolean> getUserItems1() {
        return userItems1;
    }
}
