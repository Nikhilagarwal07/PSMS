public class Station {
    protected String location;
    protected int stipend;
    protected String[] branches;
    protected double cutoff;
    protected int capacity;

    public Station(String location, int stipend, String[] branches, double cutoff, int capacity) {
        this.location = location;
        this.stipend = stipend;
        this.branches = branches;
        this.cutoff = cutoff;
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStipend() {
        return stipend;
    }

    public void setStipend(int stipend) {
        this.stipend = stipend;
    }

    public String[] getBranches() {
        return branches;
    }

    public void setBranches(String[] branches) {
        this.branches = branches;
    }

    public double getCutoff() {
        return cutoff;
    }

    public void setCutoff(double cutoff) {
        this.cutoff = cutoff;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
