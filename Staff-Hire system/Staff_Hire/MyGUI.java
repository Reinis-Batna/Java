package Staff_Hire;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;






public class MyGUI extends JFrame{
    private AddParttime addParttime;
    private AddFulltime addFulltime;

    public AddParttime getAddParttime() {
        return addParttime;}
    public AddFulltime getAddFulltime() {
        return addFulltime;}

    public MyGUI(){
        this.addParttime = new AddParttime();
        this.addFulltime = new AddFulltime();

        initComponents();
        setVisible(true);
    }

    public JTextField StaffIDField;
    public JCheckBox JoinedCheckBox;
    public JCheckBox TerminatedCheckBox;

    public JTextField StaffNameField;
    public JTextField VacancyField;
    public JTextField JobTypeField;
    public JTextField DesignationField;
    public JTextField QualificationField;

    public JTextField JobDateField;
    public JTextField AppointedByField;
    public JTextField SalaryField;

    public JTextField WeeklyHoursField;
    public JTextField ShiftsField;
    public JTextField WorkingHoursField;
    public JTextField WagesField;

    public JLabel Notification;

    // WWindow properties
    public void initComponents(){
        setTitle("Staff Hire utility");
        setSize(1600,900);
        setVisible(true);
        GridLayout gridLayout = new GridLayout(4,10,5,10);
        setLayout(null);
        add(MainPanel());

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Window components
    public JLayeredPane MainPanel() {
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1600, 900);
        layeredPane.setBackground(new Color(255, 255, 255));




        layeredPane.add(NotificationBox(),Integer.valueOf(3));
        layeredPane.add(TopBar(),Integer.valueOf(3));
        layeredPane.add(Header(),Integer.valueOf(3));
        layeredPane.add(SearchBtn(),Integer.valueOf(2));
        layeredPane.add(TextBox1(),Integer.valueOf(2));
        layeredPane.add(EntryBox2(),Integer.valueOf(1));
        layeredPane.add(TextBox2(),Integer.valueOf(2));
        layeredPane.add(EntryBox1(),Integer.valueOf(1));
        layeredPane.add(SideBar(),Integer.valueOf(2));
        layeredPane.add(ClearBtn(),Integer.valueOf(3));
        layeredPane.add(TextBox3(),Integer.valueOf(2));
        layeredPane.add(EntryBox3(),Integer.valueOf(1));
        layeredPane.add(Background(),Integer.valueOf(1));
        layeredPane.add(StaffEntry(),Integer.valueOf(2));
        return layeredPane;

    }

    // Purely UI elements
    public JPanel Header(){
        JPanel panel = new JPanel();
        LayoutManager layout = new BoxLayout(panel,BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        panel.setBounds(204,483,596,50);
        panel.setBackground(new Color(101, 25, 151));

        JLabel Text = new JLabel("                Employee Search Tool");
        Text.setFont(new Font("Verdana", Font.BOLD, 25));
        Text.setForeground(Color.WHITE);

        Text.setBounds(215,488,200,30);

        panel.add(Box.createRigidArea(new Dimension(1,10)));
        panel.add(Text);
        return panel;
    }

    public JPanel TopBar(){
        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(101, 25, 151));
        panel.setBounds(0,0,1600,75);

        JLabel title = new JLabel("Staff Hire utility");
        title.setFont(new Font("Verdana", Font.BOLD, 58));
        title.setForeground(Color.WHITE);

        title.setBounds(215,0,700,76);

        panel.add(title);


        return panel;
    }

    public JPanel Background(){
        JPanel panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(500,10));
        panel.setBounds(204,483,596,374);
        panel.setBackground(new Color(32, 31, 31));

