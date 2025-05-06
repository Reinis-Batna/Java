package Staff_Hire;

public class AddParttime {
    private MyGUI Model;
    private StaffHire controller;

    public AddParttime(){}

    public void setModel(MyGUI model) {
        this.Model = model;}
    public void setController(StaffHire controller) {
        this.controller = controller;}

// Set weekly fractional hours
    public void setWeeklyHours() {
        try{
            int staffID = Model.getStaffID();
            float hours = Model.getWeeklyHours();

            String stringStaffID = String.valueOf(staffID).trim();
            String stringHours = Float.toString(hours).trim();

            controller.setHoursLogic(stringStaffID, stringHours);

        } catch (Exception e) {
            Model.setWeeklyHoursFailure();
        }
    }

// Set shifts
    public void setShifts(){
        try{
            int staffID = Model.getStaffID();
            String shifts = Model.getShifts();

            String stringStaffID = String.valueOf(staffID).trim();

            controller.setShiftLogic(stringStaffID, shifts);
        } catch (Exception e) {
            Model.shiftAdditionFailure();
        }
    }


// Main function of class which adds part time staff
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
            float weeklyHours = Model.getWeeklyHours();
            String shifts = Model.getShifts();
            String workingHours = Model.getWorkingHours();
            float wages = Model.getWages();
            boolean isJoined = Model.isJoined();
            
            // Validate string to int conversion before calling updateStaffInfo
            int workingHoursInt;
            try {
                workingHoursInt = Integer.valueOf(workingHours);
            } catch (NumberFormatException e) {
                Model.fileCreationFailure();
                return;
            }
            
            updateStaffInfo(staffID, staffName, vacancyNumber, jobType, designation, qualification, 
                            String.valueOf(joinDate), appointedBy, weeklyHours, shifts, 
                            workingHoursInt, wages, isJoined);
        } catch (NumberFormatException e) {
            Model.fileCreationFailure();
        } catch (Exception e) {
            Model.fileCreationFailure();
        }
    }

    public void updateStaffInfo(int staffID, String staffName, int vacancyNumber, String jobType, String designation, String qualification, String joinDate, String appointedBy, float weeklyHours, String shifts, int workingHours, float wages, boolean isJoined
    ){
        controller.updatePartTimeStaff(String.valueOf(staffID), staffName, vacancyNumber, jobType, designation, qualification, joinDate, appointedBy, weeklyHours, shifts, workingHours, wages);
    }
}
