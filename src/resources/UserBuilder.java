package resources;

public class UserBuilder{

    public User build(){

        User user = new User();
        user.name = name;
        user.cardNumber = cardNumber;
        user.phoneNumber = phoneNumber;
        user.address = address;

        return user;
    }

    public void setName(String name) {
        this.name = name;
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

    private String name;
    private long cardNumber;
    private String phoneNumber;
    private String address;
}
