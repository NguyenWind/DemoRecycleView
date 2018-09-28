package com.example.hoanhintern.demorecycleview;

public class Data {
    private String Name;
    private int Age;
    private  String PhoneNumber;
    private boolean Male;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public boolean isMale() {
        return Male;
    }

    public void setMale(boolean male) {
        Male = male;
    }

    public Data(String name, int age, String phoneNumber, boolean male) {

        Name = name;
        Age = age;
        PhoneNumber = phoneNumber;
        Male = male;
    }
}
