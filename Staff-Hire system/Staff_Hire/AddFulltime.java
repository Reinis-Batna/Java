package Staff_Hire;


public class AddFulltime {
    private MyGUI Model;
    private StaffHire controller;

    public AddFulltime() {}

    public void setModel(MyGUI model) {
        this.Model = model;}
    public void setController(StaffHire controller) {
        this.controller = controller;}

// Search staff by ID number
    public void searchEmployee(){
        try{
            int staffID = Model.getStaffID();

            String stringStaffID = String.valueOf(staffID).trim();

            controller.searchEmployeeLogic(stringStaffID);
        } catch (Exception e) {
            Model.searchNumberEntryFailure();
        }
    }

// Terminate staff with ID number
    public void terminateEmployee(){
        try {
            // Get the staff ID from the field
            int staffID = Model.getStaffID();

            // Validate staff ID
            if (staffID <= 0) {
                Model.terminationFailure();
                return;
            }

            // Convert integer to string and trim it
            String terminateStaffID = String.valueOf(staffID).trim();
            // Pass the string to StaffHire controller to initiate termination of staff
            terminateEmployeeLogic(terminateStaffID);

            // Check if staff ID is empty
            if (terminateStaffID.isEmpty()) {
                Model.terminationFailure();
                return;
            }
        } catch (NumberFormatException e) {
            // When staff ID is not a valid number
            Model.terminationFailure();
        } catch (Exception e) {
            // Any other errors
            Model.terminationFailure();
        }
    }



    public void terminateEmployeeLogic(String terminateStaffID) {
        controller.terminateEmployeeLogic(terminateStaffID);
    }

// Set salary
    public void setSalary(){
        try{
            int staffID = Model.getStaffID();
            int salary = Model.getSalary();

            String stringStaffID = String.valueOf(staffID).trim();
            String stringSalary = String.valueOf(salary).trim();

            controller.setSalaryLogic(stringStaffID, stringSalary);
        } catch (Exception e) {
            Model.salaryAdditionFailure();
        }
    }


 // Main function of class which adds full time staff
    public void grabInfo() {
        if (Model == null) {
            Model.fileCreationFailure();
        }
            try {
                int staffID = Model.getStaffID();
                String staffName = Model.getStaffName();
                int vacancyNumber = Model.getVacancyNumber();
                String jobType = Model.getJobType();
                String designation = Model.getDesignation();
                String qualification = Model.getQualification();
                int joinDate = Model.getJoinDate();
                String appointedBy = Model.getAppointedBy();
                String shifts = Model.getShifts();
                int salary = Model.getSalary();

                updateStaffInfo(staffID, staffName, vacancyNumber, jobType, designation, qualification,
                               String.valueOf(joinDate), appointedBy, salary, shifts);
            } catch (NumberFormatException e) {
                Model.fileCreationFailure();
            } catch (Exception e) {
                Model.fileCreationFailure();
            }
    }




    public void updateStaffInfo(int staffID, String staffName, int vacancyNumber, String jobType, String designation, String qualification, String joinDate, String appointedBy, int salary, String shifts){
        controller.updateFullTimeStaff(String.valueOf(staffID), staffName, vacancyNumber, jobType, designation, qualification, joinDate, appointedBy, salary, shifts);
    }
}




