package main;
import java.time.LocalDate;
import java.io.Serializable;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
/**
 * This abstract class is representing an Employee and Its all features
 * It also has constructors, setter and getter methods.
 * @author Umut Baybece
 */
public abstract class Employee implements Serializable,Payment, Comparable<Employee> {
    /** The ID of the Employee is created */
    private int empID;
    /** The gender of the Employee is created */
    private String gender;
    /** The dateOfBirth of the Employee is created */
    private LocalDate dateOfBirth;

    public abstract double getSalary();

    public int compareTo(Employee e){
        if(this.getSalary() > e.getSalary())
            return 0;
        else if(this.getSalary() == e.getSalary()){
            return 1;
        }
        else
            return -1;
    }

    /** Default constructor of Employee*/
    public Employee(){}

    /** Construct an Employee with the entered values
     * @param gender This is the parameter that will be set
     * @param dateOfBirth This is the parameter that will be set
     * @param empID This is the parameter that will be set*/
    public Employee(int empID, String gender,LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
        this.empID = empID;
        this.gender = gender;
    }

    /** Construct an Employee with the entered values and a no gender value
     * @param dateOfBirth This is the parameter that will be set
     * @param empID This is the parameter that will be set*/
    public Employee(int empID,LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
        this.empID = empID;
        this.gender = "No Gender Specified";
    }

    /** Returns the gender of this Employee
     * @return the gender of this Employee  */
    public String getGender() {
        return gender;
    }
    /** Returns the dateOfBirth of this Employee
     * @return the dateOfBirth of this Employee  */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /** Returns the empID of this Employee
     * @return the empID of this Employee  */
    public int getEmpID() {
        return empID;
    }

    /** Sets the vetID of this Employee
     * @param empID This is the parameter that will be set */
    public void setVetID(int empID) {
        this.empID = empID;
    }

    /** Sets the date of birth of this Employee
     * @param dateOfBirth This is the parameter that will be set */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /** Sets the gender of this Employee
     * @param gender This is the parameter that will be set */
    public void setGender(String gender) {
        this.gender = gender;
    }



}
