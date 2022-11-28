public class Student implements Eligible {
    String name;
    String id;
    String branch;
    float cgpa;
    String location;
    PreferenceOrder preferenceOrder;

    public Student(String name, String id, String branch, float cgpa, String location, PreferenceOrder preferenceOrder) {
        this.name = name;
        this.id = id;
        this.branch = branch;
        this.cgpa = cgpa;
        this.location = location;
        this.preferenceOrder = preferenceOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public PreferenceOrder getPreferenceOrder() {
        return preferenceOrder;
    }

    public void setPreferenceOrder(PreferenceOrder preferenceOrder) {
        this.preferenceOrder = preferenceOrder;
    }

    public void acceptAllotment() {
        // To be completed
        System.out.println("Accepted allotment");
    }

    public void rejectAllotment() {
        // To be completed
        System.out.println("Rejected allotment");
    }

    public void withdraw() {
        // To be completed
        System.out.println("Withdrawn from allotment");
    }
}
