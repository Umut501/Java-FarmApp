package main;
/**
 * This Interface is representing a Payment interface and Its all features
 * @author Umut Baybece
 */
public interface Payment {
     /** This is grossSalary amount */
     double grossSalary = 10000;
     /** This is an abstract method for getting salary  */
     double getSalary();// Implementation is provided for Veterinary and FarmWorker Classes
}
