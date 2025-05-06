package Staff_Hire;
import java.io.*;


// StaffHire class contains the main function which generates the GUI, calls controller methods and performs file handling.

public class StaffHire {
    private final MyGUI model;
    private final AddParttime partTimeView;
    private final AddFulltime fullTimeView;

    public StaffHire(){
        this.model = new MyGUI();
        this.partTimeView = model.getAddParttime();
        this.partTimeView.setController(this);
        this.partTimeView.setModel(model);
        this.fullTimeView = model.getAddFulltime();
        this.fullTimeView.setController(this);
        this.fullTimeView.setModel(model);
    }

// Staff search file handling
    public void searchEmployeeLogic(String staffID) {
        try {
            String fileName = staffID+".txt";
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            model.StaffNameField.setText(reader.readLine());
            model.VacancyField.setText(reader.readLine());
            model.JobTypeField.setText(reader.readLine());
            model.DesignationField.setText(reader.readLine());
            model.QualificationField.setText(reader.readLine());
            model.JobDateField.setText(reader.readLine());
            model.AppointedByField.setText(reader.readLine());
            model.SalaryField.setText(reader.readLine());
            model.WeeklyHoursField.setText(reader.readLine());
            model.ShiftsField.setText(reader.readLine());
            model.WorkingHoursField.setText(reader.readLine());
            model.WagesField.setText(reader.readLine());

            // Converts String "true" or "false" to boolean and adjusts check box correspondingly
            String booleanString = reader.readLine();
            boolean value = Boolean.parseBoolean(booleanString);
            model.JoinedCheckBox.setSelected(value);

            String booleanString2 = reader.readLine();
            boolean value2 = Boolean.parseBoolean(booleanString2);
            model.TerminatedCheckBox.setSelected(value2);

            model.searchSuccess();

        } catch (FileNotFoundException e) {
            model.searchFailure();
        } catch (IOException e) {
            model.searchFailure();
        }
    }

// Staff termination using file handling
    public void terminateEmployeeLogic(String terminateStaffID) {
        BufferedReader read = null;
        try {
            read = new BufferedReader(new FileReader(terminateStaffID + ".txt"));

            for (int i = 0; i < 13; i++) {
                read.readLine();
            }

            String line14 = read.readLine();
            read.close();

            if (line14 != null) {
                String filteredLine = line14.toLowerCase().trim();

                if (filteredLine.contains("true")) {
                    model.alreadyTerminated();
                    model.clearFields();

                } else if (filteredLine.contains("false")) {
                    read = new BufferedReader((new FileReader(terminateStaffID+".txt")));

                    String[] lines = new String[14];
                    for (int i = 0; i < 13; i++) {
                        lines[i] = read.readLine();
                    }
                    read.close();
                    // Removes lines that correspond to staff name, join date, qualification and appointed by
                    // Also, sets the statement used for getting termination status to "true", and sets joined status to "false"

                    lines[0]="";
                    lines[4]="";
                    lines[5]="";
                    lines[6]="";
                    lines[12]="false";
                    lines[13]="true";

                    FileWriter write = new FileWriter((terminateStaffID+".txt"));
                            for (int i = 0; i < 14; i++) {
                                write.write(lines[i]+"\n");
                            }
                            write.close();

                            model.staffTerminated();
                            model.clearFields();
                }
            }
        } catch (FileNotFoundException e) {
            model.terminationFailure();
        } catch (IOException e) {
            model.terminationFailure();
        }
    }

// Set weekly fractional hours using file handling
    public void setHoursLogic(String staffID, String stringHours){
        BufferedReader read = null;
        try {
            read = new BufferedReader(new FileReader(staffID + ".txt"));

            String[] lines = new String[14];
            for (int i = 0; i < 14; i++) {
                lines[i] = read.readLine();
            }
            read.close();

            lines[8]=stringHours;

            FileWriter write = new FileWriter((staffID+".txt"));
            for (int i = 0; i < 14; i++) {
                write.write(lines[i]+"\n");
            }
            write.close();

            model.setWeeklyHoursSuccess();
            model.clearFields();

        } catch (FileNotFoundException e) {
            model.searchFailure();
        } catch (IOException e) {
            model.setWeeklyHoursFailure();
        }




    }

// Set shifts using file handling
    public void setShiftLogic(String staffID, String shifts){
        BufferedReader read = null;
        try {
            read = new BufferedReader(new FileReader(staffID + ".txt"));

            String[] lines = new String[14];
            for (int i = 0; i < 14; i++) {
                lines[i] = read.readLine();
            }
            read.close();

            lines[9]=shifts;

            FileWriter write = new FileWriter((staffID+".txt"));
            for (int i = 0; i < 14; i++) {
                write.write(lines[i]+"\n");
            }
            write.close();
            model.shiftAdditionSuccess();
            model.clearFields();

        } catch (FileNotFoundException e) {
            model.searchFailure();
        } catch (IOException e) {
            model.shiftAdditionFailure();
        }
    }

// Set salary using file handling
    public void setSalaryLogic(String staffID, String stringSalary){
        BufferedReader read = null;
        try {
            read = new BufferedReader(new FileReader(staffID + ".txt"));

            String[] lines = new String[14];
            for (int i = 0; i < 14; i++) {
                lines[i] = read.readLine();
            }
            read.close();

            lines[7]=stringSalary;

            FileWriter write = new FileWriter((staffID+".txt"));
            for (int i = 0; i < 14; i++) {
                write.write(lines[i]+"\n");
            }
            write.close();
            model.salaryAdditionSuccess();
            model.clearFields();

        } catch (FileNotFoundException e) {
            model.searchFailure();
        } catch (IOException e) {
            model.setWeeklyHoursFailure();
        }
    }

