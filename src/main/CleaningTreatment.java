package main;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
/**
 * This class is representing an CleaningTreatment and Its all features
 * It also has constructors, setter and getter methods.
 * @author Umut Baybece
 */
public class CleaningTreatment extends Treatment implements Serializable {
    /** The materials used for the CleaningTreatment is created */
    private String materialsused;

    /** The FarmWorker of the CleaningTreatment is created */
    private FarmWorker farmWorker;

    /** Construct a CleaningTreatment with the entered values
     * @param dateOfTreatment This is the parameter that will be set
     * @param farmWorker This is the parameter that will be set
     * @param materialsused This is the parameter that will be set  */
    public CleaningTreatment(String materialsused, FarmWorker farmWorker, LocalDate dateOfTreatment){
        super(dateOfTreatment);
        this.materialsused = materialsused;
        this.farmWorker = farmWorker;
    }
    /** Construct a CleaningTreatment with the entered values and
     *  as used materials only standard materials will be recorded
     * @param dateOfTreatment This is the parameter that will be set
     * @param farmWorker This is the parameter that will be set */
    public CleaningTreatment(FarmWorker farmWorker,LocalDate dateOfTreatment){
        super(dateOfTreatment);
        this.materialsused = "only standard materials ";
        this.farmWorker = farmWorker;
    }
    /** Returns the materials used for this CleaningTreatment
     *  @return the materials used for this CleaningTreatment  */
    public String getMaterialsused() {
        return materialsused;
    }
    /** Returns the farmWorker of this CleaningTreatment
     *  @return the farmWorker of this CleaningTreatment  */
    public FarmWorker getFarmWorker() {
        return farmWorker;
    }
    /** Sets the farmWorker of this CleaningTreatment
     * @param farmWorker This is the parameter that will be set */
    public void setFarmWorker(FarmWorker farmWorker) {
        this.farmWorker = farmWorker;
    }
    /** Sets the materials used for this CleaningTreatment
     * @param materialsused This is the parameter that will be set */
    public void setMaterialsused(String materialsused) {
        this.materialsused = materialsused;
    }
}
