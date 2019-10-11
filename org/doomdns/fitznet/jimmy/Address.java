package org.doomdns.fitznet.jimmy;

public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;

    /**
     * Create an address with all empty fields.
     *
     */
    public Address() {
        streetAddress = "";
        city = "";
        state = "";
        zipCode = "";
    }

    /**
     * Create an address.
     */
    public Address(String streetAddr, String city, String state, String zip) {
        streetAddress = streetAddr;
        this.city = city;
        this.state = state;
        zipCode = zip;
    }

    /**
     * @return the streetAddress
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * @param streetAddress the streetAddress to set
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * True if the names and addresses are equal
     */
    public boolean equals(Object right) {
        Address r = (Address) right;
        return streetAddress.equals(r.streetAddress) && city.equals(r.city)
                && state.equals(r.state) && zipCode.equals(r.zipCode);
    }

    public int hashCode() {
        return streetAddress.hashCode() + 5 * city.hashCode() + 7 * state.hashCode()
                + 11 * zipCode.hashCode();
    }

    public String toString() {
        return streetAddress + ": " + city + ", " + state + " " + zipCode;
    }

    public Object clone() {
        return new Address(streetAddress, city, state, zipCode);
    }
}