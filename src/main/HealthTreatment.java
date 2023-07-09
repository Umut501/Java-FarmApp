package main;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
/**
 * This class is representing an HealthTreatment and Its all features
 * It also has constructors, setter and getter methods.
 * @author Umut Baybece
 */
public class HealthTreatment extends Treatment implements Serializable {
    /** The emergency of the HealthTreatment is created */
    private boolean emergency;

    /** The medication list of the HealthTreatment is created */
    private ArrayList<Medication> meds;

    /** The veterinary of the HealthTreatment is created */
    private Veterinary veterinary;

    /** Construct a HealthTreatment with the entered values
     * @param dateOfTreatment This is the parameter that will be set
     * @param emergency  This is the parameter that will be set
     * @param meds  This is the parameter that will be set
     * @param veterinary   This is the parameter that will be set  */
    public HealthTreatment(LocalDate dateOfTreatment, boolean emergency, ArrayList<Medication> meds, Veterinary veterinary){
        super(dateOfTreatment);
        this.emergency = emergency;
        this.meds = meds;
        this.veterinary = veterinary;
    }
    /** Construct a HealthTreatment with the entered values and no emergency
     * @param dateOfTreatment This is the parameter that will be set
     * @param meds  This is the parameter that will be set
     * @param veterinary   This is the parameter that will be set  */
    public HealthTreatment(LocalDate dateOfTreatment,ArrayList<Medication> meds,Veterinary veterinary){
        super(dateOfTreatment);
        this.emergency = false;
        this.meds = meds;
        this.veterinary = veterinary;
    }

    /** Returns the medications of this HealthTreatment
     *  @return the medications of this HealthTreatment */
    public ArrayList<Medication> getMeds() {
        return meds;
    }
    /** Returns the Veterinary of this HealthTreatment
     *  @return the Veterinary of this HealthTreatment */
    public Veterinary getVeterinary() {
        return veterinary;
    }
    /** Returns the emergency of this HealthTreatment
     *  @return the emergency of this HealthTreatment */
    public Boolean getEmergency() {
        return emergency;
    }

    /** Sets the emergency of this HealthTreatment
     * @param emergency This is the parameter that will be set */
    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }
    /** Sets the meds of this HealthTreatment
     * @param meds This is the parameter that will be set */
    public void setMeds(ArrayList<Medication> meds) {
        this.meds = meds;
    }
    /** Sets the veterinary of this HealthTreatment
     * @param veterinary This is the parameter that will be set */
    public void setVeterinary(Veterinary veterinary) {
        this.veterinary = veterinary;
    }
}
