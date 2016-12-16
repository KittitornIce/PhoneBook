package com.example.phonebook.MODEL;

/**
 * Created by Kittitorn on 23-Oct-16.
 */

public class Contact {

    private String mName;
    private String mPhone;
    private String mImage;

    public Contact(String name, String phone, String image) {
        this.mName = name;
        this.mPhone = phone;
        this.mImage = image;
    }

    public String getName() {
        return mName;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getImage() {return mImage; }

    @Override
    public String toString() {
        return mName;
    }
}
