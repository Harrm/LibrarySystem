package resources;

public class PatronBuilder extends UserBuilder{

    @Override
    public Patron build(){
        super.build();
        Patron patron = new Patron();
        return patron;
    }


}
