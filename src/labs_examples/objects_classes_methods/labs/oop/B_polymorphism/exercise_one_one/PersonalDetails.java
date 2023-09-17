package labs_examples.objects_classes_methods.labs.oop.B_polymorphism.exercise_one_one;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonalDetails implements Employee{
    protected String employeeName;
    protected int employeeAge;
    protected String startDate;

    public PersonalDetails(String employeeName, int employeeAge, String startDate) {
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.startDate = startDate;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }

    @Override
    public void calculateStartDate() {
        Date todaysDate = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy");
        String employmentDate = "";
        try {
            Date dateOfEmployment = timeFormat.parse(getStartDate());
            long timeDifference = dateOfEmployment.getTime() - todaysDate.getTime();
            long numOfDays = (timeDifference / (1000 * 60 * 60 * 24)) % 365; // calculation converts milliseconds to days
            if(numOfDays > 0) {
                System.out.println(getEmployeeName() + " starts in " + (numOfDays + 1) + " days.");
            } else if(numOfDays < 0) {
                // making it a positive number with below calculation
                System.out.println(getEmployeeName() + " has worked for the company for " + (numOfDays - (numOfDays * 2)) + " days.");
            } else {
                if(dateOfEmployment.getDate() == todaysDate.getDate()) {
                    System.out.println(getEmployeeName() + " starts today!");
                } else {
                    System.out.println(getEmployeeName() + " starts tomorrow!");
                }
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printDetails() {
        System.out.println("Name: " + getEmployeeName()
                + "\nAge: " + getEmployeeAge()
                + "\nStart Date: " + getStartDate());
    }
}
