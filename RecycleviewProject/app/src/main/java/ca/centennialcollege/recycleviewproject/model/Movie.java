package ca.centennialcollege.recycleviewproject.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Movie {
   String name;
   String description;
   String image;
   String displayName;
   String dob;
   String country;

   public String getDob() {
      return dob;
   }

   public void setDob(String dob) {
      this.dob = dob;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public Movie(String name, String description, String image) {
      this.name = name;
      this.description = description;
      this.image = image;
   }

   public String getImage() {
      return image;
   }

   public void setImage(String image) {
      this.image = image;
   }

     public Movie(String name, String description, String image, String displayName) {
      this.name = name;
      this.description = description;
      this.image = image;
      this.displayName = displayName;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }
}
