package com.example.demo.models;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    public static final int CNP_LENGTH = 13;
    //ar avea sens sa pun cnp intr-o clasa separata?
    private static final AtomicInteger currentCNPNumber = new AtomicInteger(1);
    private final String cnp;
    private String firstName;
    private String lastName;
    private Address address;

    public User() {
        this.cnp = this.createCNP();
        this.address = new Address();
    }

    public User(String firstName, String lastName, String city) {
        this.cnp = this.createCNP();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = new Address(city);
    }

    public User(String firstName, String lastName, Address address) {
        this.cnp = this.createCNP();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public User(User user) {
        this.cnp = this.createCNP();
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.address = user.address;
    }

    private String createCNP() {
        String currNumber = String.valueOf(currentCNPNumber.getAndIncrement());
        int remainingNumbers = CNP_LENGTH - currNumber.length();
        StringBuilder cnp = new StringBuilder();
        while(remainingNumbers-- > 1) {
            cnp.append(0);
        }
        return cnp.append(currNumber).toString();
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getCnp() {
        return cnp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return new Address(this.address);
    }

    public void setAddress(Address address) {
        this.address = new Address(address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return cnp.equals(user.cnp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnp);
    }

    public static class Address {
        private String street;
        private int streetNo;
        private String city;
        private String country;

        public Address() {}

        //for simplicity
        public Address(String city) {
            this.city = city;
        }

        public Address(String street, int streetNo, String city, String country) {
            this.street = street;
            this.streetNo = streetNo;
            this.city = city;
            this.country = country;
        }

        public Address(Address address)
        {
            this.street = address.street;
            this.streetNo = address.streetNo;
            this.city = address.city;
            this.country = address.country;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public int getStreetNo() {
            return streetNo;
        }

        public void setStreetNo(int streetNo) {
            this.streetNo = streetNo;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", streetNo=" + streetNo +
                    ", city='" + city + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "cnp='" + cnp + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}
