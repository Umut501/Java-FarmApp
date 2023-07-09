package main;
import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;

/** This abstract class is representing a Animal and Its all features
 * It also has constructors, setter and getter methods and getAge method.
 * @author Umut Baybece
 * @see main.Treatment You need to check out Treatment class as a reference
 * @see main.Cow You need to check out Cow class for implementation of abstract feeding(); method
 * @see main.Sheep You need to check out Sheep class for implementation of abstract feeding(); method
 */
public abstract class Animal implements Serializable {
    /** The tagNo of the Animal is created */
    private int tagNo;
    /** The gender of the Animal is created */
    private String gender;
    /** The dateOfBirth of the Animal is created */
    private LocalDate dateOfBirth;
    /** The purchased or farm-raising detail of the Animal is created */
    private boolean purchased; //purchased or farm-raising
    /** The milking HashMap of the Animal is created */
    private HashMap<LocalDate,Double> milking;
    /** The Treatment list of the Cow is created */
    private ArrayList<Treatment> treatments;

    /** Construct an Animal with the entered values and no treatment and milking
     * @param gender This is the parameter that will be set
     * @param dateOfBirth This is the parameter that will be set
     * @param tagNo This is the parameter that will be set
     * @param purchased  This is the parameter that will be set */
    public Animal(int tagNo,String gender,LocalDate dateOfBirth,boolean purchased){
        this.tagNo = tagNo;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.purchased = purchased;
        this.milking  = new HashMap<LocalDate,Double>();
        this.treatments = new ArrayList<>();
    }

    /** Construct an Animal with the entered values and no milking
     * @param gender This is the parameter that will be set
     * @param dateOfBirth This is the parameter that will be set
     * @param treatments  This is the parameter that will be set
     * @param purchased This is the parameter that will be set
     * @param tagNo This is the parameter that will be set  */
    public Animal(int tagNo,String gender,LocalDate dateOfBirth,boolean purchased,ArrayList<Treatment> treatments, HashMap<LocalDate,Double> milking){
        this.tagNo = tagNo;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.purchased = purchased;
        this.milking  = milking;
        this.treatments = treatments;
    }

    /** default constructor*/
    public Animal(){};

    public Animal(int tagNo, String gender, LocalDate dateOfBirth, boolean purchased, ArrayList<Treatment> treatments) {
            this.tagNo = tagNo;
            this.gender = gender;
            this.dateOfBirth = dateOfBirth;
            this.purchased = purchased;
            this.milking  = new HashMap<>();
            this.treatments = treatments;
        }

    /** Returns the age of this Animal
     * @return the age of this Animal  */
    public int getAge(){
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    /** Returns the treatments of this Animal
     *  @return the treatments of this Animal  */
    public ArrayList<Treatment> getTreatments() {
        return treatments;
    }

    /** Returns the tagNo of this Animal
     * @return the tagNo of this Animal  */
    public int getTagNo() {
        return tagNo;
    }

    /** Returns the dateOfBirth of this Animal
     * @return the dateOfBirth of this Animal  */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /** Returns the gender of this Animal
     *  @return the gender of this Animal  */
    public String getGender() {
        return gender;
    }

    /** Returns the  purchased or farm-raising detail of this Animal
     *  @return the purchased or farm-raising detail of this Animal  */
    public boolean getPurchased() {
        return purchased;
    }

    /** Returns the  milking of this Animal
     *  @return the milking of this Animal  */
    public HashMap<LocalDate,Double> getMilking() {
        return milking;
    }

    /** Sets the dateOfBirth of this Animal
     *  @param dateOfBirth This is the parameter that will be set */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /** Sets the gender of this Animal
     *  @param gender This is the parameter that will be set */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /** Sets the purchased of this Animal
     *  @param purchased This is the parameter that will be set */
    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    /** Sets the tagNo of this Animal
     *  @param tagNo This is the parameter that will be set */
    public void setTagNo(int tagNo) {
        this.tagNo = tagNo;
    }

    /** Sets the milking of this Animal
     *  @param milking This is the parameter that will be set */
    public void setMilking(HashMap<LocalDate,Double>  milking) {
        this.milking = milking;
    }

    /** Sets the treatments of this Animal
     *  @param treatments This is the parameter that will be set */
    public void setTreatments(ArrayList<Treatment> treatments) {
        this.treatments = treatments;
    }

    /** Adds the treatments of this Animal
     *  @param treatments This is the parameter that will be set */
    public void addTreatments(ArrayList<Treatment> treatments) {
        int a;
        for(a = 0; a < treatments.size(); a++){
            this.treatments.add(treatments.get(a));
        }
    }

    /** Returns the  milking of this Animal
     * @param milk This is the parameter that will be set
     * @param dt This is the parameter that will be set  */
    public void setMilking(LocalDate dt ,Double milk) {
        this.milking.put(dt,milk);
    }

    /** this is an abstract method which is implemented in Cow and Sheep classes*/
    public abstract void feeding(JTable feedingTable);

}