        return panel;
    }

    public JPanel TextBox1(){
        JPanel panel = new JPanel(new GridLayout(6,0));
        panel.setBounds(204,79,300,400);
        panel.setBackground(new Color(32, 31, 31));

        Font font = new Font("Consolas",Font.PLAIN,25);

        JLabel Qualification = new JLabel("   Qualification: ");
        Qualification.setFont(font);
        Qualification.setForeground(Color.WHITE);

        JLabel JobType = new JLabel("   Job Type: ");
        JobType.setFont(font);
        JobType.setForeground(Color.WHITE);

        JLabel Vacancy = new JLabel("   Vacancy No.: ");
        Vacancy.setFont(font);
        Vacancy.setForeground(Color.WHITE);

        JLabel StaffName = new JLabel("   Staff Name: ");
        StaffName.setFont(font);
        StaffName.setForeground(Color.WHITE);

        JLabel Designation = new JLabel("   Designation: ");
        Designation.setFont(font);
        Designation.setForeground(Color.WHITE);

        panel.add(StaffName);
        panel.add(Vacancy);
        panel.add(JobType);
        panel.add(Designation);
        panel.add(Qualification);
        return panel;
    }

    public JPanel TextBox2(){
        JPanel panel = new JPanel(new GridLayout(6,0));
        panel.setBounds(804,79,400,400);
        panel.setBackground(new Color(32, 31, 31));

        Font font = new Font("Consolas",Font.PLAIN,25);

        JLabel JobDate = new JLabel("   Joining Date: (ddmmyyyy)");
        JobDate.setFont(font);
        JobDate.setForeground(Color.WHITE);

        JLabel AppointedBy = new JLabel("   Appointed By: ");
        AppointedBy.setFont(font);
        AppointedBy.setForeground(Color.WHITE);

        JLabel Salary = new JLabel("   Salary: (if full-time)");
        Salary .setFont(font);
        Salary .setForeground(Color.WHITE);


        panel.add(JobDate);
        panel.add(AppointedBy);
        panel.add(Salary);
        return panel;
    }

    public JPanel TextBox3(){
        JPanel panel = new JPanel(new GridLayout(6,0));
        panel.setBounds(804,479,400,378);
        panel.setBackground(new Color(32, 31, 31));

        Font font = new Font("Consolas",Font.PLAIN,25);

        JLabel WeeklyHours = new JLabel("   Weekly Fractional Hours: ");
        WeeklyHours.setFont(font);
        WeeklyHours.setForeground(Color.WHITE);

        JLabel Shifts = new JLabel("   Shifts: ");
        Shifts.setFont(font);
        Shifts.setForeground(Color.WHITE);

        JLabel WorkingHours = new JLabel("   Working Hours: ");
        WorkingHours.setFont(font);
        WorkingHours.setForeground(Color.WHITE);

        JLabel Wage = new JLabel("   Wage per hours: ");
        Wage.setFont(font);
        Wage.setForeground(Color.WHITE);

        JLabel Blank = new JLabel("  ");
        Blank.setFont(font);
        Blank.setForeground(Color.WHITE);

        panel.add(WeeklyHours);
        panel.add(Shifts);
        panel.add(WorkingHours);
        panel.add(Wage);
        panel.add(Blank);
        return panel;

    }

    // All classes that contain entry fields or any other type of user input
    public JPanel EntryBox1 (){
        JPanel panel = new JPanel();
        LayoutManager layout = new BoxLayout(panel,BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        panel.setBounds(504,79,300,400);
        panel.setBackground(new Color(32, 31, 31));

        StaffNameField = new JTextField();
        StaffNameField.setFont(new Font("Verdana",Font.BOLD,18));
        StaffNameField.setMaximumSize(new Dimension(300,40));


        VacancyField = new JTextField();
        VacancyField.setFont(new Font("Verdana",Font.BOLD,18));
        VacancyField.setMaximumSize(new Dimension(300,40));

        JobTypeField = new JTextField();
        JobTypeField.setFont(new Font("Verdana",Font.BOLD,18));
        JobTypeField.setMaximumSize(new Dimension(300,40));

        DesignationField = new JTextField();
        DesignationField.setFont(new Font("Verdana",Font.BOLD,18));
        DesignationField.setMaximumSize(new Dimension(300,40));

        QualificationField = new JTextField();
        QualificationField.setFont(new Font("Verdana",Font.BOLD,18));
        QualificationField.setMaximumSize(new Dimension(300,40));

        panel.add(Box.createRigidArea(new Dimension(300,19)));
        panel.add(StaffNameField);
        panel.add(Box.createRigidArea(new Dimension(300,39)));
        panel.add(VacancyField);
        panel.add(Box.createRigidArea(new Dimension(300,39)));
        panel.add(JobTypeField);
        panel.add(Box.createRigidArea(new Dimension(300,39)));
        panel.add(DesignationField);
        panel.add(Box.createRigidArea(new Dimension(300,39)));
        panel.add(QualificationField);
        panel.add(Box.createRigidArea(new Dimension(300,120)));
        return panel;
    }

    public JPanel EntryBox2(){
        JPanel panel = new JPanel();
        LayoutManager layout = new BoxLayout(panel,BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        panel.setBounds(1204,79,375,400);
        panel.setBackground(new Color(32, 31, 31));

        JobDateField = new JTextField();
        JobDateField.setFont(new Font("Verdana",Font.BOLD,18));
        JobDateField.setMaximumSize(new Dimension(300,40));

        AppointedByField = new JTextField();
        AppointedByField.setFont(new Font("Verdana",Font.BOLD,18));
        AppointedByField.setMaximumSize(new Dimension(300,40));

        SalaryField = new JTextField();
        SalaryField.setFont(new Font("Verdana",Font.BOLD,18));
        SalaryField.setMaximumSize(new Dimension(300,40));

        panel.add(Box.createRigidArea(new Dimension(300,19)));
        panel.add(JobDateField);
        panel.add(Box.createRigidArea(new Dimension(300,37)));
        panel.add(AppointedByField);
        panel.add(Box.createRigidArea(new Dimension(300,39)));
        panel.add(SalaryField);
        panel.add(Box.createRigidArea(new Dimension(300,180)));
        panel.add(Box.createRigidArea(new Dimension(300,29)));
        panel.add(Box.createRigidArea(new Dimension(300,29)));
        panel.add(Box.createRigidArea(new Dimension(300,29)));
        panel.add(Box.createRigidArea(new Dimension(300,29)));
        return panel;



    }

    public JPanel EntryBox3(){
        JPanel panel = new JPanel();
        LayoutManager layout = new BoxLayout(panel,BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        panel.setBounds(1204,479,375,378);
        panel.setBackground(new Color(32, 31, 31));

        WeeklyHoursField = new JTextField();
        WeeklyHoursField.setFont(new Font("Verdana",Font.BOLD,18));
        WeeklyHoursField.setMaximumSize(new Dimension(300,40));

        ShiftsField = new JTextField();
        ShiftsField.setFont(new Font("Verdana",Font.BOLD,18));
        ShiftsField.setMaximumSize(new Dimension(300,40));

        WorkingHoursField = new JTextField();
        WorkingHoursField.setFont(new Font("Verdana",Font.BOLD,18));
        WorkingHoursField.setMaximumSize(new Dimension(300,40));

        WagesField = new JTextField();
        WagesField.setFont(new Font("Verdana",Font.BOLD,18));
        WagesField.setMaximumSize(new Dimension(300,40));

        panel.add(Box.createRigidArea(new Dimension(300,16)));
        panel.add(WeeklyHoursField);
        panel.add(Box.createRigidArea(new Dimension(300,31)));
        panel.add(ShiftsField);
        panel.add(Box.createRigidArea(new Dimension(300,29)));
        panel.add(WorkingHoursField);
        panel.add(Box.createRigidArea(new Dimension(300,29)));
        panel.add(WagesField);
        panel.add(Box.createRigidArea(new Dimension(300,180)));
        return panel;


    }

    public JPanel SideBar() {



        JPanel panel = new JPanel();

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 0, 5);
        GridLayout gridLayout = new GridLayout(1,1);

        panel.setLayout(flowLayout);
        panel.setBounds(0, 0, 200, 900);
        panel.setBackground(new Color(83, 21, 122));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 2;


        //Terminate button
        JPanel Terminate = new JPanel(new GridBagLayout());
        JLabel TerminateLabel = new JLabel("Terminate");
        Terminate.add(TerminateLabel,c);
        Terminate.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        Terminate.setPreferredSize(new Dimension(210,100));
        Terminate.setBackground(new Color(83, 21, 122));
        TerminateLabel.setForeground(new Color(250, 250, 250));
        TerminateLabel.setFont(new Font("Roboto", Font.BOLD, 22));
        Terminate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Terminate.setBackground(new Color(101, 25, 151));
            }
            public void mouseExited(MouseEvent e) {
                Terminate.setBackground(new Color(83, 21, 122));
            }
        });
        Terminate.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                addFulltime.terminateEmployee();
            }
        });

        // Add shifts button
        JPanel AddShifts = new JPanel(new GridBagLayout());
        JLabel AddShiftsLabel = new JLabel("Add Shifts");
        AddShifts.add(AddShiftsLabel,c);
        AddShifts.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        AddShifts.setPreferredSize(new Dimension(210,100));
        AddShifts.setBackground(new Color(83, 21, 122));
        AddShiftsLabel.setForeground(new Color(250, 250, 250));
        AddShiftsLabel.setFont(new Font("Roboto", Font.BOLD, 22));
        AddShifts.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                AddShifts.setBackground(new Color(101, 25, 151));
            }
            public void mouseExited(MouseEvent e) {
                AddShifts.setBackground(new Color(83, 21, 122));
            }
        });
        AddShifts.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                addParttime.setShifts();
            }
        });

        // Add salary button
        JPanel AddSalary = new JPanel(new GridBagLayout());
        JLabel AddSalaryLabel = new JLabel("Add Salary");
        AddSalary.add(AddSalaryLabel,c);
        AddSalary.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        AddSalary.setPreferredSize(new Dimension(210,100));
        AddSalary.setBackground(new Color(83, 21, 122));
        AddSalaryLabel.setForeground(new Color(250, 250, 250));
        AddSalaryLabel.setFont(new Font("Roboto", Font.BOLD, 22));
        AddSalary.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                AddSalary.setBackground(new Color(101, 25, 151));
            }
            public void mouseExited(MouseEvent e) {
                AddSalary.setBackground(new Color(83, 21, 122));
            }
        });
        AddSalary.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                addFulltime.setSalary();
            }
        });

        // Add part time button
        JPanel AddPartTime = new JPanel(new GridBagLayout());
        JLabel AddPartTimeLabel = new JLabel("Add Part-time");
        AddPartTime.add(AddPartTimeLabel,c);
        AddPartTime.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        AddPartTime.setPreferredSize(new Dimension(210,100));
        AddPartTime.setBackground(new Color(83, 21, 122));
        AddPartTimeLabel.setForeground(new Color(250, 250, 250));
        AddPartTimeLabel.setFont(new Font("Roboto", Font.BOLD, 22));
        AddPartTime.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                AddPartTime.setBackground(new Color(101, 25, 151));
            }
            public void mouseExited(MouseEvent e) {
                AddPartTime.setBackground(new Color(83, 21, 122));
            }
        });
        AddPartTime.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                addParttime.grabInfo();

            }
        });

        // Add full time button
        JPanel AddFullTime = new JPanel(new GridBagLayout());
        JLabel AddFullTimeLabel = new JLabel("Add Full-time");
        AddFullTime.add(AddFullTimeLabel,c);
        AddFullTime.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        AddFullTime.setPreferredSize(new Dimension(210,100));
        AddFullTime.setBackground(new Color(83, 21, 122));
        AddFullTimeLabel.setForeground(new Color(250, 250, 250));
        AddFullTimeLabel.setFont(new Font("Roboto", Font.BOLD, 22));
        AddFullTime.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                AddFullTime.setBackground(new Color(101, 25, 151));
            }
            public void mouseExited(MouseEvent e) {
                AddFullTime.setBackground(new Color(83, 21, 122));
            }
        });
        AddFullTime.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                addFulltime.grabInfo();

            }
        });

        JPanel AddWeeklyHours = new JPanel(new GridBagLayout());
        JLabel AddWeeklyHoursLabel = new JLabel("Add Weekly Hours");
        AddWeeklyHours.add(AddWeeklyHoursLabel,c);
        AddWeeklyHours.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        AddWeeklyHours.setPreferredSize(new Dimension(210,100));
        AddWeeklyHours.setBackground(new Color(83, 21, 122));
        AddWeeklyHoursLabel.setForeground(new Color(250, 250, 250));
        AddWeeklyHoursLabel.setFont(new Font("Roboto", Font.BOLD, 22));
        AddWeeklyHours.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                AddWeeklyHours.setBackground(new Color(101, 25, 151));
            }
            public void mouseExited(MouseEvent e) {
                AddWeeklyHours.setBackground(new Color(83, 21, 122));
            }
        });
        AddWeeklyHours.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                addParttime.setWeeklyHours();
            }

        });






        // Spacer Creation
        JPanel spacer = new JPanel(null);
        spacer.setPreferredSize(new Dimension(200,100));
        spacer.setBackground(new Color(83, 21, 122));
        JPanel spacer2 = new JPanel(null);
        spacer2.setPreferredSize(new Dimension(200,20));
        spacer2.setBackground(new Color(83, 21, 122));
        JPanel spacer3 = new JPanel(null);
        spacer3.setPreferredSize(new Dimension(200,94));
        spacer3.setBackground(new Color(83, 21, 130));






        panel.add(spacer3);
        panel.add(AddFullTime);
        panel.add(AddPartTime);
        panel.add(spacer2);
        panel.add(AddSalary);
        panel.add(AddShifts);
        panel.add(AddWeeklyHours);
        panel.add(spacer);
        panel.add(Terminate);
        return panel;

    }

    public JPanel NotificationBox(){
        JPanel panel = new JPanel(new FlowLayout());
        panel.setPreferredSize(new Dimension(200,20));
        panel.setBounds(244,558,516,50);
        panel.setBackground(new Color(81, 80, 80));

        Notification = new JLabel("Notification Panel");
        Notification.setFont(new Font("Verdana", Font.BOLD, 18));
        Notification.setForeground(Color.WHITE);

        panel.add(Notification);
        return panel;

    }

    public JPanel StaffEntry(){
        JPanel panel = new JPanel(new GridLayout(10,0));
        panel.setBounds(235,483,300,374);
        panel.setBackground(new Color(32, 31, 31));

        JLabel Text = new JLabel("Insert staff ID number and");
        Text.setFont(new Font("Verdana", Font.BOLD, 15));
        Text.setForeground(Color.WHITE);
        JLabel Text2 = new JLabel("click search to view details.");
        Text2.setFont(new Font("Verdana", Font.BOLD, 15));
        Text2.setForeground(Color.WHITE);

        StaffIDField = new JTextField();
        StaffIDField.setFont(new Font("Verdana",Font.BOLD,18));
        StaffIDField.setMaximumSize(new Dimension(300,15));

        JoinedCheckBox = new JCheckBox("Joined");
        JoinedCheckBox.setOpaque(false);
        JoinedCheckBox.setBackground(new Color(32, 31, 31));
        JoinedCheckBox.setForeground(Color.WHITE);
        JoinedCheckBox.setFont(new Font("Consolas",Font.BOLD,14));
        JoinedCheckBox.setSelected(false);

        TerminatedCheckBox = new JCheckBox("Terminated");
        TerminatedCheckBox.setOpaque(false);
        TerminatedCheckBox.setBackground(new Color(32, 31, 31));
        TerminatedCheckBox.setForeground(Color.WHITE);
        TerminatedCheckBox.setFont(new Font("Consolas",Font.BOLD,14));
        TerminatedCheckBox.setEnabled(false);
        TerminatedCheckBox.setFocusable(false);
        TerminatedCheckBox.setSelected(false);


        panel.add(new JPanel() {{ setBackground(new Color(32, 31, 31)); }});
        panel.add(new JPanel() {{ setBackground(new Color(32, 31, 31)); }});
        panel.add(new JPanel() {{ setBackground(new Color(32, 31, 31)); }});
        panel.add(new JPanel() {{ setBackground(new Color(32, 31, 31)); }});
        panel.add(Text);
        panel.add(Text2);
        panel.add(StaffIDField);
        panel.add(JoinedCheckBox);
        panel.add(TerminatedCheckBox);
        panel.add(new JPanel() {{ setBackground(new Color(32, 31, 31)); }});
        return panel;
    }

    public JPanel SearchBtn(){
        JPanel panel = new JPanel();
        FlowLayout layout = new FlowLayout();
        panel.setLayout(layout);
        panel.setBounds(575,684,200,75);
        panel.setBackground(new Color(32, 31, 31));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 2;

        JPanel SearchBtn = new JPanel(new GridBagLayout());
        JLabel SearchLabel = new JLabel("Search");
        SearchBtn.add(SearchLabel,c);
        SearchBtn.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        SearchBtn.setPreferredSize(new Dimension(180,70));
        SearchBtn.setBackground(new Color(83, 21, 122));
        SearchLabel.setForeground(new Color(250, 250, 250));
        SearchLabel.setFont(new Font("Roboto", Font.BOLD, 22));
        SearchBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                SearchBtn.setBackground(new Color(101, 25, 151));
            }
            public void mouseExited(MouseEvent e) {
                SearchBtn.setBackground(new Color(83, 21, 122));
            }
        });

        SearchBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                addFulltime.searchEmployee();

            }
        });


        panel.add(SearchBtn);
        return panel;
    }

    public JPanel ClearBtn(){
        JPanel panel = new JPanel();
        FlowLayout layout = new FlowLayout();
        panel.setLayout(layout);
        panel.setBounds(582,770,185,75);
        panel.setBackground(new Color(32, 31, 31));
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 2;

        JPanel ClearBtn = new JPanel(new GridBagLayout());
        JLabel ClearLabel = new JLabel("Clear All");
        ClearBtn.add(ClearLabel,c);
        ClearBtn.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        ClearBtn.setPreferredSize(new Dimension(180,70));
        ClearBtn.setBackground(new Color(83, 21, 122));
        ClearLabel.setForeground(new Color(250, 250, 250));
        ClearLabel.setFont(new Font("Roboto", Font.BOLD, 22));
        ClearBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ClearBtn.setBackground(new Color(101, 25, 151));
            }
            public void mouseExited(MouseEvent e) {
                ClearBtn.setBackground(new Color(83, 21, 122));
            }
        });

        ClearBtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                clearFields();
                StaffIDField.setText("");
                revalidate();
                repaint();
            }
        });


        panel.add(ClearBtn);
        return panel;
    }



    // Clear fields method which clears all text fields in the GUI when called
    public void clearFields(){
        StaffNameField.setText("");
        VacancyField.setText("");
        JobTypeField.setText("");
        DesignationField.setText("");
        QualificationField.setText("");
        JobDateField.setText("");
        AppointedByField.setText("");
        SalaryField.setText("");
        WeeklyHoursField.setText("");
        ShiftsField.setText("");
        WorkingHoursField.setText("");
        WagesField.setText("");
        JoinedCheckBox.setSelected(false);
        TerminatedCheckBox.setSelected(false);

        revalidate();
        repaint();
    }

    // Methods for notification box which can be called by other classes to report errors to the user
    public void setWeeklyHoursFailure(){
        WeeklyHoursField.setText("Failed to set weekly hours! Please check all entries :(");
        revalidate();
    }

    public void setWeeklyHoursSuccess(){
        WeeklyHoursField.setText("Weekly hours updated successfully!");
    }

    public void fileCreationSuccess(){
        Notification.setText("Staff added successfully!");
        revalidate();
        repaint();
    }

    public void fileCreationFailure(){
        Notification.setText("Staff addition failed! Please check all entries :(");
        revalidate();
        repaint();
    }

    public void shiftAdditionFailure() {
        Notification.setText("Shift addition failed! Please check all entries :(");
        revalidate();
        repaint();
    }

    public void salaryAdditionFailure(){
        Notification.setText("Failed to set salary! Please check all entries :(");
        revalidate();
        repaint();
    }

    public void salaryAdditionSuccess(){
        Notification.setText("Salary updated successfully!");
        revalidate();
    }

    public void shiftAdditionSuccess(){
        Notification.setText("Shifts added successfully!");
        revalidate();
        repaint();
    }

    public void alreadyTerminated(){
        Notification.setText("Staff was already terminated!");
        revalidate();
        repaint();
    }

    public void searchFailure(){
        Notification.setText("ID not found! Please check staff ID :(");
        revalidate();
    }

    public void searchSuccess(){
        Notification.setText("Staff found successfully!");
        revalidate();
    }

    public void staffTerminated(){
        Notification.setText("Staff was terminated successfully!");
        revalidate();
        repaint();
    }

    public void terminationFailure(){
        Notification.setText("Staff termination error! Please check staff ID :(");
        revalidate();
    }

    public void searchNumberEntryFailure() {
        Notification.setText("Staff ID must be an integer! Please try again.");
        StaffIDField.setText("");
        revalidate();
        repaint();
    }

    // Beginning of my getters/setters for all variables
    private int StaffID;
    private String StaffName;
    private int VacancyNumber;
    private String JobType;
    private String Designation;
    private String Qualification;
    private int JoinDate;
    private String AppointedBy;
    private int Salary;
    private float WeeklyHours;
    private String Shifts;
    private String WorkingHours;
    private boolean joined;
    private float Wages;

    public int getStaffID() {
        return Integer.parseInt(StaffIDField.getText());}
    public void setStaffID(int StaffID) {
        this.StaffID = StaffID;}

    public String getStaffName() {
        return StaffNameField.getText();}
    public void setStaffName(String StaffName) {
        this.StaffName = StaffName;}

    public int getVacancyNumber() {
        return Integer.parseInt(VacancyField.getText());}
    public void setVacancyNumber(int VacancyNumber) {
        this.VacancyNumber = VacancyNumber;}

    public String getJobType() {
        return JobTypeField.getText();}
    public void setJobType(String JobType) {
        this.JobType = JobType;}

    public String getDesignation() {
        return DesignationField.getText();}
    public void setDesignation(String Designation) {
        this.Designation = Designation;}

    public String getQualification() {
        return QualificationField.getText();}
    public void setQualification(String Qualification) {
        this.Qualification = Qualification;}

    public int getJoinDate() {
        return Integer.parseInt(JobDateField.getText());}
    public void setJoinDate(int JoinDate) {
        this.JoinDate = JoinDate;}

    public String getAppointedBy() {
        return AppointedByField.getText();}
    public void setAppointedBy(String AppointedBy) {
        this.AppointedBy = AppointedBy;}

    public int getSalary() {
        return Integer.parseInt(SalaryField.getText());}
    public void setSalary(int Salary) {
        this.Salary = Salary;}

    public float getWeeklyHours() {
        return Float.parseFloat(WeeklyHoursField.getText());}
    public void setWeeklyHours(float WeeklyHours) {
        this.WeeklyHours = WeeklyHours;}

    public String getShifts() {
        return ShiftsField.getText();}
    public void setShifts(String Shifts) {
        this.Shifts = Shifts;}

    public String getWorkingHours() {
        return WorkingHoursField.getText();}
    public void setWorkingHours(String WorkingHours) {
        this.WorkingHours = WorkingHours;
    }
    public boolean isJoined() {
        return joined;}
    public void setJoined(boolean joined) {
        this.joined = joined;}

    public float getWages() {
        return Float.parseFloat(WagesField.getText());}
    public void setWages(float Wages) {
        this.Wages = Wages;}




    public static void main(String[] args) {
        new MyGUI().setVisible(true);

    }
}