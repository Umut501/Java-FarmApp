package main;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
/** This class is representing a Sheep and Its all features
 * It also has constructors, setter and getter methods
 * @author Umut Baybece
 * @see main.Treatment You need to check out Treatment class as a reference
 * @see main.Animal You need to check out Animal class as a reference
 */

public class Sheep extends Animal {

    /** Construct a Sheep with the entered values and list of treatments
     * @param tagNo This is the parameter that will be set
     * @param gender This is the parameter that will be set
     * @param purchased This is the parameter that will be set
     * @param dateOfBirth This is the parameter that will be set
     * @param treatments  This is the parameter that will be set */
    public Sheep(int tagNo, String gender, LocalDate dateOfBirth, boolean purchased, ArrayList<Treatment> treatments){
        super(tagNo,gender,dateOfBirth,purchased);
    }

    /** Construct a Sheep with the entered values and makes it farm-raised by default
     * @param tagNo This is the parameter that will be set
     * @param gender This is the parameter that will be set
     * @param dateOfBirth This is the parameter that will be set
     * @param treatments  This is the parameter that will be set */
    public Sheep(int tagNo, String gender, LocalDate dateOfBirth, boolean purchased, ArrayList<Treatment> treatments,HashMap<LocalDate,Double> milking){
        super(tagNo,gender,dateOfBirth,purchased,treatments,milking);
    }
    public Sheep(int tagNo, String gender, LocalDate dateOfBirth, boolean purchased){
        super(tagNo,gender,dateOfBirth,purchased);
    }
    Sheep(){}//default constructor

    /** The body of feeding() for Sheep class is provided here. This method prints what a sheep eats according to its age and weight. */
    public void feeding(JTable feedingTable){
        String feedingInfo="";
        if((this.getAge() < 5) && (this.getGender().equals("male"))){//if a sheep is male and younger than 5 years old
            feedingInfo = "Grass";
        }
        else if((this.getAge() < 8) && (this.getGender().equals("female"))){ //If a sheep is female and younger than 8
            feedingInfo = "Grass";
        }
        else if((this.getAge() > 5) && (this.getGender().equals("male"))){// If a sheep is male and older than 5 years old
            feedingInfo = "Total mixed ration";
        }
        else if((this.getAge() > 8) && (this.getGender().equals("female"))){//If a sheep is female and older than 8 years old
            feedingInfo = "Total mixed ration";
        }

        // Adding the feeding info to the JTable
        DefaultTableModel model = (DefaultTableModel) feedingTable.getModel();
        model.addRow(new Object[]{this.getTagNo(), this.getGender(), this.getAge(), feedingInfo});
    }



}
