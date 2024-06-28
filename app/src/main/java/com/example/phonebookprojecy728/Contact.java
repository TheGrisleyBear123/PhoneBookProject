package com.example.phonebookprojecy728;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Contact implements Parcelable {
    private String name;
    private int imageID;

    private String phoneNumber;

    private String email;
    private String address;
    public Contact(String n, int i, String p, String e, String a) {
        name = n;
        imageID = i;
        phoneNumber = p;
        email = e;
        address = a;

    }

    protected Contact(Parcel in) {
        name = in.readString();
        imageID = in.readInt();
        phoneNumber = in.readString();
        email = in.readString();
        address = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getName()
    {
        return name;
    }

    public int getImageId()
    {
        return imageID;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getEmail(){
        return email;
    }

    public String getAddress(){
        return address;
    }

    public void setName(String n){
        name = n;
    }

    public void setImageID(int iid){
        imageID = iid;
    }

    public void setPhoneNumber(String pN){
        phoneNumber = pN;
    }

    public void setEmail(String e){
        email = e;
    }

    public void setAddress(String a){
        address = a;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {

        parcel.writeString(name);
        parcel.writeInt(imageID);
        parcel.writeString(phoneNumber);
        parcel.writeString(email);
        parcel.writeString(address);
    }
}