    // Creates a new file for a staff member using the staff ID number, which can also be used to identify the file and append/read it later on.
    public void updatePartTimeStaff(String staffID, String staffName, int vacancyNumber, String jobType, String designation, String qualification, String joinDate, String appointedBy, float weeklyHours, String shifts, int workingHours, float wages)
    {try {
            String FileName = String.valueOf(staffID)+".txt";
            File StaffFile = new File(FileName);


            FileWriter writer = new FileWriter(StaffFile);
            writer.write(staffName+"\n");
            writer.write(vacancyNumber+"\n");
            writer.write(jobType+"\n");
            writer.write(designation+"\n");
            writer.write(qualification+"\n");
            writer.write(joinDate+"\n");
            writer.write(appointedBy+"\n");
            writer.write("\n");
            writer.write(weeklyHours+"\n");
            writer.write(shifts+"\n");
            writer.write(workingHours+"\n");
            writer.write(wages+"\n");
            writer.write("true\n");
            writer.write("false\n");
            writer.close();

            model.fileCreationSuccess();
            model.clearFields();



        }catch (IOException e) {
            model.fileCreationFailure();
        }
    }

    // Creates a new file for a staff member using the staff ID number, which can also be used to identify the file and append/read it later on.
    public void updateFullTimeStaff(String staffID, String staffName, int vacancyNumber, String jobType, String designation, String qualification, String joinDate, String appointedBy, int salary, String shifts){
        try {
            String FileName = String.valueOf(staffID)+".txt";
            File StaffFile = new File(FileName);


            FileWriter writer = new FileWriter(StaffFile);
            writer.write(staffName+"\n");
            writer.write(vacancyNumber+"\n");
            writer.write(jobType+"\n");
            writer.write(designation+"\n");
            writer.write(qualification+"\n");
            writer.write(joinDate+"\n");
            writer.write(appointedBy+"\n");
            writer.write(salary+"\n");
            writer.write("\n");
            writer.write(shifts+"\n");
            writer.write("\n");
            writer.write("\n");
            writer.write("true\n");
            writer.write("false\n");
            writer.close();

            model.fileCreationSuccess();
            model.clearFields();



        }catch (IOException e) {
            model.fileCreationFailure();
        }
    }


    public static void main(String[] args) {
        StaffHire controller = new StaffHire();



    }
}