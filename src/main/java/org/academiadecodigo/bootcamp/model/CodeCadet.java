package org.academiadecodigo.bootcamp.model;

import org.academiadecodigo.bootcamp.utils.Gender;

import java.util.Date;

public class CodeCadet {

    private User user;
    private Gender gender;
    private String address;
    private String city;
    private String phone;
    private Bootcamp bootcamp;
    private Date birthdate;


    public CodeCadet(User user,Gender gender,String address,String city,String phone,Bootcamp bootcamp,Date birthdate){
        this.user = user;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.birthdate = birthdate;
        this.phone = phone;
        this.bootcamp = bootcamp;
    }

    public User getUser() {
        return user;
    }

    public Gender getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public Bootcamp getBootcamp() {
        return bootcamp;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBootcamp(Bootcamp bootcamp) {
        this.bootcamp = bootcamp;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CodeCadet codeCadet = (CodeCadet) o;

        return user.equals(codeCadet.user);
    }

    @Override
    public int hashCode() {
        return user.hashCode();
    }

    @Override
    public String toString() {
        return "CodeCadet{" +
                "user=" + user +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", bootcamp=" + bootcamp +
                ", birthdate=" + birthdate +
                '}';
    }
}


