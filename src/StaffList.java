import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StaffList {

    List<Staff> staffList;

    public StaffList() {
        staffList = new ArrayList<>(Arrays.asList(
                new Staff("Lucas", "Källberg", "111", StaffRole.CHEF),
                new Staff("Rolf", "Bengtson", "222", StaffRole.COOK),
                new Staff("Ragnar", "Olsson", "333", StaffRole.COOK),
                new Staff("Eva", "Svensson", "444", StaffRole.SERVER),
                new Staff("Lisa", "Larsson", "555", StaffRole.SERVER)
                ));
    }

    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    public Staff getStaff(String staffSSN) {
        for (Staff staff : staffList) {
            if (staffSSN.equalsIgnoreCase(staff.getSSN())) {
                return staff;
            }
        }
        return null;
    }

    public List<Staff> getAllStaff() {
        return staffList;
    }

    public boolean removeStaff(String staffSSN) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffSSN.equalsIgnoreCase(staffList.get(i).getSSN())) {
                staffList.remove(i);
                return true;
            }
        }
        return false;
    }
}
