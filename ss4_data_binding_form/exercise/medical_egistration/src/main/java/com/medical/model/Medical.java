package com.medical.model;

public class Medical {
    String name;
    String yearOfBirth;
    String gender;
    String country;
    String idCMNN;
    String travelInformation;
    String licensePlate;
    String dayStart;
    String dayEnd;
     String information;

    public Medical() {
    }

    public Medical(String name, String yearOfBirth, String gender, String country, String idCMNN, String travelInformation, String licensePlate, String dayStart, String dayEnd, String information) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.country = country;
        this.idCMNN = idCMNN;
        this.travelInformation = travelInformation;
        this.licensePlate = licensePlate;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.information = information;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIdCMNN() {
        return idCMNN;
    }

    public void setIdCMNN(String idCMNN) {
        this.idCMNN = idCMNN;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "Medical{" +
                "name='" + name + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", idCMNN='" + idCMNN + '\'' +
                ", travelInformation='" + travelInformation + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", dayStart='" + dayStart + '\'' +
                ", dayEnd='" + dayEnd + '\'' +
                ", information='" + information + '\'' +
                '}';
    }
}
