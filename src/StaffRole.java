public enum StaffRole {
    CHEF("Köksmästare"),
    SERVER("Servitör"),
    COOK("Kock"),
    BARTENDER("Bartender");

    private final String displayName;

    StaffRole(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName; // Optional: use display name directly
    }
}