package main;

import java.time.LocalDate;
import java.util.Date;
/**
 * This class is representing an FarmWorker and Its all features
 * It also has constructors, setter and getter methods.
 * @author Umut Baybece
 * @see main.Employee You need to check out Animal class as a reference
 */
public class FarmWorker extends Employee{
    /** The previous farm name of the farmworker*/
    private String previousFarmName;
    /** The workexperience of the farmworker*/
    private int workexperience;

    /** The default constructor*/
    public FarmWorker(){}

    /** Construct a FarmWorker with the entered values
     * @param gender This is the parameter that will be set
     * @param dateOfBirth This is the parameter that will be set
     * @param empID This is the parameter that will be set
     * @param previousFarmName This is the parameter that will be set
     * @param workexperience This is the parameter that will be set  */
    public FarmWorker(int empID, String gender,LocalDate dateOfBirth, String previousFarmName, int workexperience){
        super(empID,gender,dateOfBirth);
        this.previousFarmName = previousFarmName;
        this.workexperience = workexperience;
    }

    /** Construct a FarmWorker with the entered values with no working experience
     * @param gender This is the parameter that will be set
     * @param dateOfBirth This is the parameter that will be set
     * @param empID This is the parameter that will be set
     * @param previousFarmName This is the parameter that will be set */
    public FarmWorker(int empID, String gender, LocalDate dateOfBirth, String previousFarmName){
        super(empID,gender,dateOfBirth);
        this.previousFarmName = previousFarmName;
        this.workexperience = 0;
    }

    /** Implements getSalary method of Payment Interface
     * @return the salary of this Veterinary  */
    public double getSalary(){
        return Payment.grossSalary + (0.02 * Payment.grossSalary * workexperience);
    };

    /** Returns the workexperience of this FarmWorker
     * @return the workexperience of this FarmWorker  */
    public int getWorkexperience() {
        return workexperience;
    }
    /** Returns the previousFarmName of this FarmWorker
     * @return the previousFarmName of this FarmWorker  */
    public String getPreviousFarmName() {
        return previousFarmName;
    }

    /** Sets the previousFarmName of this FarmWorker
     * @param previousFarmName This is the parameter that will be set */
    public void setPreviousFarmName(String previousFarmName) {
        this.previousFarmName = previousFarmName;
    }
    /** Sets the workexperience of this FarmWorker
     * @param workexperience This is the parameter that will be set */
    public void setWorkexperience(int workexperience) {
        this.workexperience = workexperience;
    }
}
