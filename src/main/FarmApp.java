package main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;

/** This class is representing a specific Farm and Its structure with all specified features.
 * It also has several methods to manage the farm operations besides constructors, setter and getter methods.
 * @author Umut Baybece
 * @version  1.1
 * @see Treatment You need to check out Treatment class as a reference
 * @see Medication You need to check out Medication class as a reference
 * @see Employee You need to check out Veterinary class as a reference
 * @see Animal You need to check out Cow class as a reference
 */
public class FarmApp extends JFrame {
    String userName = "cng443user";
    String password = "1234";
    String url = "jdbc:mysql://localhost/FarmAppDB";
    Connection conn = DriverManager.getConnection(url, userName, password);
    Statement statement = conn.createStatement();
    private JPanel CardLayoutPanel;
    private JPanel AddANewCowPanel;
    private JPanel DeleteAAnimalPanel;
    private JLabel DeleteACowTitle;
    private JLabel AddANewCowTitle;
    private JPanel mainMenuPanel;
    private JPanel mainPanel;
    private JButton deleteTheCowButton;
    private JFormattedTextField tagNoField;
    private JPanel ViewAnimalDetailsPanel;
    private JLabel ViewCowDetailsTitle;
    private JPanel AddANewVeterinaryPanel;
    private JLabel AddANewVeterinaryTitle;
    private JPanel DeleteAEmployeePanel;
    private JLabel DeleteAVeterinaryTitle;
    private JFormattedTextField tagnoFieldAddCow;
    private JFormattedTextField DateOfBirthTextFieldAddCow;
    private JFormattedTextField weightTextField;
    private JButton addTheCowButton;
    private JLabel tagNoLabel;
    private JLabel genderLabel;
    private JComboBox<Object> GendercomboBox;
    private JComboBox<Object> RaisingTypecomboBox;
    private JLabel Purchase;
    private JTextArea listOfCows;
    private JFormattedTextField getCowDetailsTagField;
    private JLabel getCowDetailsLabel;
    private JTextArea getCowDetailsTextFieldTextArea;
    private JButton seeCowDetailsButton;
    private JScrollPane scrollPaneListOfCows;
    private JLabel EmployeeIDLabel;
    private JFormattedTextField EmployeeIDField;
    private JLabel GenderLabel;
    private JComboBox<Object> VetGenderCombobox;
    private JComboBox<Object> BScDegree;
    private JLabel BScDegreeLabel;
    private JLabel DateofgraduationLabel;
    private JFormattedTextField DateofgraduationField;
    private JLabel VetDateofbirthLabel;
    private JFormattedTextField VetDateofbirthField;
    private JLabel ExpertiselevelLabel;
    private JFormattedTextField ExpertiselevelField;
    private JButton AddTheVetButton;
    private JLabel ListOfVeterinariesLabel;
    private JTextArea listofVets;
    private JScrollPane ListOfVeterinariesScroll;
    private JButton deleteAVetBtn;
    private JFormattedTextField deleteAVetField;
    private JLabel deleteAVetLabel;
    private JPanel ViewEmployeeDetailsPanel;
    private JPanel AddATreatmentPanel;
    private JPanel SeeAllTheTreatmentsPanel;
    private JPanel blank;
    private JLabel veterinaryDetailsTitle;
    private JLabel veterinaryDetailsLabel;
    private JFormattedTextField veterinaryDetailsIDField;
    private JTextArea veterinaryDetailsTextArea;
    private JButton veterinaryDetailsSeeBtn;
    private JButton addTheTreatmentButton;
    private JFormattedTextField tagnoFieldAddTreatment;
    private JFormattedTextField IDFieldAddTreatment;
    private JLabel EmpIdLabel;
    private JLabel tagNoLabelTreatment;
    private JComboBox<Object> TreatmentTypeComboBox;
    private JLabel TreatmentTypeLabel;
    private JLabel addANewHealthTitle;
    private JLabel addANewCleaningLabel;
    private JPanel addANewCleaningPanel;
    private JPanel addANewHealthJPanel;
    private JComboBox<Object> EmergencyComboBox;
    private JFormattedTextField HealthTreatmentDate;
    private JFormattedTextField CleaningTreatmentDate;
    private JLabel CleaningTreatmentDLabel;
    private JTextField materialUsedField;
    private JLabel MaterialUsedLabel;
    private JTextArea tableTreatments;
    private JTextField textFieldTagTreat;
    private JButton showTreatmentListButton;
    private JLabel tagNoTreatmentList;
    private JScrollPane tableTreatmentsScroll;
    private JLabel SeeAllTheTreatmentsTitle;
    private JTextArea tableTreatmentsDate;
    private JScrollPane tableTreatmentsDateScroll;
    private JButton tableTreatmentsDateBtn;
    private JLabel tableTreatmentsDatelbl;
    private JFormattedTextField tableTreatmentsDateField;
    private JPanel AddMilkingMeasurementPanel;
    private JLabel AddMilkingMeasurementTitle;
    private JLabel MilkingDateLabel;
    private JFormattedTextField MilkingDateField;
    private JLabel TagNolblmilk;
    private JTextField TagNoMilk;
    private JLabel AmountLbl;
    private JFormattedTextField AmountField;
    private JButton addTheMilkingRecordButton;
    private JPanel FeedingAnimalPanel;
    public JTable feedingTable;
    private JLabel FeedingOfAnimalTitle;
    private JTextField TagFeedingField;
    private JLabel TagFeedingLabel;
    private JButton showFeedingOfAnimalButton;
    private JPanel EmployeeSalaryPanel;
    private JPanel CompareWorkersPanel;
    private JLabel EmployeeIDofSalaryLabel;
    private JTextField EmployeeIDFieldSalary;
    private JTextArea textAreaSalary;
    private JButton showTheSalaryButton;
    private JTextField SecondEmployeeIDFarmworker;
    private JTextField FirstEmployeeIDFarmworker;
    private JTextField FirstEmployeeIDVet;
    private JTextField SecondEmployeeIDVet;
    private JButton compreFarmworkersButton;
    private JButton compareVeterinariesButton;
    private JLabel compareVeterinariesTitle;
    private JLabel compreFarmworkersTitle;
    private JLabel SecondEmployeeIDLabel;
    private JLabel FirstEmployeeIDLabel;
    private JTextArea CompareFarmworkerstextArea;
    private JTextArea compareVeterinariestextArea;
    private JPanel AddANewSheepPanel;
    private JPanel addSheepPanel;
    private JFormattedTextField addSheepTagNoField;
    private JLabel addSheepTagNoLbl;
    private JComboBox<Object> addSheepGenderBox;
    private JLabel lblgendersheep;
    private JLabel rsngtypelbl;
    private JComboBox<Object> raisingtypeSheepbox;
    private JFormattedTextField DBOShepField;
    private JLabel DBOSheeplbl;
    private JButton addTheSheepBtn;
    private JLabel previousFarmNamelbl;
    private JFormattedTextField previousFarmNameField;
    private JFormattedTextField empIdFieldWorker;
    private JComboBox<Object> genderFieldWorker;
    private JFormattedTextField workexperienceField;
    private JLabel workexperiencelbl;
    private JLabel DBOWorkerlbl;
    private JFormattedTextField DBOWorkerField;
    private JButton addFarmWorkerBtn;
    private JButton saveButton;
    private JPanel SaveToMyFilePanel;
    private JButton SaveToMyFilebtn;
    private JLabel SaveToMyFileTitle;
    private JLabel amount;

