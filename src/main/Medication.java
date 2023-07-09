package main;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * This class is representing a Medication and Its all features
 * It also has constructors, setter and getter methods.
 * @author Umut Baybece
 */
public class Medication implements Serializable {
    /** The details of the Medication is created */
    private String details;

    /** The duration of the Medication is created */
    private int duration;

    /** The start date of the Medication is created */
    private LocalDate startDate;

    /** The start dosage of the Medication is created */
    private double Dosage;

    /** The notes of the Medication is created */
    private String notes;

    /** Construct a Medication with default details and duration */
    public Medication(){
        details = "Do not use on the different animals!";
        duration = 30;
    }

    /** Construct a Medication with the entered values
     * @param startDate This is the parameter that will be set
     * @param details This is the parameter that will be set
     * @param Dosage This is the parameter that will be set
     * @param duration This is the parameter that will be set
     * @param notes This is the parameter that will be set */
    public Medication(String details,int duration, LocalDate startDate,double Dosage,String notes){
        this.details = details;
        this.duration = duration;
        this.startDate = startDate;
        this.Dosage = Dosage;
        this.notes = notes;
    }

    /** Returns the details of this Medication
     * @return the details of this medication  */
    public String getDetails() {
        return details;
    }

    /** Returns the start date of this Medication
     * @return the start date of this medication  */
    public LocalDate getStartDate() {
        return startDate;
    }

    /** Returns the Dosage of this Medication
     * @return the dosage of this medication  */
    public double getDosage() {
        return Dosage;
    }

    /** Returns the duration of this Medication
     * @return the duration of this medication  */
    public int getDuration() {
        return duration;
    }

    /** Returns the notes of this Medication
     * @return the notes of the Medication */
    public String getNotes() { return notes; }

    /** Sets the details of this Medication
     * @param details This is the parameter that will be set */
    public void setDetails(String details) {
        this.details = details;
    }

    /** Sets the Dosage of this Medication
     * @param dosage This is the parameter that will be set */
    public void setDosage(double dosage) {
        Dosage = dosage;
    }

    /** Sets the duration of this Medication
     * @param duration This is the parameter that will be set */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /** Sets the notes of this Medication
     * @param notes This is the parameter that will be set */
    public void setNotes(String notes) { this.notes = notes; }

    /** Sets the start date of this Medication
     * @param startDate This is the parameter that will be set */
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
}
