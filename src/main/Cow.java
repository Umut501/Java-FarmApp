package main;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;

/** This class is representing a Cow and Its all features
 * It also has constructors, setter and getter methods and getAge method.
 * @author Umut Baybece
 * @see main.Treatment You need to check out Treatment class as a reference
 * @see main.Animal You need to check out Animal class as a reference
 */
public class Cow extends Animal  {

    /** The weight of the Cow is created */
    private double weight;

        /** Construct a Cow with the entered values and with no treatments
         * @param tagNo This is the parameter that will be set
         * @param gender This is the parameter that will be set
         * @param purchased This is the parameter that will be set
         * @param dateOfBirth This is the parameter that will be set
          *@param weight  This is the parameter that will be set */
        public Cow(int tagNo, String gender, LocalDate dateOfBirth, boolean purchased,double weight){
            super(tagNo,gender,dateOfBirth,purchased);
            this.weight = weight;
        }

        /** Construct a Cow with the entered values
         * @param tagNo This is the parameter that will be set
         * @param gender This is the parameter that will be set
         * @param purchased This is the parameter that will be set
         * @param dateOfBirth This is the parameter that will be set
         * @param weight This is the parameter that will be set
         * @param treatments  This is the parameter that will be set */
        public Cow(int tagNo, String gender, LocalDate dateOfBirth, boolean purchased,double weight, ArrayList<Treatment> treatments,HashMap<LocalDate,Double> milking){
            super(tagNo,gender,dateOfBirth,purchased,treatments,milking);
            this.weight = weight;
        }

    /** default constructor*/
        public Cow(){
            this.setTagNo(0);
        }

    public Cow(int tagNo, String gender, LocalDate dateOfBirth, boolean purchased, double weight, ArrayList<Treatment> treatments) {
        super(tagNo,gender,dateOfBirth,purchased,treatments);
        this.weight = weight;
    }

    /** The body of feeding() for Cow class is provided here. This method prints what a cow eats according to its age and weight. */
    public void feeding(JTable feedingTable){
        String feedingInfo;
        if(this.getAge() < 3){//If a cow is younger than 3 years
            feedingInfo = "Grass";
        }
        else if((this.getAge() > 5) && (this.weight <500)){// If a cow is older than 5 years old and weight is less than 500
            feedingInfo = "TMR";
        }
        else if((this.getAge() > 10) && (this.weight <500)){//If a cow is older than 10 years old
            feedingInfo = "Grains,Oilseed Meals";
        }
        else{
            feedingInfo = "Grass and Grains";
        }

        // Add the feeding info to the JTable
        DefaultTableModel model = (DefaultTableModel) feedingTable.getModel();
        model.addRow(new Object[]{this.getTagNo(), this.getGender(), this.getAge(), feedingInfo});
    }

    /** Returns weight of this Cow
     *  @return the weight of this Cow  */
    public double getWeight() {
        return weight;
    }

    /** Sets the weight of this Cow
     *  @param weight  This is the parameter that will be set */
    public void setWeight(double weight) {
        this.weight = weight;
    }


}


