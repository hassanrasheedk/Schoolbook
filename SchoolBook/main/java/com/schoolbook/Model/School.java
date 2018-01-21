package com.schoolbook.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hassa on 09-Jan-18.
 */

public class School implements Serializable {
    int schoolID;
    String schoolName;
    String address;
    int fee;
    double x,y,rating;
    String stdtchratio;
    String about;
    int ranking;//schoolbook ranking

    public School(){}

    public School(int schoolID, String schoolName, String address, int fee, double x, double y, String stdtchratio, String about, double rating, int ranking)
    {
        this.schoolID=schoolID;
        this.schoolName=schoolName;
        this.address=address;
        this.x=x;
        this.y=y;
        this.stdtchratio=stdtchratio;
        this.about=about;
        this.rating=rating;
        this.ranking=ranking;
        this.fee=fee;
    }

    public School(String schoolName, String address, int fee, double x, double y, String stdtchratio, String about, double rating, int ranking)
    {
        this.schoolName=schoolName;
        this.schoolName=schoolName;
        this.address=address;
        this.x=x;
        this.y=y;
        this.stdtchratio=stdtchratio;
        this.about=about;
        this.rating=rating;
        this.ranking=ranking;
        this.fee=fee;
    }

    public School getSchool(){
        return this;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStdtchratio() {
        return stdtchratio;
    }

    public void setStdtchratio(String stdtchratio) {
        this.stdtchratio = stdtchratio;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }


    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}