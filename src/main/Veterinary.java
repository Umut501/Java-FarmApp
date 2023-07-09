package main;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * This class is representing a Veterinary and Its all features
 * It also has constructors, setter and getter methods.
 * @author Umut Baybece
 * @see main.Employee You need to check out Animal class as a reference
 */
public class Veterinary extends Employee implements Serializable {
    /** BScDegree of a vet*/
    private Boolean BScDegree;
    /** dateOfGraduation of a vet*/
    private LocalDate dateOfGraduation;
    /** expertiseLevel of a vet*/
    private int expertiseLevel;
    /** The derfault constructor of vet*/
    public Veterinary(){}

    /** Construct a Veterinary with the entered values
     * @param gender This is the parameter that will be set
     * @param dateOfBirth This is the parameter that will be set
     * @param vetID This is the parameter that will be set
     * @param BScDegree This is the parameter that will be set
     * @param dateOfGraduation This is the parameter that will be set
     * @param expertiseLevel This is the parameter that will be set */
    public Veterinary(int vetID, String gender,LocalDate dateOfBirth,Boolean BScDegree,LocalDate dateOfGraduation,int expertiseLevel){
        super(vetID,gender,dateOfBirth);
        this.BScDegree = BScDegree;
        this.dateOfGraduation = dateOfGraduation;
        this.expertiseLevel = expertiseLevel;
    }

    /** Construct a Veterinary with the entered values and no BScDegree
     * @param dateOfBirth This is the parameter that will be set
     * @param vetID This is the parameter that will be set
     * @param dateOfGraduation This is the parameter that will be set
     * @param expertiseLevel This is the parameter that will be set
     * @param gender This is the parameter that will be set */
    public Veterinary(int vetID, String gender, LocalDate dateOfBirth, LocalDate dateOfGraduation, int expertiseLevel){
        super(vetID,gender,dateOfBirth);
        this.BScDegree = false;
        this.dateOfGraduation = dateOfGraduation;
        this.expertiseLevel = expertiseLevel;
    }

    /** Implements getSalary method of Payment Interface
     * @return the salary of this Veterinary  */
    public double getSalary(){
        return Payment.grossSalary + (0.10 * Payment.grossSalary * (LocalDate.now().getYear() - dateOfGraduation.getYear()));
    };

    /** Returns the BScDegree of this Veterinary
     * @return the BScDegree of this Veterinary  */
    public Boolean getBScDegree() {
        return BScDegree;
    }
    /** Returns the expertiseLevel of this Veterinary
     * @return the expertiseLevel of this Veterinary  */
    public int getExpertiseLevel() {
        return expertiseLevel;
    }
    /** Returns the dateOfGraduation of this Veterinary
     * @return the dateOfGraduation of this Veterinary  */
    public LocalDate getDateOfGraduation() {
        return dateOfGraduation;
    }

    /** Sets the BScDegree of this Veterinary
     * @param BScDegree This is the parameter that will be set */
    public void setBScDegree(Boolean BScDegree) {
        this.BScDegree = BScDegree;
    }
    /** Sets the expertiseLevel of this Veterinary
     * @param expertiseLevel This is the parameter that will be set */
    public void setExpertiseLevel(int expertiseLevel) {
        this.expertiseLevel = expertiseLevel;
    }
    /** Sets the dateOfGraduation of this Veterinary
     * @param dateOfGraduation This is the parameter that will be set */
    public void setDateOfGraduation(LocalDate dateOfGraduation) {
        this.dateOfGraduation = dateOfGraduation;
    }
}