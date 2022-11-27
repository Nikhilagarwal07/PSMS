public class ITStation extends Station {
    private String domain;
    private String techStack;
    private String[] licenses;
    private double offshoot;

    public ITStation(String location, int stipend, String[] branches, double cutoff, int capacity, String domain, String techStack, String[] licenses, double offshoot) {
        super(location, stipend, branches, cutoff, capacity);
        this.domain = domain;
        this.techStack = techStack;
        this.licenses = licenses;
        this.offshoot = offshoot;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public String[] getLicenses() {
        return licenses;
    }

    public void setLicenses(String[] licenses) {
        this.licenses = licenses;
    }

    public double getOffshoot() {
        return offshoot;
    }

    public void setOffshoot(double offshoot) {
        this.offshoot = offshoot;
    }
}
