package hr.ferit.osnove_rwma_dz3;

public class User {
    private int id;
    private String name;
    private Address address;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name+ '\n'+ address;
    }
}
