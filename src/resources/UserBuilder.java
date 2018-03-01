package resources;

public class UserBuilder{

    public User build(){

        User user = new User();
        user.userName = userName;
        user.cardNumber = cardNumber;
        user.phoneNumber = phoneNumber;
        user.address = address;

        return user;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /* Here I add setters for the users:

     */

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setUserSubtype(String userSubtype) {
        this.userSubtype = userSubtype;
    }

    private String userName;
    private long cardNumber;
    private String phoneNumber;
    private String address;

    //new addition here:

    protected String userType;
    protected String userSubtype;
}
