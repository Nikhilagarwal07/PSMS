public class SecondYear implements Student {
    private String name;
    private String id;
    private String branch;
    private float cgpa;
    private String location;
    private PreferenceOrder preferenceOrder;

    public SecondYear(String name, String id, String branch, float cgpa) {
        this.name = name;
        this.id = id;
        this.branch = branch;
        this.cgpa = cgpa;
        this.location = "Not Allotted";
        this.preferenceOrder = new PreferenceOrder();
    }

    public void setPreference() {
        
    }

    public void getPreference(PreferenceOrder preferenceOrder) {
        
    }

    public void acceptAllotment() {
        
    }

    public void rejectAllotment() {
        
    }

    public void setLocation(String location) {
        
    }

    public String viewStations() {
        return null;
    }
    
}
