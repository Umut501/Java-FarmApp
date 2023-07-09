package main;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**This class is representing a Treatment and Its all features
 * It also has constructors, setter and getter methods.
 * @author Umut Baybece
 * @see Veterinary You need to check out Veterinary class as a reference
 */
public class Treatment implements Serializable {
    /** The date of the Treatment is created */
    private LocalDate dateOfTreatment;

    /** Construct a Treatment with default dateOfTreatment */
    public Treatment(){
        this.dateOfTreatment = validate_Local_date("01.01.2000");
    }

    /** Construct a Treatment with the entered date value
     * @param dateOfTreatment  This is the parameter that will be set */
    public Treatment(LocalDate dateOfTreatment){
        this.dateOfTreatment = dateOfTreatment;
    }

    /** Returns the date of this Treatment
     *  @return the date of this treatment  */
    public LocalDate getDateOfTreatment() {
        return dateOfTreatment;
    }

    /** Sets the dateOfTreatment of this Treatment
     * @param dateOfTreatment This is the parameter that will be set */
    public void setDateOfTreatment(LocalDate dateOfTreatment) {
        this.dateOfTreatment = dateOfTreatment;
    }

    /** Checks string input, parses it and returns a Date object
     * @param str_date  This is the parameter that will be taken to validate the date
     * @return This method returns a valid Date object*/
    public LocalDate validate_Local_date(String str_date){
        Scanner input = new Scanner(System.in);
        LocalDate new_dateOf = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //dateFormat.setLenient(false);
        boolean control = false;
        do{
            try {//throws an exception if the format is wrong
                new_dateOf = LocalDate.parse(str_date,formatter);
                control = true;
            }
            catch (DateTimeParseException e) {
                System.out.println("Enter date in the correct format: 'dd/MM/yyyy'");
                str_date = input.nextLine();
            }
        }while(!control);
        return  new_dateOf;
    }
}
