package ca.centennialcollege.recycleviewproject.model;

/**
 * Created by Admin on 15-05-2017.
 */

public class Datamodel {
    String id;
    String  displayName;
    String gender;
    String birthday;
    String height;
    String signature;

    String mainImage;
    String city;
    String latitude;
    String longitude;


    public Datamodel(String id, String displayName, String gender, String birthday, String height, String signature, String mainImage, String city, String latitude, String longitude) {
        this.id = id;
        this.displayName = displayName;
        this.gender = gender;
        this.birthday = birthday;
        this.height = height;
        this.signature = signature;
        this.mainImage = mainImage;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Datamodel() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }



}
