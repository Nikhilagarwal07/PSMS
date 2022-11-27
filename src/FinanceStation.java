public class FinanceStation extends Station {
    private int offshoot;
    private String[] courses;

    public FinanceStation(String location, int stipend, String[] branches, double cutoff, int capacity, int offshoot, String[] courses) {
        super(location, stipend, branches, cutoff, capacity);
        this.offshoot = offshoot;
        this.courses = courses;
    }

    public int getOffshoot() {
        return offshoot;
    }

    public void setOffshoot(int offshoot) {
        this.offshoot = offshoot;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }
}