    /**
     * This is the main method to call all the other class methods and class constructors.
     *
     * @param args This is the only parameter that will be processed
     **/
    public static void main(String[] args) throws IOException, SQLException {
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Animal> animals = new ArrayList<>();
        FarmApp farm = new FarmApp(animals, employees);

        // this is the first thread to handle GUI
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.setProperty("user.timezone", "UTC"); //set for recording data to files
                farm.menu();
                farm.setVisible(true);
            }
        });

        // this is the second thread that reads the serialised animal objects, regenerates the MD5 for the serialised
        //objects in the external file and check if it is the same with the MD5 that stored
        //when the application was closed
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    farm.checkAnimalData();
                } catch (NoSuchAlgorithmException | ClassNotFoundException | IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    /**
     * The list of the animals is created
     */
    public ArrayList<Animal> animals;

    /**
     * The list of the employees is created
     */
    public ArrayList<Employee> employees;

    //the default constructor
    FarmApp() throws IOException, SQLException {
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();
    }

    /**
     *Constructor for the FarmApp class.
     *@param animals an ArrayList of Animal objects representing the animals on the farm
     *@param employees an ArrayList of Employee objects representing the employees on the farm
     *@throws IOException if there is an error writing to the file
     */
    public FarmApp(ArrayList<Animal> animals, ArrayList<Employee> employees) throws IOException, SQLException {
        super("FarmApp");
        this.animals = new ArrayList<>();
        this.employees =  new ArrayList<>();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        /** This action listener writes the objects to the database,
        /*This will be executed when the window is being closed */
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    updateTheDB();
                    writeObjectsToFile();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Application closed data recorded to the database and file!");
                exit();
            }
        });

        // Creating the JMenuBar
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        // Creates a JMenu for animal operations
        JMenu animal_operations = new JMenu("Animal Operations");
        menuBar.add(animal_operations);

        // Creates JMenuItems and add them to the menu
        JMenuItem addANewCow = new JMenuItem("Add A New Cow & See The List Of Animals");
        animal_operations.add(addANewCow);

        JMenuItem addANewSheep = new JMenuItem("Add A New Sheep");
        animal_operations.add(addANewSheep);

        JMenuItem deleteACow = new JMenuItem("Delete A Animal");
        animal_operations.add(deleteACow);

        JMenuItem viewCowDetails = new JMenuItem("View Animal Details");
        animal_operations.add(viewCowDetails);

        // Creates a JMenu for vet operations
        JMenu vet_menu = new JMenu("Employee Operations");
        menuBar.add(vet_menu);

        JMenuItem addANewVeterinary = new JMenuItem("Add A New Veterinary or FarmWorker" + "See The List Of Employee");
        vet_menu.add(addANewVeterinary);

        JMenuItem deleteAVeterinary = new JMenuItem("Delete A Employee");
        vet_menu.add(deleteAVeterinary);

        JMenuItem viewVeterinaryDetails = new JMenuItem("View An Employee Details");
        vet_menu.add(viewVeterinaryDetails);

        // Creates a JMenu for treatment
        JMenu AddATreatment = new JMenu("Treatment Operations");
        menuBar.add(AddATreatment);

        JMenuItem AddATreatmentt = new JMenuItem("Add A Treatment");
        AddATreatment.add(AddATreatmentt);

        JMenuItem seeAllTheTreatments = new JMenuItem("See Treatments");
        AddATreatment.add(seeAllTheTreatments);

        // Creates a JMenu for Milking Operations
        JMenu MilkingMeasurement = new JMenu("Milking Operations");
        menuBar.add(MilkingMeasurement);

        JMenuItem addMilkingMeasurement = new JMenuItem("Add Milking Measurement");
        MilkingMeasurement.add(addMilkingMeasurement);

        // Creates a JMenu for FeedingAnimalPanel
        JMenu feeding_Animal = new JMenu("Feeding");
        menuBar.add(feeding_Animal);

        JMenuItem feedingAnimal = new JMenuItem("Feeding Of Animal");
        feeding_Animal.add(feedingAnimal);

        // Creates a JMenu for employeeSalary
        JMenu employeeOperations = new JMenu("Employee Operations");
        menuBar.add(employeeOperations);

        JMenuItem employeeSalary = new JMenuItem("Employee Salary");
        employeeOperations.add(employeeSalary);

        JMenuItem employeeCompare = new JMenuItem("Employee Compare");
        employeeOperations.add(employeeCompare);

    /** Adds an ActionListener to the SaveToMyFilebtn button.
     * When the button is clicked, a JFileChooser dialog is displayed, allowing the user to choose a file to save to.
     * If the user selects a file and clicks "Save", the code will attempt to save the Animal and Employee ArrayLists to the file in binary form.*/
    SaveToMyFilebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Creates a JFileChooser
                JFileChooser fileChooser = new JFileChooser();

                // Sets the file selection mode to files only
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                // Sets the file filter to allow only .bin files
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Binary files", "bin");
                fileChooser.setFileFilter(filter);

                // Sets the dialog title
                fileChooser.setDialogTitle("Save File");

                // Shows the save dialog and get the user's selection
                int userSelection = fileChooser.showSaveDialog(null);
                // If the user selected a file, save the information to the file
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    saveButton.setEnabled(true);//save recent data to data.bin file to save selected file
                    writeObjectsToMyFile(file);
                }
            }
        });


        readEmployeesFromDB();
        readAnimalsFromDB();
        listAnimals();
        listEmployees();

        SaveToMyFilePanel.setVisible(true);
        AddANewSheepPanel.setVisible(false);
        CompareWorkersPanel.setVisible(false);
        EmployeeSalaryPanel.setVisible(false);
        FeedingAnimalPanel.setVisible(false);
        AddMilkingMeasurementPanel.setVisible(false);
        ViewEmployeeDetailsPanel.setVisible(false);
        DeleteAAnimalPanel.setVisible(false);
        ViewAnimalDetailsPanel.setVisible(false);
        AddANewVeterinaryPanel.setVisible(false);
        DeleteAEmployeePanel.setVisible(false);
        AddATreatmentPanel.setVisible(false);
        SeeAllTheTreatmentsPanel.setVisible(false);
        AddANewCowPanel.setVisible(false);

        class MenuListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addANewCow) {
                    AddANewSheepPanel.setVisible(false);
                    CompareWorkersPanel.setVisible(false);
                    EmployeeSalaryPanel.setVisible(false);
                    FeedingAnimalPanel.setVisible(false);
                    AddMilkingMeasurementPanel.setVisible(false);
                    ViewEmployeeDetailsPanel.setVisible(false);
                    DeleteAAnimalPanel.setVisible(false);
                    ViewAnimalDetailsPanel.setVisible(false);
                    AddANewVeterinaryPanel.setVisible(false);
                    DeleteAEmployeePanel.setVisible(false);
                    AddATreatmentPanel.setVisible(false);
                    SeeAllTheTreatmentsPanel.setVisible(false);
                    AddANewCowPanel.setVisible(true);
                } else if (e.getSource() == deleteACow) {
                    AddANewSheepPanel.setVisible(false);
                    CompareWorkersPanel.setVisible(false);
                    EmployeeSalaryPanel.setVisible(false);
                    FeedingAnimalPanel.setVisible(false);
                    AddMilkingMeasurementPanel.setVisible(false);
                    ViewEmployeeDetailsPanel.setVisible(false);
                    AddANewCowPanel.setVisible(false);
                    ViewAnimalDetailsPanel.setVisible(false);
                    AddANewVeterinaryPanel.setVisible(false);
                    DeleteAEmployeePanel.setVisible(false);
                    AddATreatmentPanel.setVisible(false);
                    SeeAllTheTreatmentsPanel.setVisible(false);
                    DeleteAAnimalPanel.setVisible(true);
                } else if (e.getSource() == viewCowDetails) {
                    AddANewSheepPanel.setVisible(false);
                    CompareWorkersPanel.setVisible(false);
                    EmployeeSalaryPanel.setVisible(false);
                    FeedingAnimalPanel.setVisible(false);
                    AddMilkingMeasurementPanel.setVisible(false);
                    ViewEmployeeDetailsPanel.setVisible(false);
                    AddANewCowPanel.setVisible(false);
                    DeleteAAnimalPanel.setVisible(false);
                    AddANewVeterinaryPanel.setVisible(false);
                    DeleteAEmployeePanel.setVisible(false);
                    AddATreatmentPanel.setVisible(false);
                    SeeAllTheTreatmentsPanel.setVisible(false);
                    ViewAnimalDetailsPanel.setVisible(true);
                } else if (e.getSource() == addANewVeterinary) {
                    AddANewSheepPanel.setVisible(false);
                    CompareWorkersPanel.setVisible(false);
                    EmployeeSalaryPanel.setVisible(false);
                    FeedingAnimalPanel.setVisible(false);
                    AddMilkingMeasurementPanel.setVisible(false);
                    ViewEmployeeDetailsPanel.setVisible(false);
                    AddANewCowPanel.setVisible(false);
                    DeleteAAnimalPanel.setVisible(false);
                    ViewAnimalDetailsPanel.setVisible(false);
                    DeleteAEmployeePanel.setVisible(false);
                    AddATreatmentPanel.setVisible(false);
                    SeeAllTheTreatmentsPanel.setVisible(false);
                    AddANewVeterinaryPanel.setVisible(true);
                } else if (e.getSource() == deleteAVeterinary) {
                    AddANewSheepPanel.setVisible(false);
                    CompareWorkersPanel.setVisible(false);
                    EmployeeSalaryPanel.setVisible(false);
                    FeedingAnimalPanel.setVisible(false);
                    AddMilkingMeasurementPanel.setVisible(false);
                    ViewEmployeeDetailsPanel.setVisible(false);
                    AddANewCowPanel.setVisible(false);
                    DeleteAAnimalPanel.setVisible(false);
                    ViewAnimalDetailsPanel.setVisible(false);
                    AddANewVeterinaryPanel.setVisible(false);
                    AddATreatmentPanel.setVisible(false);
                    SeeAllTheTreatmentsPanel.setVisible(false);
                    DeleteAEmployeePanel.setVisible(true);
                } else if (e.getSource() == viewVeterinaryDetails) {
                    AddANewSheepPanel.setVisible(false);
                    CompareWorkersPanel.setVisible(false);
                    EmployeeSalaryPanel.setVisible(false);
                    FeedingAnimalPanel.setVisible(false);
                    AddMilkingMeasurementPanel.setVisible(false);
                    AddANewCowPanel.setVisible(false);
                    DeleteAAnimalPanel.setVisible(false);
                    ViewAnimalDetailsPanel.setVisible(false);
                    AddANewVeterinaryPanel.setVisible(false);
                    AddATreatmentPanel.setVisible(false);
                    DeleteAEmployeePanel.setVisible(false);
                    SeeAllTheTreatmentsPanel.setVisible(false);
                    ViewEmployeeDetailsPanel.setVisible(true);
                } else if (e.getSource() == AddATreatmentt) {
                    AddANewSheepPanel.setVisible(false);
                    CompareWorkersPanel.setVisible(false);
                    EmployeeSalaryPanel.setVisible(false);
                    FeedingAnimalPanel.setVisible(false);
                    AddMilkingMeasurementPanel.setVisible(false);
                    ViewEmployeeDetailsPanel.setVisible(false);
                    AddANewCowPanel.setVisible(false);
                    DeleteAAnimalPanel.setVisible(false);
                    ViewAnimalDetailsPanel.setVisible(false);
                    AddANewVeterinaryPanel.setVisible(false);
                    DeleteAEmployeePanel.setVisible(false);
                    SeeAllTheTreatmentsPanel.setVisible(false);
                    AddATreatmentPanel.setVisible(true);
                } else if (e.getSource() == seeAllTheTreatments) {
                    AddANewSheepPanel.setVisible(false);
                    CompareWorkersPanel.setVisible(false);
                    EmployeeSalaryPanel.setVisible(false);
                    FeedingAnimalPanel.setVisible(false);
                    AddMilkingMeasurementPanel.setVisible(false);
                    ViewEmployeeDetailsPanel.setVisible(false);
                    AddANewCowPanel.setVisible(false);
                    DeleteAAnimalPanel.setVisible(false);
                    ViewAnimalDetailsPanel.setVisible(false);
                    AddANewVeterinaryPanel.setVisible(false);
                    DeleteAEmployeePanel.setVisible(false);
                    AddATreatmentPanel.setVisible(false);
                    SeeAllTheTreatmentsPanel.setVisible(true);
                } else if (e.getSource() == addMilkingMeasurement) {
                    AddANewSheepPanel.setVisible(false);
                    CompareWorkersPanel.setVisible(false);
                    EmployeeSalaryPanel.setVisible(false);
                    FeedingAnimalPanel.setVisible(false);
                    ViewEmployeeDetailsPanel.setVisible(false);
                    AddANewCowPanel.setVisible(false);
                    DeleteAAnimalPanel.setVisible(false);
                    ViewAnimalDetailsPanel.setVisible(false);
                    AddANewVeterinaryPanel.setVisible(false);
                    DeleteAEmployeePanel.setVisible(false);
                    AddATreatmentPanel.setVisible(false);
                    SeeAllTheTreatmentsPanel.setVisible(false);
                    AddMilkingMeasurementPanel.setVisible(true);
                } else if (e.getSource() == feedingAnimal) {
                    AddANewSheepPanel.setVisible(false);
                    CompareWorkersPanel.setVisible(false);
                    EmployeeSalaryPanel.setVisible(false);
                    ViewEmployeeDetailsPanel.setVisible(false);
                    AddANewCowPanel.setVisible(false);
                    DeleteAAnimalPanel.setVisible(false);
                    ViewAnimalDetailsPanel.setVisible(false);
                    AddANewVeterinaryPanel.setVisible(false);
                    DeleteAEmployeePanel.setVisible(false);
                    AddATreatmentPanel.setVisible(false);
                    SeeAllTheTreatmentsPanel.setVisible(false);
                    AddMilkingMeasurementPanel.setVisible(false);
                    FeedingAnimalPanel.setVisible(true);
                } else if (e.getSource() == employeeSalary) {
                    AddANewSheepPanel.setVisible(false);
                    CompareWorkersPanel.setVisible(false);
                    ViewEmployeeDetailsPanel.setVisible(false);
                    AddANewCowPanel.setVisible(false);
                    DeleteAAnimalPanel.setVisible(false);
                    ViewAnimalDetailsPanel.setVisible(false);
                    AddANewVeterinaryPanel.setVisible(false);
                    DeleteAEmployeePanel.setVisible(false);
                    AddATreatmentPanel.setVisible(false);
                    SeeAllTheTreatmentsPanel.setVisible(false);
                    AddMilkingMeasurementPanel.setVisible(false);
                    FeedingAnimalPanel.setVisible(false);
                    EmployeeSalaryPanel.setVisible(true);
                } else if (e.getSource() == employeeCompare) {
                    AddANewSheepPanel.setVisible(false);
                    ViewEmployeeDetailsPanel.setVisible(false);
                    AddANewCowPanel.setVisible(false);
                    DeleteAAnimalPanel.setVisible(false);
                    ViewAnimalDetailsPanel.setVisible(false);
                    AddANewVeterinaryPanel.setVisible(false);
                    DeleteAEmployeePanel.setVisible(false);
                    AddATreatmentPanel.setVisible(false);
                    SeeAllTheTreatmentsPanel.setVisible(false);
                    AddMilkingMeasurementPanel.setVisible(false);
                    FeedingAnimalPanel.setVisible(false);
                    EmployeeSalaryPanel.setVisible(false);
                    CompareWorkersPanel.setVisible(true);
                }else if (e.getSource() == addANewSheep) {
                    ViewEmployeeDetailsPanel.setVisible(false);
                    AddANewCowPanel.setVisible(false);
                    DeleteAAnimalPanel.setVisible(false);
                    ViewAnimalDetailsPanel.setVisible(false);
                    AddANewVeterinaryPanel.setVisible(false);
                    DeleteAEmployeePanel.setVisible(false);
                    AddATreatmentPanel.setVisible(false);
                    SeeAllTheTreatmentsPanel.setVisible(false);
                    AddMilkingMeasurementPanel.setVisible(false);
                    FeedingAnimalPanel.setVisible(false);
                    EmployeeSalaryPanel.setVisible(false);
                    CompareWorkersPanel.setVisible(false);
                    AddANewSheepPanel.setVisible(true);
                }

            }
        }

        addANewCow.addActionListener(new MenuListener());
        deleteACow.addActionListener(new MenuListener());
        viewCowDetails.addActionListener(new MenuListener());
        addANewVeterinary.addActionListener(new MenuListener());
        deleteAVeterinary.addActionListener(new MenuListener());
        viewVeterinaryDetails.addActionListener(new MenuListener());
        AddATreatmentt.addActionListener(new MenuListener());
        seeAllTheTreatments.addActionListener(new MenuListener());
        addMilkingMeasurement.addActionListener(new MenuListener());
        feedingAnimal.addActionListener(new MenuListener());
        employeeSalary.addActionListener(new MenuListener());
        employeeCompare.addActionListener(new MenuListener());
        addANewSheep.addActionListener(new MenuListener());

    }

    /**
     * Constructor for a FarmMe object that has some Animal but no Employee yet
     * @param animals This is the parameter that will be set
     */
    public FarmApp(ArrayList<Animal> animals) throws IOException, SQLException {
        this.animals = animals;
        this.employees = new ArrayList<>();
    }
    /**
     * Returns the list of the employees
     * @return the list of the employees
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * Returns the list of the Animal
     * @return the list of the Animal
     */
    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    /**
     * Sets the list of Animals
     * @param animals This is the parameter that will be set
     */
    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    /**
     * Sets the list of employees
     * @param employees This is the parameter that will be set
     */
    public void setVets(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    /**
     * Write the Animal and Employee ArrayLists to the specified file in binary form.
     * @param file the File to write the ArrayLists
     */
    public void writeObjectsToMyFile(File file) {
        {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = new FileInputStream("data.bin");
                out = new FileOutputStream(file);

                int b;
                while ((b = in.read()) != -1) {
                    out.write(b);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

     /** Serializes the list of Animal objects to a file "animal_data.bin"
      * and calculates the MD5 message digest for the serialized objects. The
      * message digest is written to a file called "test_md5.txt". */
    public void writeObjectsToFile() {
        try {
            // Serialize the Animal objects to an external file
            FileOutputStream fos = new FileOutputStream("animal_data.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(animals);

            // Calculate the MD5 message digest for the serialized objects
            FileInputStream fis = new FileInputStream("animal_data.bin");
            BufferedInputStream biss = new BufferedInputStream(fis);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int ch;
            while ((ch = biss.read()) != -1) {
                baos.write(ch);
            }
            byte[] buffer = baos.toByteArray();

            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(buffer);
            byte[] digest = algorithm.digest();

            // Write the message digest to a file
            FileOutputStream fileOutputStream = new FileOutputStream("test_md5.txt");
            fileOutputStream.write(digest);
            fileOutputStream.close();
            fos.close();
            biss.close();
            oos.close();


        } catch (IOException | NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }


    /**
     * Verifies the integrity of the serialized objects of file "animal_data.bin" by comparing
     * its calculated MD5 message digest to the stored message digest in "test_md5.txt".
     * Displays a message dialog indicating whether the data has been modified or not.
     */
    public void checkAnimalData() throws NoSuchAlgorithmException, IOException, ClassNotFoundException {
        // Calculating the MD5 message digest for the serialized objects file
        FileInputStream fis = null;
        try{
         fis = new FileInputStream("animal_data.bin");
        }catch (FileNotFoundException fileNotFoundException){
            JOptionPane.showMessageDialog(null, "animal_data.bin file couldn't found! Will be created on closing the app.", "Info", JOptionPane.INFORMATION_MESSAGE);
            // Create "test_md5.txt" if it does not exist
            File testMD5File = new File("test_md5.txt");
            if (!testMD5File.exists()) {
                JOptionPane.showMessageDialog(null, "test_md5.txt file couldn't found! Will be created on closing the app.", "Info", JOptionPane.INFORMATION_MESSAGE);
                testMD5File.createNewFile();
            }
        }

        // Reopen the BufferedInputStream
        BufferedInputStream bis = new BufferedInputStream(fis);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int ch;

        while ((ch = bis.read()) != -1) {
            baos.write(ch);
        }
        byte[] buffer = baos.toByteArray();

        // Get a MessageDigest for the appropriate algorithm.
        MessageDigest algorithm = MessageDigest.getInstance("MD5");

        // Ensure the digest's buffer is empty.
        algorithm.reset();

        // Fill the digest's buffer with data to compute a message digest from.
        algorithm.update(buffer);

        // Generate the digest. This does any necessary padding required by the
        // algorithm.
        byte[] digest = algorithm.digest();

        // Convert the message digest to a hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte value : digest) {
            hexString.append(Integer.toHexString(0xFF & value));
            hexString.append(" ");
        }
        String calculatedDigest = hexString.toString();

        // Create "test_md5.txt" if it does not exist
        File testMD5File = new File("test_md5.txt");
        if (!testMD5File.exists()) {
            JOptionPane.showMessageDialog(null, "test_md5.txt file couldn't found! Will be created on closing the app.", "Info", JOptionPane.INFORMATION_MESSAGE);
            testMD5File.createNewFile();
        }

        else { // If "test_md5.txt" exists
            // Reading the stored message digest from the file
            fis = new FileInputStream("test_md5.txt");
            byte[] storedDigest = new byte[fis.available()];
            fis.read(storedDigest);
            fis.close();

            // Converting the stored message digest to a hexadecimal string
            hexString = new StringBuilder();
            for (byte b : storedDigest) {
                hexString.append(Integer.toHexString(0xFF & b));
                hexString.append(" ");
            }
            String storedDigestString = hexString.toString();

            // Comparing the calculated and stored message digests
            if (calculatedDigest.equals(storedDigestString)) {
                JOptionPane.showMessageDialog(null, "Data is not modified.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Data has been modified!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }



    /**
     * This method displays the user interaction menu to the user
     * It allows user to execute operations from the interaction menu by entering an input
     * All the action listeneres are defined in this function.
     **/
    public void menu() {

        /** Sets the action listener for the addTheCowButton
         * calls addCow(); and updates list by calling  listAnimals(); */
        addTheCowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCow();
                listOfCows.setText("");// Clear the JTextArea
                listAnimals();
            }
        });

        /**Sets the action listener for the deleteTheCowButton
         * deleteAnimal(tagNo); and updates list by calling  listAnimals(); */
        deleteTheCowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the tag number from the JFormattedTextField
                int tagNo = 0;
                try {
                    // convert the text field value to an integer
                    tagNo = Integer.parseInt(tagNoField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid tag number", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                deleteAnimal(tagNo);
                listOfCows.setText("");// Clear the JTextArea
                listAnimals();
            }
        });

        /**
         * Adds an ActionListener to the seeCowDetailsButton.
         * When the button is clicked, the getAnimalDetails method is called with the tag number entered in the getCowDetailsTagField JFormattedTextField.
         */
        seeCowDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the tag number from the JFormattedTextField
                int tagNo = 0;
                try {
                    // convert the text field value to an integer
                    tagNo = Integer.parseInt(getCowDetailsTagField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid tag number", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                getAnimalDetails(tagNo);
            }
        });

        /**
         * Adds an ActionListener to the AddTheVetButton.
         * When the button is clicked, the addVet method is called to add a new veterinary or farm worker to the list of employees.
         * The listofVets JTextArea is then cleared and the listEmployees method is called to update the list of employees.
         */
        AddTheVetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addVet();
                listofVets.setText("");// Clear the JTextArea
                listEmployees();
            }
        });

    /**
     * Adds an ActionListener to the deleteAVetBtn.
     * When the button is clicked, the deleteEmployee method is calledwith the vetID entered in the deleteAVetField JFormattedTextField.
     * The listofVets JTextArea is then cleared and the listEmployees method is called to update the list of employees.
     */
        deleteAVetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the tag number from the JFormattedTextField
                int vetID = 0;
                try {
                    // convert the text field value to an integer
                    vetID = Integer.parseInt(deleteAVetField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid vetID ", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                deleteEmployee(vetID);
                listofVets.setText("");// Clear the JTextArea
                listEmployees();
            }
        });

        /** Adds an ActionListener to the veterinaryDetailsSeeBtn.
         * When the button is clicked, the getEmployeeDetails method is called with the vetID entered in the veterinaryDetailsIDField JFormattedTextField.
         */
        veterinaryDetailsSeeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the vet ID from the JFormattedTextField
                int vetID = 0;
                try {
                    // convert the text field value to an integer
                    vetID = Integer.parseInt(veterinaryDetailsIDField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid tag number", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                getEmployeeDetails(vetID);
            }
        });

        /**
         * Adds an ActionListener to the addTheTreatmentButton.
         * When the button is clicked, the addTreatment method is called to add a new treatment to the list of treatments.
         */
        addTheTreatmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int vetID = 0;
                int tagNo = 0;
                try {
                    // convert the text field value to an integer
                    tagNo = Integer.parseInt(tagnoFieldAddTreatment.getText());
                    vetID = Integer.parseInt(IDFieldAddTreatment.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid tag number or ID", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                addTreatment(vetID, tagNo);
            }
        });

        addANewHealthJPanel.setVisible(true);
        addANewCleaningPanel.setVisible(false);

        /**
         * Add an ActionListener to the TreatmentTypeComboBox.
         * When a different item is selected in the combo box, the treatmentTypeSelected method is called to update the selected treatment type.
         */
        TreatmentTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int SelectedIndex = TreatmentTypeComboBox.getSelectedIndex();

                if (SelectedIndex == 0) {//health treatment selected disable unrelated entries
                    addANewHealthJPanel.setVisible(true);
                    addANewCleaningPanel.setVisible(false);
                } else if (SelectedIndex == 1) {//cleaning treatment selected disable unrelated entries
                    addANewCleaningPanel.setVisible(true);
                    addANewHealthJPanel.setVisible(false);
                }
            }
        });

        /**
         * Adds an ActionListener to the showTreatmentListButton.
         * getAnimalTreatment(tagNo) method called on action
         */
        showTreatmentListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tagNo = 0;
                try {
                    // convert the text field value to an integer
                    tagNo = Integer.parseInt(textFieldTagTreat.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid tag number", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                getAnimalTreatment(tagNo);
            }
        });

        /**
         * Adds an ActionListener to the tableTreatmentsDateBtn.
         * getAnimalTreatment(tagNo, new_date); method called on action
         */
        tableTreatmentsDateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tagNo = 0;
                LocalDate new_date = LocalDate.now();
                String str_dateO = tableTreatmentsDateField.getText();
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                // Date syntax control
                try {//throws an exception if the format is wrong
                    new_date = LocalDate.parse(str_dateO, dateFormatter);
                } catch (DateTimeParseException ecx) {
                    JOptionPane.showMessageDialog(null, "Enter date in the correct format: 'dd/mm/yyyy'", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    // converts the text field value to an integer
                    tagNo = Integer.parseInt(textFieldTagTreat.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid tag number", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                getAnimalTreatment(tagNo, new_date);
            }
        });

        /**
         * Adds an ActionListener to the addTheMilkingRecordButton.
         * addMilkingMeasurement(tagNo, amount); method called on action
         */
        addTheMilkingRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tagNo = 0;
                double amount = 0.0;
                try {
                    amount = Double.parseDouble(AmountField.getText());
                } catch (NumberFormatException exc) {
                    JOptionPane.showMessageDialog(null, "Invalid input for amount. Please enter a valid number.");
                    return;
                }

                try {
                    // convert the text field value to an integer
                    tagNo = Integer.parseInt(TagNoMilk.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid tag number", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                addMilkingMeasurement(tagNo, amount);
            }
        });

        /**
         * Adds an ActionListener to the showFeedingOfAnimalButton.
         * feedingAnimal(tagNo) method called on action
         */
        showFeedingOfAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tagNo = 0;
                try {
                    // convert the text field value to an integer
                    tagNo = Integer.parseInt(TagFeedingField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid tag number", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                feedingTable.setVisible(true);
                feedingAnimal(tagNo);
            }
        });

        /**
         * Adds an ActionListener to the showTheSalaryButton.
         * getEmpSalary(empID); method called on action
         */
        showTheSalaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int empID = 0;
                try {
                    // convert the text field value to an integer
                    empID = Integer.parseInt(EmployeeIDFieldSalary.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid empID", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                double salary = getEmpSalary(empID);
                String salaryStr = String.valueOf(salary);
                textAreaSalary.setText(salaryStr);
            }
        });

        /**
         * Adds an ActionListener to the compreFarmworkersButton.
         * compareFarmWorkers(); method called on action
         */
        compreFarmworkersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compareFarmWorkers();
            }
        });

        /**
         * Adds an ActionListener to the compareVeterinariesButton.
         * compareVets(); method called on action
         */
        compareVeterinariesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compareVets();
            }
        });

        /**
         * Adds an ActionListener to the addTheSheepBtn.
         * listAnimals(); and addSheep(); method called on action
         */
        addTheSheepBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSheep();
                listOfCows.setText("");// Clear the JTextArea
                listAnimals();
            }
        });

        /**
         * Adds an ActionListener to the addFarmWorkerBtn.
         * addFarmworker(); and listEmployees(); method called on action
         */
        addFarmWorkerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFarmworker();
                listofVets.setText("");// Clear the JTextArea
                listEmployees();
            }
        });
    }

    /**
     * This method adds a new cow to the list of cows maintained
     * Each cow needs to have unique tag number, the gender specified as either male or female, the date of birth will be recorded
     * and also whether the cow is purchased or whether it is farm-raising and its weight is recorded
     * Also creates an empty milking HashMap by calling the corresponding constructor of the Cow class
     */
    public void addCow() {
        int new_tagNo = 0;
        try {
            // convert the text field value to an integer
            new_tagNo = Integer.parseInt(tagnoFieldAddCow.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid tag number", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Tag number control loop to prevent duplicate tag numbers
        int i;
        if (!(animals.isEmpty())) { //if list is empty no need to check for the copy of the tag number
            for (i = 0; i < animals.size(); i++) {//checking the whole list of animals to find a duplicate tagNo
                if (animals.get(i).getTagNo() == new_tagNo) {
                    JOptionPane.showMessageDialog(null, "Tag number already exist!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
        String new_gender = "";
        // Gender syntax control loop
        if (GendercomboBox.getSelectedIndex() == 0) {
            new_gender = "male";
        } else if (GendercomboBox.getSelectedIndex() == 1) {
            new_gender = "female";
        }
        boolean new_purchased = false;
        // Raising Type syntax control loop
        if (RaisingTypecomboBox.getSelectedIndex() == 0) {
            new_purchased = false;
        } else if (RaisingTypecomboBox.getSelectedIndex() == 1) {
            new_purchased = true;
        }

        LocalDate new_dateOfBirth = LocalDate.now();
        String str_dateOfBirth = DateOfBirthTextFieldAddCow.getText();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Date syntax control
        try {//throws an exception if the format is wrong
            new_dateOfBirth = LocalDate.parse(str_dateOfBirth, dateFormatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Enter date in the correct format: 'dd/mm/yyyy'", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }


        // Weight syntax control
        int new_weight = 0;
        try {
            // convert the text field value to an integer
            new_weight = Integer.parseInt(weightTextField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid weight", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // This specific constructor of Cow creates empty milking HashMap and ArrayList of treatments
        Cow newcow = new Cow(new_tagNo, new_gender, new_dateOfBirth, new_purchased, new_weight);//a new cow is created
        animals.add(newcow);//adding new cow to the list of animals
        JOptionPane.showMessageDialog(null, "Cow with the tag no " + new_tagNo + " has added to the list of animals.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * This method adds a new sheep to the list of animals maintained
     * Each sheep needs to have unique tag number, the gender specified as either male or female, the date of birth will be recorded
     * and also whether the cow is purchased or whether it is farm-raising and its weight is recorded
     * Also creates an empty milking HashMap by calling the corresponding constructor of the sheep class
     */
    public void addSheep() {
        int new_tagNo = 0;
        try {
            // convert the text field value to an integer
            new_tagNo = Integer.parseInt(addSheepTagNoField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid tag number", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Tag number control loop to prevent duplicate tag numbers
        int i;
        if (!(animals.isEmpty())) { //if list is empty no need to check for the copy of the tag number
            for (i = 0; i < animals.size(); i++) {//checking the whole list of animals to find a duplicate tagNo
                if (animals.get(i).getTagNo() == new_tagNo) {
                    JOptionPane.showMessageDialog(null, "Tag number already exist!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
        String new_gender = "";
        // Gender syntax control loop
        if (addSheepGenderBox.getSelectedIndex() == 0) {
            new_gender = "male";
        } else if (addSheepGenderBox.getSelectedIndex() == 1) {
            new_gender = "female";
        }
        boolean new_purchased = false;
        // Raising Typecom syntax control loop
        if (raisingtypeSheepbox.getSelectedIndex() == 0) {
            new_purchased = false;
        } else if (raisingtypeSheepbox.getSelectedIndex() == 1) {
            new_purchased = true;
        }

        LocalDate new_dateOfBirth = LocalDate.now();
        String str_dateOfBirth = DBOShepField.getText();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Date syntax control
        try {//throws an exception if the format is wrong
            new_dateOfBirth = LocalDate.parse(str_dateOfBirth, dateFormatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Enter date in the correct format: 'dd/mm/yyyy'", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // This specific constructor of Cow creates empty milking HashMap and ArrayList of treatments
        Sheep sheep = new Sheep(new_tagNo, new_gender, new_dateOfBirth, new_purchased);//a new cow is created
        animals.add(sheep);//adding new cow to the list of animals
        JOptionPane.showMessageDialog(null, "Sheep with the tag no " + new_tagNo + " has added to the list of animals.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method reads a tag number of a animal, and delete the corresponding animal object.
     * If the tag number does not exist, the program provides an appropriate error message.
     * @param tagNo This is the parameter that will be taken to delete a cow form the list of animals
     */
    public void deleteAnimal(int tagNo) {
        int i, notExist;
        notExist = 0;
        if (!(animals.isEmpty())) { //handling empty list error
            for (i = 0; i < animals.size(); i++) {//checking the whole list of animal to find the cow with the tagNo
                if (animals.get(i).getTagNo() == tagNo && animals.get(i) instanceof Cow ||animals.get(i).getTagNo() == tagNo && animals.get(i) instanceof Sheep ) {
                    animals.removeIf(cow -> (cow.getTagNo() == tagNo));//removing the animal with the entered tagNo
                    animals.removeIf(sheep -> (sheep.getTagNo() == tagNo));//removing the animal with the entered tagNo
                    JOptionPane.showMessageDialog(null, "Animal with the tag number " + tagNo + " deleted successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    i = animals.size();//to exit the loop
                    notExist = 1;
                }
            }
            if (notExist == 0) {
                JOptionPane.showMessageDialog(null, "Animal with this tag number doesn't exist!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } else//list is empty
            JOptionPane.showMessageDialog(null, "List is empty! No animals are added yet.", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Given a tag number, this method displays the Animal details.
     * If the tag number does not exist, the program will provide an appropriate error message.
     * @param tagNo This is the parameter that will be taken to get a cow form the list of Animals to show details
     */
    public void getAnimalDetails(int tagNo) {
        getCowDetailsTextFieldTextArea.setText("");
        int i, notExist;
        notExist = 0;
        if (!(animals.isEmpty())) { //handling empty list error
            for (i = 0; i < animals.size(); i++) {//checking the whole list of animals to find the Animal with the tagNo
                if (animals.get(i).getTagNo() == tagNo && animals.get(i) instanceof Cow || animals.get(i).getTagNo() == tagNo && animals.get(i) instanceof Sheep) {
                    if (animals.get(i).getClass() == Cow.class) {
                        getCowDetailsTextFieldTextArea.append("---Cow details---\nTag no: " + animals.get(i).getTagNo()
                                + "\nGender: " + animals.get(i).getGender()
                                + "\nDate of birth: " + animals.get(i).getDateOfBirth()
                                + "\nAge of the cow: " + animals.get(i).getAge()
                                + "\nMilking records of the animal: ");
                    }
                    if (animals.get(i).getClass() == Sheep.class) {
                        getCowDetailsTextFieldTextArea.append("---Sheep details---\nTag no: " + animals.get(i).getTagNo()
                                + "\nGender: " + animals.get(i).getGender()
                                + "\nDate of birth: " + animals.get(i).getDateOfBirth()
                                + "\nAge of the sheep: " + animals.get(i).getAge()
                                + "\nMilking records of the animal: ");
                    }
                    for (HashMap.Entry<LocalDate, Double> dt : animals.get(i).getMilking().entrySet()) {//printing milking HashMap
                        getCowDetailsTextFieldTextArea.append("\nMilking date: " + dt.getKey() + " milking amount: " + dt.getValue() + "\n");
                    }
                    if (animals.get(i).getClass() == Cow.class) {
                        Cow cow = (Cow) animals.get(i);
                        double weight = cow.getWeight();
                        getCowDetailsTextFieldTextArea.append("\nCow weight: "+ weight +"\n");
                    }
                    if (animals.get(i).getPurchased()) //if returns true this means cow is purchased
                        getCowDetailsTextFieldTextArea.append("\nAnimal is purchased\n");
                    else
                        getCowDetailsTextFieldTextArea.append("\nAnimal is farm-raising\n");
                    i = animals.size();//to exit the loop
                    notExist = 1;
                }
            }
            if (notExist == 0) {
                JOptionPane.showMessageDialog(null, "Animal with this tag number doesn't exist!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } else//list is empty
            JOptionPane.showMessageDialog(null, "List is empty! No animals are added yet.", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method adds a new vet to list of vets
     */
    public void addVet() {
        int new_vetID = 0;
        try {
            // convert the text field value to an integer
            new_vetID = Integer.parseInt(EmployeeIDField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //vetID control loop to prevent duplicate IDs
        int i;
        if (!(employees.isEmpty())) { //if list is empty no need to check for the copy of the ID
            for (i = 0; i < employees.size(); i++) {//checking the whole list of Employees to find the Employee with the EmployeeID
                if (employees.get(i).getEmpID() == new_vetID) {
                    JOptionPane.showMessageDialog(null, "EmployeeID already exist!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }

        String new_gender = "";
        // Gender syntax control loop
        if (VetGenderCombobox.getSelectedIndex() == 0) {
            new_gender = "male";
        } else if (VetGenderCombobox.getSelectedIndex() == 1) {
            new_gender = "female";
        }



        LocalDate new_dateOfBirth = LocalDate.now();
        String str_dateOfBirth = VetDateofbirthField.getText();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            new_dateOfBirth = LocalDate.parse(str_dateOfBirth, dateFormatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Enter date in the correct format: 'dd/mm/yyyy'", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }


        boolean new_BScDegree = false;
        if (BScDegree.getSelectedIndex() == 0) {
            new_BScDegree = true;
        } else if (BScDegree.getSelectedIndex() == 1) {
            new_BScDegree = false;
        }

        LocalDate new_dateOfGraduation = LocalDate.now();
        String str_dateOfGraduation = DateofgraduationField.getText();
        dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            new_dateOfGraduation = LocalDate.parse(str_dateOfGraduation, dateFormatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Enter date in the correct format: 'dd/mm/yyyy'", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int new_expertiseLevel = 0;
        try {
            // convert the text field value to an integer
            new_expertiseLevel = Integer.parseInt(ExpertiselevelField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid expertise vevel", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Veterinary newVet = new Veterinary(new_vetID, new_gender, new_dateOfBirth, new_BScDegree, new_dateOfGraduation, new_expertiseLevel);//a new Veterinary is created
        employees.add(newVet);//adding new Veterinary to the list of employees
        JOptionPane.showMessageDialog(null, "Veterinary with the ID: " + new_vetID + " has added to the list.", "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * This method adds a new vet to list of vets
     */
    public void addFarmworker() {
        int new_vetID = 0;
        try {
            // convert the text field value to an integer
            new_vetID = Integer.parseInt(empIdFieldWorker.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //vetID control loop to prevent duplicate IDs
        int i;
        if (!(employees.isEmpty())) { //if list is empty no need to check for the copy of the ID
            for (i = 0; i < employees.size(); i++) {//checking the whole list of Employees to find the Employee with the EmployeeID
                if (employees.get(i).getEmpID() == new_vetID) {
                    JOptionPane.showMessageDialog(null, "EmployeeID already exist!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }

        String new_gender = "";
        // Gender syntax control loop
        if (genderFieldWorker.getSelectedIndex() == 0) {
            new_gender = "male";
        } else if (genderFieldWorker.getSelectedIndex() == 1) {
            new_gender = "female";
        }


        LocalDate new_dateOfBirth = LocalDate.now();
        String str_dateOfBirth = DBOWorkerField.getText();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            new_dateOfBirth = LocalDate.parse(str_dateOfBirth, dateFormatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Enter date in the correct format: 'dd/mm/yyyy'", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }


        int new_expertiseLevel = 0;
        try {
            // convert the text field value to an integer
            new_expertiseLevel = Integer.parseInt(workexperienceField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid work experience", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String PreviousFarm = previousFarmNameField.getText();

        FarmWorker newWorker= new FarmWorker(new_vetID, new_gender, new_dateOfBirth, PreviousFarm, new_expertiseLevel);//a new FarmWorker is created
        employees.add(newWorker);//adding newWorker to the list of employees
        JOptionPane.showMessageDialog(null, "FarmWorker with the ID: " + new_vetID + " has added to the list.", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Given a vet ID, this method deletes a vet.
     * If the vetID does not exist, the program provides an appropriate error message.
     *
     * @param vetID This is the parameter that will be taken to get a vet form the list of vets to delete
     */
    public void deleteEmployee(int vetID) {
        int i, notExist;
        notExist = 0;
        if (!(employees.isEmpty())) { //handling empty list error
            for (i = 0; i < employees.size(); i++) {//checking the whole list of Employee to find the Employee with the ID
                if ((employees.get(i).getEmpID() == vetID)) {
                    employees.removeIf(employee -> (employee.getEmpID() == vetID));
                    JOptionPane.showMessageDialog(null, "Employee with the ID " + vetID + " deleted successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    i = employees.size();//to exit the loop
                    notExist = 1;
                }
            }
            if (notExist == 0) {
                JOptionPane.showMessageDialog(null, "Employee with the entered ID doesn't exist!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } else//list is empty
            JOptionPane.showMessageDialog(null, "List is empty! No employees are added yet.", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Given a vetID, this method will display the vet details.
     * If the vetID does not exist, the method should provide an appropriate error message.
     *
     * @param vetID This is the parameter that will be taken to get a vet form the list of vets to show details
     */
    public void getEmployeeDetails(int vetID) {
        veterinaryDetailsTextArea.setText("");
        int i, notExist;
        notExist = 0;
        if (!(employees.isEmpty())) { //handling empty list error
            for (i = 0; i < employees.size(); i++) {
                if ((employees.get(i).getEmpID() == vetID)) {//checking the whole list of Employee to find the Employee with the vetID
                    if (employees.get(i).getClass() == Veterinary.class) {
                    veterinaryDetailsTextArea.setText("---Veterinary details---\nID: " + employees.get(i).getEmpID()
                            + "\nGender: " + employees.get(i).getGender()
                            + "\nDate of birth: " + employees.get(i).getDateOfBirth()
                            + "\nSalary: " + employees.get(i).getSalary()
                            + "\nBScDegree: " + ((Veterinary) employees.get(i)).getBScDegree()
                            + "\nDate of graduation: " + ((Veterinary) employees.get(i)).getDateOfGraduation()
                            + "\nExpertise level: " + ((Veterinary) employees.get(i)).getExpertiseLevel()
                    );
                    }
                    if (employees.get(i).getClass() == FarmWorker.class) {
                        veterinaryDetailsTextArea.setText("---FarmWorker details---\nID: " + employees.get(i).getEmpID()
                                + "\nGender: " + employees.get(i).getGender()
                                + "\nDate of birth: " + employees.get(i).getDateOfBirth()
                                + "\nSalary: " + employees.get(i).getSalary()
                                + "\nPrevious Farm Name: " + ((FarmWorker) employees.get(i)).getPreviousFarmName()
                                + "\nWork experience: " + ((FarmWorker) employees.get(i)).getWorkexperience()
                        );
                    }
                    i = employees.size();//to exit the loop
                    notExist = 1;
                }
            }
            if (notExist == 0) {
                JOptionPane.showMessageDialog(null, "Employee with the entered ID doesn't exist!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } else//list is empty
            JOptionPane.showMessageDialog(null, "List is empty! No Employees are added yet.", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method records the treatment given by a particular vet to a cow with the given tag number.
     * If the vet with the given ID or the cow with the given ID does not exist then the relevant error messages are given.
     * When a treatment is added, the relevant medication is also recorded.
     *
     * @param vetID This is the parameter that will be taken to get a Veterinary form the list of vets to add a treatment
     * @param tagNo This is the parameter that will be taken to get a Cow form the list of cows to add a treatment
     */
    public void addTreatment(int vetID, int tagNo) {
        int i, notExist;
        notExist = 0;
        //finding the animal with the given tag number
        if (!(animals.isEmpty())) { //handling empty list error
            for (i = 0; i < animals.size(); i++) {//checking the whole list of animals to find the animal with the tagNo
                if (animals.get(i).getTagNo() == tagNo) {
                    i = animals.size();//to exit the loop
                    notExist = 1;
                }
            }
            if (notExist == 0) {
                JOptionPane.showMessageDialog(null, "Tag number doesn't exist!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {//list is empty
            JOptionPane.showMessageDialog(null, "List is empty! No animals are added yet.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }

        ArrayList<Treatment> treatments = new ArrayList<>();

        String treatment_type = "";
        if (TreatmentTypeComboBox.getSelectedIndex() == 0) {
            treatment_type = "health";
        } else if (TreatmentTypeComboBox.getSelectedIndex() == 1) {
            treatment_type = "cleaning";
        }

        int control1 = 0;//see the addTreatments method
        if (treatment_type.equals("health")) {//if treatment type is health executes following

            LocalDate new_date = LocalDate.now();
            String new_str_date = HealthTreatmentDate.getText();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                new_date = LocalDate.parse(new_str_date, dateFormatter);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Enter date in the correct format: 'dd/mm/yyyy'", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }


            boolean new_emergency = false;
            if (EmergencyComboBox.getSelectedIndex() == 0) {
                new_emergency = false;
            } else if (EmergencyComboBox.getSelectedIndex() == 1) {
                new_emergency = true;
            }

            ArrayList<Medication> meds;
            meds = create_meds();//returns the list of medications
            Veterinary new_vet = new Veterinary();

            //Finding Veterinary with Employee ID
            notExist = 0;
            if (!(employees.isEmpty())) { //handling empty list error
                for (i = 0; i < employees.size(); i++) {
                    if ((employees.get(i).getEmpID() == vetID) && (employees.get(i) instanceof Veterinary)) {//checking the whole list of vets to find the Veterinary with the vetID
                        new_vet = (Veterinary) employees.get(i);
                        i = employees.size();//to exit the loop
                        notExist = 1;
                    }
                }
                if (notExist == 0) {
                    JOptionPane.showMessageDialog(null, "Veterinary with the entered ID doesn't exist!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            } else//list is empty
            {
                JOptionPane.showMessageDialog(null, "List is empty! No veterinaries are added yet.", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            //creating a treatment
            HealthTreatment treatment = new HealthTreatment(new_date, new_emergency, meds, new_vet);
            treatments.add(treatment);
        } else {//if treatment type is cleaning executes following


            LocalDate new_date = LocalDate.now();
            String new_str_date = CleaningTreatmentDate.getText();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                new_date = LocalDate.parse(new_str_date, dateFormatter);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Enter date in the correct format: 'dd/mm/yyyy'", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            FarmWorker new_FarmWorker = new FarmWorker();

            //Finding FarmWorker with Employee ID
            notExist = 0;
            if (!(employees.isEmpty())) { //handling empty list error
                for (i = 0; i < employees.size(); i++) {
                    if ((employees.get(i).getEmpID() == vetID) && (employees.get(i) instanceof FarmWorker)) {//checking the whole list of FarmWorker to find the FarmWorker with the EmpID
                        new_FarmWorker = (FarmWorker) employees.get(i);
                        i = employees.size();//to exit the loop
                        notExist = 1;
                    }
                }
                if (notExist == 0) {
                    JOptionPane.showMessageDialog(null, "FarmWorker with the entered ID doesn't exist!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            } else//list is empty
            {
                JOptionPane.showMessageDialog(null, "List is empty! No FarmWorker are added yet.", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Taking material used
            String new_materialused = materialUsedField.getText();
            if (new_materialused.isEmpty()) {
                // materialUsedField is empty
                JOptionPane.showMessageDialog(null, "Material used is empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            //creating a CleaningTreatment
            CleaningTreatment treatment = new CleaningTreatment(new_materialused, new_FarmWorker, new_date);
            treatments.add(treatment);
        }
        for (i = 0; i < animals.size(); i++) {
            if (animals.get(i).getTagNo() == tagNo) {
                animals.get(i).addTreatments(treatments);//see the addTreatments method
            }
        }
        JOptionPane.showMessageDialog(null, "Treatment added successfully.", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Given a tag number, this method will return the treatment that has been done to the given cow.
     * If it has multiple treatments all will be returned.
     * If the tag number does not exist, relevant messages are given.
     * @param tagNo This is the parameter that will be taken to get a Cow form the list of cows to show its treatment
     */
    public void getAnimalTreatment(int tagNo) {
        tableTreatments.setText("");
        int i, j, k, notExist, notExistnew;
        notExist = 0;
        notExistnew = 0;
        if (!(animals.isEmpty())) { //handling empty list error
            //Getting Health Treatments
            for (i = 0; i < animals.size(); i++) {//checking the whole list of cows to find the cow with the tagNo
                if (animals.get(i).getTagNo() == tagNo ) {//is there any animal with the given tag no
                    for (j = 0; j < animals.get(i).getTreatments().size(); j++) {
                        if (!(animals.get(i).getTreatments().isEmpty()) && (animals.get(i).getTreatments().get(j) instanceof HealthTreatment)) {//checks if cow has a health treatment or not
                            for (k = 0; k < ((HealthTreatment) animals.get(i).getTreatments().get(j)).getMeds().size(); k++) {
                                tableTreatments.append(
                                        "\n---Health Treatment---" +
                                                "\nTreatment emergency: " + ((HealthTreatment) (animals.get(i)).getTreatments().get(j)).getEmergency() +
                                                "\nID of the veterinarian providing the service: " + ((HealthTreatment) ((Cow) animals.get(i)).getTreatments().get(j)).getVeterinary().getEmpID() +
                                                "\nDate of the treatment: " + ((HealthTreatment) (animals.get(i)).getTreatments().get(j)).getDateOfTreatment() +
                                                "\n---Medication---" +
                                                "\nMedication details: " + ((HealthTreatment) ( animals.get(i)).getTreatments().get(j)).getMeds().get(k).getDetails() +
                                                "\nMedication notes: " + ((HealthTreatment) ( animals.get(i)).getTreatments().get(j)).getMeds().get(k).getNotes() +
                                                "\nMedication dosage: " + ((HealthTreatment) ( animals.get(i)).getTreatments().get(j)).getMeds().get(k).getDosage() +
                                                "\nMedication duration: " + ((HealthTreatment) (animals.get(i)).getTreatments().get(j)).getMeds().get(k).getDuration() +
                                                "\nMedication start date: " + ((HealthTreatment) (animals.get(i)).getTreatments().get(j)).getMeds().get(k).getStartDate()
                                                + "\n"
                                );
                                notExist = 1;
                            }
                        }
                    }
                    if (notExist == 0) {//list is empty
                        JOptionPane.showMessageDialog(null, "No health treatments are added yet for the Animal with the tag: " + animals.get(i).getTagNo(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    notExistnew = 1;
                }
            }
            if (notExistnew == 0) {//list is empty
                JOptionPane.showMessageDialog(null, "Tag number doesn't exist!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            notExist = 0;
            notExistnew = 0;
            //Getting Cleaning Treatments
            for (i = 0; i < animals.size(); i++) {//checking the whole list of cows to find the cow with the tagNo
                if (animals.get(i).getTagNo() == tagNo ) {//checking if the type of the animal is cow and is there any animal with the given tag no
                    for (j = 0; j < animals.get(i).getTreatments().size(); j++) {
                        if (!(animals.get(i).getTreatments().isEmpty()) && (animals.get(i).getTreatments().get(j) instanceof CleaningTreatment)) {//checks if cow has a CleaningTreatment or not
                            tableTreatments.append("\n---Cleaning Treatment---" +
                                    "\nID of the FarmWorker providing the service: " + ((CleaningTreatment) ((Cow) animals.get(i)).getTreatments().get(j)).getFarmWorker().getEmpID() +
                                    "\nDate of the treatment: " + ((CleaningTreatment) ((Animal) animals.get(i)).getTreatments().get(j)).getDateOfTreatment() +
                                    "\nCleaning details: " + ((CleaningTreatment) ((Animal) animals.get(i)).getTreatments().get(j)).getMaterialsused()
                                    + "\n");
                            notExist = 1;
                        }
                    }
                    if (notExist == 0) {//list is empty
                        JOptionPane.showMessageDialog(null, "No cleaning treatments are added yet for the Animal with the tag: " + animals.get(i).getTagNo(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    notExistnew = 1;
                }
            }

            if (notExistnew == 0) {//list is empty
                JOptionPane.showMessageDialog(null, "Tag number doesn't exist!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {//list is empty
            JOptionPane.showMessageDialog(null, "No animals are added yet!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    /**
     * Given a tag number, this method returns the treatment that has been done to the given cow on the given particular date.
     * If it has multiple treatments all will be returned. If the tag number does not exist,
     * relevant messages will be given. If there is no treatment on a particular date then relevant error messages will be given.
     * @param tagNo           This is the parameter that will be taken to get a Cow form the list of cows to show its treatment
     * @param dateOfTreatment This is the parameter that will be taken to get a Cow form the list of cows to show its treatment
     */
    public void getAnimalTreatment(int tagNo, LocalDate dateOfTreatment) {
        tableTreatmentsDate.setText("");
        if (animals.isEmpty()) { // Check if the list of animals is empty
            JOptionPane.showMessageDialog(null, "The list of animals is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean IsCow = false;
        Cow cow = new Cow();
        Sheep sheep = new Sheep();
        for (Animal animal : animals) { // Find the cow with the specified tag number
            if (animal.getTagNo() == tagNo && animal instanceof Cow) {
                cow = (Cow) animal;
                IsCow = true;
            }
            if (animal.getTagNo() == tagNo && animal instanceof Sheep) {
                sheep = (Sheep) animal;
                IsCow = false;
            }
        }


        if(IsCow) {

            if (cow.getTagNo() == 0) { // Cow with the specified tag number was not found
                JOptionPane.showMessageDialog(null, "Cow with the tag number doesn't exist!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (cow.getTreatments() == null || cow.getTreatments().isEmpty()) { // Cow does not have any treatments
                JOptionPane.showMessageDialog(null, "The cow does not have any treatments!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Display HealthTreatment instances that were given on the specified date
            for (int i = 0; i < cow.getTreatments().size(); i++) {
                Treatment treatment = cow.getTreatments().get(i);
                if (treatment instanceof HealthTreatment healthTreatment && treatment.getDateOfTreatment().equals(dateOfTreatment)) {
                    tableTreatmentsDate.append("---Health Treatment---"
                            + "\nTreatment emergency: " + healthTreatment.getEmergency()
                            + "\nID of the veterinarian providing the service: " + healthTreatment.getVeterinary().getEmpID()
                    );
                    for (int j = 0; j < healthTreatment.getMeds().size(); j++) {
                        Medication med = healthTreatment.getMeds().get(j);
                        tableTreatmentsDate.append("\n---Medication---"
                                + "\nMedication details: " + med.getDetails()
                                + "\nMedication notes: " + med.getNotes()
                                + "\nMedication dosage: " + med.getDosage()
                                + "\nMedication duration: " + med.getDuration()
                                + "\nMedication start date: " + med.getStartDate()
                        );
                    }
                }
            }

            // Display CleaningTreatment instances that were given on the specified date
            for (int i = 0; i < cow.getTreatments().size(); i++) {
                Treatment treatment = cow.getTreatments().get(i);
                if (treatment instanceof CleaningTreatment cleaningTreatment && treatment.getDateOfTreatment().equals(dateOfTreatment)) {
                    tableTreatmentsDate.append("---Cleaning Treatment---"
                            + "\nTreatment material: " + cleaningTreatment.getMaterialsused()
                            + "\nID of the employee providing the service: " + cleaningTreatment.getFarmWorker().getEmpID()
                            + "\nCleaning treatment date: " + cleaningTreatment.getDateOfTreatment()
                    );
                }
            }
        }

        else {

            if (sheep.getTagNo() == 0) { // Cow with the specified tag number was not found
                JOptionPane.showMessageDialog(null, "sheep with the tag number doesn't exist!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (sheep.getTreatments() == null || sheep.getTreatments().isEmpty()) { // Cow does not have any treatments
                JOptionPane.showMessageDialog(null, "The sheep does not have any treatments!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Display HealthTreatment instances that were given on the specified date
            for (int i = 0; i < sheep.getTreatments().size(); i++) {
                Treatment treatment = sheep.getTreatments().get(i);
                if (treatment instanceof HealthTreatment healthTreatment && treatment.getDateOfTreatment().equals(dateOfTreatment)) {
                    tableTreatmentsDate.append("---Health Treatment---"
                            + "\nTreatment emergency: " + healthTreatment.getEmergency()
                            + "\nID of the veterinarian providing the service: " + healthTreatment.getVeterinary().getEmpID()
                    );
                    for (int j = 0; j < healthTreatment.getMeds().size(); j++) {
                        Medication med = healthTreatment.getMeds().get(j);
                        tableTreatmentsDate.append("\n---Medication---"
                                + "\nMedication details: " + med.getDetails()
                                + "\nMedication notes: " + med.getNotes()
                                + "\nMedication dosage: " + med.getDosage()
                                + "\nMedication duration: " + med.getDuration()
                                + "\nMedication start date: " + med.getStartDate()
                        );
                    }
                }
            }

            // Display CleaningTreatment instances that were given on the specified date
            for (int i = 0; i < sheep.getTreatments().size(); i++) {
                Treatment treatment = sheep.getTreatments().get(i);
                if (treatment instanceof CleaningTreatment cleaningTreatment && treatment.getDateOfTreatment().equals(dateOfTreatment)) {
                    tableTreatmentsDate.append("---Cleaning Treatment---"
                            + "\nTreatment material: " + cleaningTreatment.getMaterialsused()
                            + "\nID of the employee providing the service: " + cleaningTreatment.getFarmWorker().getEmpID()
                            + "\nCleaning treatment date: " + cleaningTreatment.getDateOfTreatment()
                    );
                }
            }
        }

    }

    /**
     * This method lists all the cows with only relevant details.
     */
    public void listAnimals() {
        int i;
        if (!(animals.isEmpty())) { //handling empty list error
            for (i = 0; i < animals.size(); i++) {//loop to show all cows
                if (animals.get(i) instanceof Cow) {
                    if (animals.get(i).getPurchased()) //if returns true means cow is purchased
                        listOfCows.append("\nTag no: " + animals.get(i).getTagNo()
                                + "\nGender: " + animals.get(i).getGender()
                                + "\nDate of birth: " + animals.get(i).getDateOfBirth()
                                + "\nAge: " + animals.get(i).getAge()
                                + "\nWeight: " + ((Cow) animals.get(i)).getWeight()
                                + "\nCow is purchased\n");
                    else
                        listOfCows.append("\nTag no: " + animals.get(i).getTagNo()
                                + "\nGender: " + animals.get(i).getGender()
                                + "\nDate of birth: " + animals.get(i).getDateOfBirth()
                                + "\nAge: " + animals.get(i).getAge()
                                + "\nWeight: " + ((Cow) animals.get(i)).getWeight()
                                + "\nCow is farm-raising\n");
                }
            }
            for (i = 0; i < animals.size(); i++) {//loop to show all cows
                if (animals.get(i) instanceof Sheep) {
                    if (animals.get(i).getPurchased()) //if returns true means cow is purchased
                        listOfCows.append("\nTag no: " + animals.get(i).getTagNo()
                                + "\nGender: " + animals.get(i).getGender()
                                + "\nDate of birth: " + animals.get(i).getDateOfBirth()
                                + "\nAge: " + animals.get(i).getAge()
                                + "\nSheep is purchased\n");
                    else
                        listOfCows.append("\nTag no: " + animals.get(i).getTagNo()
                                + "\nGender: " + animals.get(i).getGender()
                                + "\nDate of birth: " + animals.get(i).getDateOfBirth()
                                + "\nAge: " + animals.get(i).getAge()
                                + "\nSheep is farm-raising\n");
                }
            }
        }
    }

    /**
     * This method lists all the vets.
     */
    public void listEmployees() {
        int i;
        if (!(employees.isEmpty())) { //handling empty list error
            for (i = 0; i < employees.size(); i++) {//loop to show all vets
                if (employees.get(i) instanceof Veterinary) {
                    listofVets.append("\nVeterinary ID: " + employees.get(i).getEmpID()
                            + "\nGender: " + employees.get(i).getGender()
                            + "\nDate of birth: " + employees.get(i).getDateOfBirth()
                            + "\nSalary: " + employees.get(i).getSalary()
                            + "\nBScDegree: " + ((Veterinary) employees.get(i)).getBScDegree()
                            + "\nDate of graduation: " + ((Veterinary) employees.get(i)).getDateOfGraduation()
                            + "\nExpertise level: " + ((Veterinary) employees.get(i)).getExpertiseLevel()
                            + "\n"
                    );
                }
                if (employees.get(i) instanceof FarmWorker) {

                    listofVets.append("\nFarmWorker ID: " + employees.get(i).getEmpID()
                            + "\nGender: " + employees.get(i).getGender()
                            + "\nDate of birth: " + employees.get(i).getDateOfBirth()
                            + "\nSalary: " + employees.get(i).getSalary()
                            + "\nWork experience: " + ((FarmWorker) employees.get(i)).getWorkexperience()
                            + "\nPrevious Farm Name: " + ((FarmWorker) employees.get(i)).getPreviousFarmName()
                            + "\n"
                    );
                }
            }
        }
    }

    /**
     * This method terminates the program.
     */
    public void exit() {
        System.exit(0);
    }

    /**
     * This method takes an animal and records its milking measurement that are done for
     * entered date. Also records on a hashmap. This allows user to enter only one milking value for single date.
     * @param tagNo  This is the parameter that will be taken to get a animal form the list of animals
     * @param amount This is the parameter that will be taken to set milking measurement
     */
    public void addMilkingMeasurement(int tagNo, double amount) {
        LocalDate milkingDate = LocalDate.now();
        String milkingDate_str = MilkingDateField.getText();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            milkingDate = LocalDate.parse(milkingDate_str, dateFormatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Enter date in the correct format: 'dd/mm/yyyy'", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int i;
        if (!(animals.isEmpty())) { //handling empty list error
            for (i = 0; i < animals.size(); i++) {//checking the whole list of animals to find the cow with the tagNo
                if (animals.get(i).getTagNo() == tagNo && animals.get(i).getMilking().get(milkingDate) != null) {
                    JOptionPane.showMessageDialog(null, "A milking value already exist for same cow for same day!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        } else//list is empty
        {
            JOptionPane.showMessageDialog(null, "List is empty! No animals are added yet.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int notExist = 0;
        for (i = 0; i < animals.size(); i++) {//checking the whole list of animals to find the animal with the tagNo
            if (animals.get(i).getTagNo() == tagNo) {
                animals.get(i).setMilking(milkingDate, amount);//using setMilking overloaded setter
                JOptionPane.showMessageDialog(null, "The milking value for Animal with the tag number " + tagNo + " added successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                i = animals.size();//to exit the loop
                notExist = 1;
            }
        }
        if (notExist == 0) {
            JOptionPane.showMessageDialog(null, "Tag number doesn't exist!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method will call the feeding() method of the animal with the given tagNo to get information about how an animal needs to be fed.
     * @param tagNo This is the parameter that will be taken to get a animal form the list of animals
     */
    public void feedingAnimal(int tagNo) {
        // Set the table model to a DefaultTableModel with the necessary columns
        String[] columnNames = {"Tag No", "Gender", "Age", "Feeding Info"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        feedingTable.setModel(model);

        int i, notExist;
        notExist = 0;
        if (!(animals.isEmpty())) { //handling empty list error
            for (i = 0; i < animals.size(); i++) {//checking the whole list of animals to find the animal with the tagNo
                if (animals.get(i).getTagNo() == tagNo) {
                    animals.get(i).feeding(feedingTable);//calls feeding method according to subclass(cow or sheep)
                    i = animals.size();//to exit the loop
                    notExist = 1;
                }
            }
            if (notExist == 0) {
                JOptionPane.showMessageDialog(null, "Tag number doesn't exist!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else//list is empty
            JOptionPane.showMessageDialog(null, "List is empty! No cows are added yet.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * This method will check the whole list of employees to find the employee salary
     * @param empId This is the parameter that will be taken to invoke getSalary() method
     * @return EmpSalary this will be returned
     */
    public double getEmpSalary(int empId) {
        int i, notExist;
        double EmpSalary = 0.0;
        notExist = 0;
        if (!(employees.isEmpty())) { //handling empty list error
            for (i = 0; i < employees.size(); i++) {
                if ((employees.get(i).getEmpID() == empId)) {//checking the whole list of emplyees to find the employee
                    EmpSalary = employees.get(i).getSalary();
                    i = employees.size();//to exit the loop
                    notExist = 1;
                }
            }
            if (notExist == 0) {
                JOptionPane.showMessageDialog(null, "Employee with the entered ID doesn't exist!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else//list is empty
            JOptionPane.showMessageDialog(null, "List is empty! No employees are added yet.", "Error", JOptionPane.ERROR_MESSAGE);
        return EmpSalary;
    }

    /**
     * Creates a medication list by taking all the details.
     * @return This method returns created list of Medication objects
     */
    public ArrayList<Medication> create_meds() {
        ArrayList<Medication> meds = new ArrayList<>();
        int control = 0;
        int controll = 0;
        do {
            String new_mdetails = "Not Specified";
            do {
                new_mdetails = JOptionPane.showInputDialog("Enter medication details:");
                if (new_mdetails == null || new_mdetails.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid input.");
                }
            } while (new_mdetails == null || new_mdetails.isEmpty());

            int new_duration = 0;
            do {
                try {
                    new_duration = Integer.parseInt(JOptionPane.showInputDialog("Enter medication duration:"));
                    controll = 1;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input for medication duration. Please enter a valid integer.");
                }
            } while (controll != 1);
            controll = 0;


            LocalDate new_mdate = LocalDate.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            do {
                try {
                    String new_str_mdate = JOptionPane.showInputDialog("Enter medication date:");
                    if (new_str_mdate == null || new_str_mdate.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid input.");
                    } else {
                        new_mdate =LocalDate.parse(new_str_mdate, dateFormatter);
                        controll = 1;
                    }
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(null, "Enter date in the correct format: 'dd/mm/yyyy'", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } while (controll != 1);
            controll = 0;



            double new_dosage = 0.0;
            do {
                try {
                    new_dosage = Double.parseDouble(JOptionPane.showInputDialog("Enter medication dosage:"));
                    controll = 1;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input for medication dosage. Please enter a valid number.");
                }
            } while (controll != 1);
            controll = 0;

            String new_mnotes = "Not Specified";
            do {
                new_mnotes = JOptionPane.showInputDialog("Enter medication notes:");
                if (new_mnotes == null || new_mnotes.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please entera valid input.");
                }
            } while (new_mnotes == null || new_mnotes.isEmpty());

            Medication medication = new Medication(new_mdetails, new_duration, new_mdate, new_dosage, new_mnotes);
            meds.add(medication);

            control = 0;
            do {
                try {
                    control = Integer.parseInt(JOptionPane.showInputDialog("To enter another medication, enter 1. To continue, enter 0:"));
                    while (control != 1 && control != 0) {
                        JOptionPane.showMessageDialog(null, "Enter a valid number from the list!");
                        control = Integer.parseInt(JOptionPane.showInputDialog("To enter another medication, enter 1. To continue, enter 0:"));
                    }
                    controll = 1;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
                }
            } while (controll != 1);
        } while (control != 0);
        return meds;
    }


    /**
     * This method by calling compareTo() method compares two Veterinaries
     */
    public void compareVets() {
        Veterinary e1 = new Veterinary();

        // Get the empID number from the JFormattedTextField
        int empID = 0;
        try {
            // convert the text field value to an integer
            empID = Integer.parseInt(FirstEmployeeIDVet.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid ID number", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int i, notExist;
        notExist = 0;
        if (!(employees.isEmpty())) { //handling empty list error
            for (i = 0; i < employees.size(); i++) {
                if ((employees.get(i).getEmpID() == empID) && employees.get(i) instanceof Veterinary) {//checking the whole list of emplyees to find the emplyee
                    e1 = (Veterinary) employees.get(i);
                    i = employees.size();//to exit the loop
                    notExist = 1;
                }
            }
            if (notExist == 0) {
                JOptionPane.showMessageDialog(null, "Vet with the entered ID doesn't exist!");
                return;
            }
        } else//list is empty
        {
            JOptionPane.showMessageDialog(null, "List is empty! No vets are added yet.");
            return;
        }
        Veterinary e2 = new Veterinary();
        empID = 0;
        try {
            // convert the text field value to an integer
            empID = Integer.parseInt(SecondEmployeeIDVet.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid ID number", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        notExist = 0;
        if (!(employees.isEmpty())) { //handling empty list error
            for (i = 0; i < employees.size(); i++) {
                if ((employees.get(i).getEmpID() == empID) && employees.get(i) instanceof Veterinary) {//checking the whole list of emplyees to find the emplyee
                    e2 = (Veterinary) employees.get(i);
                    i = employees.size();//to exit the loop
                    notExist = 1;
                }
            }
            if (notExist == 0) {
                JOptionPane.showMessageDialog(null, "Vet with the entered ID doesn't exist!");
                return;
            }
        } else//list is empty
        {
            JOptionPane.showMessageDialog(null, "List is empty! No vets are added yet.");
            return;
        }

        if (e1.compareTo(e2) == 1) {
            compareVeterinariestextArea.setText("Vets have the same salary!");
        } else if (e1.compareTo(e2) == 0) {
            compareVeterinariestextArea.setText("The first veterinary has the greater salary!");
        } else
            compareVeterinariestextArea.setText("The second veterinary has the greater salary!");
    }

    /**
     * This method by calling compareTo() method compares two FarmWorkers
     */
    public void compareFarmWorkers() {
        FarmWorker e1 = new FarmWorker();

        // Get the empID number from the JFormattedTextField
        int empID = 0;
        try {
            // convert the text field value to an integer
            empID = Integer.parseInt(FirstEmployeeIDFarmworker.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid ID number", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int i, notExist;
        notExist = 0;
        if (!(employees.isEmpty())) { //handling empty list error
            for (i = 0; i < employees.size(); i++) {
                if ((employees.get(i).getEmpID() == empID) && employees.get(i) instanceof FarmWorker) {//checking the whole list of emplyees to find the emplyee
                    e1 = (FarmWorker) employees.get(i);
                    i = employees.size();//to exit the loop
                    notExist = 1;
                }
            }
            if (notExist == 0) {
                JOptionPane.showMessageDialog(null, "FarmWorker with the entered ID doesn't exist!");
                return;
            }
        } else//list is empty
        {
            JOptionPane.showMessageDialog(null, "List is empty! No FarmWorker are added yet.");
            return;
        }

        FarmWorker e2 = new FarmWorker();
        empID = 0;
        try {
            // convert the text field value to an integer
            empID = Integer.parseInt(SecondEmployeeIDFarmworker.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid ID number", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        notExist = 0;
        if (!(employees.isEmpty())) { //handling empty list error
            for (i = 0; i < employees.size(); i++) {
                if ((employees.get(i).getEmpID() == empID) && employees.get(i) instanceof FarmWorker) {//checking the whole list of emplyees to find the emplyee
                    e2 = (FarmWorker) employees.get(i);
                    i = employees.size();//to exit the loop
                    notExist = 1;
                }
            }
            if (notExist == 0) {
                JOptionPane.showMessageDialog(null, "FarmWorker with the entered ID doesn't exist!");
                return;
            }
        } else//list is empty
        {
            JOptionPane.showMessageDialog(null, "List is empty! No FarmWorker are added yet.");
            return;
        }

        if (e1.compareTo(e2) == 1) {
            CompareFarmworkerstextArea.setText("FarmWorkers have the same salary!");
        } else if (e1.compareTo(e2) == 0) {
            CompareFarmworkerstextArea.setText("The first FarmWorker has the greater salary!");
        } else
            CompareFarmworkerstextArea.setText("The second FarmWorker has the greater salary!");
    }

    /** The following method deletes, updates or inserts new data to database
     * via deleting all existing info and inserting new info from the list of animals and employees.
     * This way database is updated with all operations performed on the data.
     * @throws SQLException for database faults */
    public void updateTheDB() throws SQLException {
        // Use the 'FarmAppDB' database
        String useDatabaseQuery = "USE `FarmAppDB`";
        statement.executeUpdate(useDatabaseQuery);

        // To delete all the rows from the 'Animal' table to update all of its content with the new info
        String deleteAnimalDataQuery = "DELETE FROM `Animal`";
        statement.executeUpdate(deleteAnimalDataQuery);

        // Insert the animals into the 'Animal' table
        for (Animal animal : animals) {
            String AnimalQuery = "INSERT INTO `Animal` (`tagNo`, `gender`, `dateOfBirth`, `purchased`, `type`, `Weight`) " +
                    "VALUES ('" + animal.getTagNo() + "', '";

            if (animal.getGender().equals("male")) {
                AnimalQuery += "m" + "', ";
            } else{
                AnimalQuery += "f" + "', ";
            }

            AnimalQuery += "'" + animal.getDateOfBirth() + "', " + animal.getPurchased() + ", '" ;

            if (animal instanceof Cow) {
                AnimalQuery +="c" + "', ";
                // If the animal is a Cow, includes the 'Weight' parameter in the query
                AnimalQuery += ((Cow)animal).getWeight();

            } else {
                //Please note that I removed not null statement from the weight attribute of animal table
                AnimalQuery +="s" + "', ";
                // If the animal is a Sheep, set the 'Weight' parameter to null
                AnimalQuery += "NULL";
            }
            AnimalQuery += ")";
            statement.executeUpdate(AnimalQuery);
        }

        // To delete all the rows from the 'Employee' table to update all of its content with the new info
        String deleteEmployeeDataQuery = "DELETE FROM `Employee`";
        statement.executeUpdate(deleteEmployeeDataQuery);

// Insert the employees into the 'Employee' table
        for (Employee employee : employees) {
            String EmployeeQuery = "INSERT INTO `Employee` (`empID`, `gender`, `dateOfBirth`, `type`, `BScDegree`, `dateOfGraduation`, `expertiseLevel`, `previousFarmName`, `workExperience`) " +
                    "VALUES (" + employee.getEmpID() + ", '";

            if (employee.getGender().equals("male")) {
                EmployeeQuery += "m" + "', ";
            } else{
                EmployeeQuery += "f" + "', ";
            }

            EmployeeQuery += "'" + employee.getDateOfBirth() + "', '";

            if (employee instanceof Veterinary) {
                EmployeeQuery += "v" + "', ";
            } else {
                EmployeeQuery += "f" + "', ";
            }

            if (employee instanceof Veterinary) {
                EmployeeQuery += ((Veterinary) employee).getBScDegree() + ", '" + ((Veterinary) employee).getDateOfGraduation() + "', " + ((Veterinary) employee).getExpertiseLevel()+ ", " +  "NULL"+ ", " + "NULL";
            }
            else {
                EmployeeQuery += "NULL"+ ", " + "NULL"+ ", "+ "NULL"+ ", '" + ((FarmWorker) employee).getPreviousFarmName() + "', " + ((FarmWorker) employee).getWorkexperience();
            }
            EmployeeQuery += ")";
            statement.executeUpdate(EmployeeQuery);
        }
    }

    /**
     Reads animal data from the 'Animal' table in the 'FarmAppDB' database and adds the animals to the 'animals' list.
     @throws SQLException if an error occurs while accessing the database
     */
    public void readAnimalsFromDB() throws SQLException {
        // Use the 'FarmAppDB' database
        String useDatabaseQuery = "USE `FarmAppDB`";
        statement.executeUpdate(useDatabaseQuery);

        // Selects all the rows from the 'Animal' table
        String selectAnimalsQuery = "SELECT * FROM `Animal`";
        ResultSet resultSet = statement.executeQuery(selectAnimalsQuery);

        while (resultSet.next()) {
            int tagNo = resultSet.getInt("tagNo");
            String gender = resultSet.getString("gender");
            LocalDate dateOfBirth = resultSet.getDate("dateOfBirth").toLocalDate();
            boolean purchased = resultSet.getBoolean("purchased");
            String type = resultSet.getString("type");
            int weight = resultSet.getInt("Weight");

            if (type.equals("c")) {
                // If the type is 'c', creates a Cow object
                Cow cow = new Cow(tagNo, gender, dateOfBirth, purchased, weight);
                animals.add(cow);
            } else {
                // If the type is 's', creates a Sheep object
                Sheep sheep = new Sheep(tagNo, gender, dateOfBirth, purchased);
                animals.add(sheep);
            }
        }
    }

    /**
     Reads employee data from the 'Employee' table in the 'FarmAppDB' database and adds the employees to the 'employees' list.
     @throws SQLException if an error occurs while accessing the database
     */
    public void readEmployeesFromDB() throws SQLException {
        // Use the 'FarmAppDB' database
        String useDatabaseQuery = "USE `FarmAppDB`";
        statement.executeUpdate(useDatabaseQuery);

        // Selects all the rows from the 'Employee' table
        String selectEmployeesQuery = "SELECT * FROM `Employee`";
        ResultSet resultSet = statement.executeQuery(selectEmployeesQuery);

        while (resultSet.next()) {
            int empID = resultSet.getInt("empID");
            String gender = resultSet.getString("gender");
            LocalDate dateOfBirth = resultSet.getDate("dateOfBirth").toLocalDate();
            String type = resultSet.getString("type");

            if (type.equals("v")) {
                // If the type is 'v', creates a Veterinary object
                boolean BScDegree = resultSet.getBoolean("BScDegree");
                LocalDate dateOfGraduation = resultSet.getDate("dateOfGraduation").toLocalDate();
                int expertiseLevel = resultSet.getInt("expertiseLevel");
                Veterinary veterinary = new Veterinary(empID, gender, dateOfBirth, BScDegree, dateOfGraduation, expertiseLevel);
                employees.add(veterinary);
            } else {
                // If the type is 'f', creates a FarmWorker object
                String previousFarmName = resultSet.getString("previousFarmName");
                int workExperience = resultSet.getInt("workExperience");
                FarmWorker farmWorker = new FarmWorker(empID, gender, dateOfBirth, previousFarmName, workExperience);
                employees.add(farmWorker);
            }
        }
    }

}
