public class CoreStation extends Station {
    private String domain;

    public CoreStation(String location, int stipend, String[] branches, double cutoff, int capacity, String domain) {
        super(location, stipend, branches, cutoff, capacity);
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
