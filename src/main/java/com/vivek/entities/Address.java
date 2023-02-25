package com.vivek.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="student_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id")
    private int addressId;

    @Column(name="STREET",length = 100)
    private String street;

    @Column(name="CITY", length = 50)
    private String city;

    @Column(name="is_open")
    private boolean isOpen;

    @Transient
    private double x;

    @Column(name="date_created")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @Lob
    @Column(name="IMAGE")
    private byte[] image;

    public Address() {
    }

    public Address(int addressId, String street, String city, boolean isOpen, double x, Date dateCreated, byte[] image) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.isOpen = isOpen;
        this.x = x;
        this.dateCreated = dateCreated;
        this.image = image;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
