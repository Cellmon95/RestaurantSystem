public class Staff {

    String firstName;
    String lastName;
    StaffRole role;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public StaffRole getRole() {
        return role;
    }

    public Staff(String firstName, String lastName, StaffRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
}
