package com.company;

/*

2011 Externalizable for apartments
Implement the Externalizable interface in the Apartment class.

Requirements:
1. The Solution.Apartment class must support the Externalizable interface.
2. The writeExternal method with a single parameter of type ObjectOutput must be implemented in the Solution.Apartment class.
3. The readExternal method with one parameter of type ObjectInput must be implemented in the Solution.Apartment class.
4. In the writeExternal method, a writeObject method with the address parameter must be called on the object received as an object of type ObjectOutput.
5. In the writeExternal method, a writeInt method with the year parameter must be called on the object received as an object of type ObjectOutput.
6. The readExternal method must correctly restore the value of the address field from ObjectInput.
7. The readExternal method must correctly restore the value of the year field from ObjectInput.


 */


import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Solution {
    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(this.address);
            out.writeInt(this.year);
            out.close();
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.address = (String)in.readObject();
            this.year = in.readInt();
            in.close();
        }
    }

    public static void main(String[] args) {

    }
}
