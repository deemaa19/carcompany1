package org.example;

public class apointment {
    String custName;
    int numOfGuests;

    apointment(int numOfGuests, String custName)
    {
        this.custName = custName;
        this.numOfGuests = numOfGuests;
    }

    public String toString()
    {
        return String.format("%d persons at name: %s", numOfGuests, custName);
    }
}
