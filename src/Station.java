import java.util.*;

public class Station {
    private int id;
    private String name;
    private int capacity;
    private int occupied;
    private ArrayList<String> compulsorySubjects;
    private ArrayList<String> branches;

    public Station(int id, String name, int capacity, ArrayList<String> compulsorySubjects, ArrayList<String> branches) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.occupied = 0;
        this.compulsorySubjects = compulsorySubjects;
        this.branches = branches;
    }

    public Station (String line) {
        try {
            String[] data = line.split(",");
    
            this.id = Integer.parseInt(data[0]);
            this.name = data[1];
            this.capacity = Integer.parseInt(data[2]);
            this.occupied = 0;
            this.compulsorySubjects = new ArrayList<String>();
            for (int i = 3; i < data.length - 1; i++) {
                this.compulsorySubjects.add(data[i]);
            }
    
            this.branches = new ArrayList<String>();
            String[] branchData = data[data.length - 1].split(" ");
            for (int i = 1; i < branchData.length; i++) {
                this.branches.add(branchData[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error occured while parsing line in Station constructor.");
            e.printStackTrace();
        }
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getOccupied() {
        return this.occupied;
    }

    public boolean isOccupied() {
        return this.occupied == this.capacity;
    }

    public void incrementCapacity() {
        this.occupied++;
    }

    public void decrementCapacity() {
        this.occupied--;
    }

    public ArrayList<String> getCompulsorySubjects() {
        return this.compulsorySubjects;
    }

    public ArrayList<String> getBranches() {
        return this.branches;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    public void setCompulsorySubjects(ArrayList<String> compulsorySubjects) {
        this.compulsorySubjects = compulsorySubjects;
    }

    public void setBranches(ArrayList<String> branches) {
        this.branches = branches;
    }

    public String toString() {
        return "Station " + this.id + " " + this.name + ", subjects = " + this.compulsorySubjects + " branches = " + this.branches + "\n";
    }
}
