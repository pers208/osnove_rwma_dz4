package hr.ferit.osnove_rwma_dz3;

import com.google.gson.annotations.SerializedName;

public class Address {
    private String street;
    private String suite;
    private String city;
    @SerializedName("zipcode")
    private String zipCode;

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return  street +'\n'+ suite + '\n'+city+'\n'+ zipCode;
    }
}
