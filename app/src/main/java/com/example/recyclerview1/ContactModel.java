package com.example.recyclerview1;

public class ContactModel {
    int img ;

    String name, number;

    public ContactModel(int image, String name , String number ){
        this.img = image;
        this.name = name;
        this.number = number;


    }

    public ContactModel( String name , String number ){

        this.name = name;
        this.number = number;


    }

}
