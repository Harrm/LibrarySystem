package resources;

public class User {

    User() {        
    }

    public String getName() {
        return name;
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

    public static long generateCardNumber(){
        long first = System.currentTimeMillis();
        return first;
    }

    protected String name;
    protected long cardNumber;
    protected String phoneNumber;
    protected String address;

}
