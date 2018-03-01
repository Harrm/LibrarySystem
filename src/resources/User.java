package resources;

public class User {

    User() {        
    }

    public String getUserName() {
        return userName;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserSubtype() {
        return userSubtype;
    }

    public void setUserSubtype(String userSubtype) {
        this.userSubtype = userSubtype;
    }

    protected String userName;
    protected long cardNumber;
    protected String phoneNumber;
    protected String address;

    //I add the subtypes here:

    protected String userType; //here we define if the user is a librarian or patron
    protected String userSubtype; //it's whether the user is a student, a faculty or a librarian(librarian is a subclass of itself)


}
