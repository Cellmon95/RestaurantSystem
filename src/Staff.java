public class Staff {

    String firstName;
    String lastName;
    StaffRole role;
    String SSN;

    public String getSSN() {
        return SSN;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public StaffRole getRole() {
        return role;
    }

    public Staff(String firstName, String lastName, String SSN, StaffRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.role = role;

    }
}
