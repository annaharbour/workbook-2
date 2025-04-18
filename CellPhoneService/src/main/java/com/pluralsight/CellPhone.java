package com.pluralsight;

public class CellPhone {
    private int serialNumber;
    private String model;
    private String carrier;
    private String phoneNumber;
    private String owner;

    public CellPhone() {
        this.serialNumber = 0;
        this.model = "";
        this.carrier = "";
        this.phoneNumber = "";
        this.owner = "";
    }

    public CellPhone(int serialNumber, String model, String carrier, String phoneNumber, String owner) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.carrier = carrier;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setOwner(String owner){
        this.owner = owner;
    }

    public String getOwner(){
        return this.owner;
    }

    public void printData(){
        System.out.printf("Serial number: %d\n", this.getSerialNumber());
        System.out.printf("Model: %s\n", this.getModel());
        System.out.printf("Carrier: %s\n", this.getCarrier());
        System.out.printf("Phone Number: %s\n", this.getPhoneNumber());
        System.out.printf("Phone owner: %s\n", this.getOwner());
    }

    public void dial(String dialedPhoneNum){
        System.out.printf("%s is calling #%s\n", this.owner, dialedPhoneNum);
    }

    public void dial(CellPhone cellPhone){
        System.out.printf("%s is calling #%s\n", this.owner, cellPhone.phoneNumber);
    }

}
