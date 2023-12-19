package SeleniumHandsOn.enums;

public enum severity {
    CRITICAL(1), HIGH(2), MEDIUM(3);

    public int getFixingHrs() {
        return fixingHrs;
    }

    public void setFixingHrs(int fixingHrs) {
        this.fixingHrs = fixingHrs;
    }

    private int fixingHrs;

    private severity(int hours) {
        fixingHrs = hours;
    }
}
