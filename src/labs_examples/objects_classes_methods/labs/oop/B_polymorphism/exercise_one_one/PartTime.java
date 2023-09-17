package labs_examples.objects_classes_methods.labs.oop.B_polymorphism.exercise_one_one;

public class PartTime extends PersonalDetails {
    protected int contractedHours;
    protected double hourlyWage;
    protected String role;

    public PartTime(String employeeName, int employeeAge, String startDate, int contractedHours, double hourlyWage, String role) {
        super(employeeName, employeeAge, startDate);
        this.contractedHours = contractedHours;
        this.hourlyWage = hourlyWage;
        this.role = role;
    }

    public void setContractedHours(int contractedHours) {
        this.contractedHours = contractedHours;
    }

    public int getContractedHours() {
        return contractedHours;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public double calculateSalary() {
        return contractedHours * hourlyWage;
    }
    // example of method overloading:
    public void contractUpdate(int newHours) {
        setContractedHours(newHours);
    }

    public void contractUpdate(double newWage) {
        setHourlyWage(newWage);
    }

    public void contractUpdate(String newRole) {
        setRole(newRole);
    }

    @Override
    public void printDetails() {
        System.out.println("Name: " + getEmployeeName()
        + "\nAge: " + getEmployeeAge()
        + "\nRole: " + getRole()
        + "\nStart Date: " + getStartDate()
        + "\nContracted Hours: " + getContractedHours()
        + "\nHourly Wage: " + getHourlyWage() + " SEK" +
          "\nWeekly Wage: " + calculateSalary() + " SEK");
    }
}
