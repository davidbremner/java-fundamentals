package labs_examples.objects_classes_methods.labs.oop.B_polymorphism.exercise_one_one;

public class FullTime extends PersonalDetails{
    protected static final int CONTRACTEDHOURS = 40;
    protected static final int MONTHSINYEAR = 12;
    protected double monthlySalary;
    protected String role;

    public FullTime(String employeeName, int employeeAge, String startDate, double monthlySalary, String role) {
        super(employeeName, employeeAge, startDate);
        this.monthlySalary = monthlySalary;
        this.role = role;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getRole() {
        return role;
    }

    public int getContractedHours() {
        return CONTRACTEDHOURS;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double calculateSalary() {
        return monthlySalary * MONTHSINYEAR;
    }

    @Override
    public void printDetails() {
        System.out.println("Name: " + getEmployeeName()
                + "\nAge: " + getEmployeeAge()
                + "\nRole: " + getRole()
                + "\nStart Date: " + getStartDate()
                + "\nContracted Hours: " + getContractedHours()
                + "\nMonthly Salary: " + getMonthlySalary() + " SEK" +
                  "\nYearly Wage: " + calculateSalary() + " SEK");
    }
}
