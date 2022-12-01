import java.util.*;
import java.io.*;

public class Admin {
    private HashMap<Integer, Station> secondYearStations;
    private HashMap<Integer, Station> finalYearStations;
    private ArrayList<SecondYear> secondYearStudents;
    private ArrayList<FinalYear> finalYearStudents;
    private HashMap<SecondYear, Station> secondYearAllocations;
    private HashMap<FinalYear, Station> finalYearAllocations;

    public Admin() {
        this.secondYearStations = new HashMap<Integer, Station>();
        this.finalYearStations = new HashMap<Integer, Station>();
        this.secondYearStudents = new ArrayList<SecondYear>();
        this.finalYearStudents = new ArrayList<FinalYear>();
        this.secondYearAllocations = new HashMap<SecondYear, Station>();
        this.finalYearAllocations = new HashMap<FinalYear, Station>();
    }

    public HashMap<Integer, Station> getSecondYearStations() {
        return this.secondYearStations;
    }

    public HashMap<Integer, Station> getFinalYearStations() {
        return this.finalYearStations;
    }

    public ArrayList<SecondYear> getSecondYearStudents() {
        return this.secondYearStudents;
    }

    public ArrayList<FinalYear> getFinalYearStudents() {
        return this.finalYearStudents;
    }

    public HashMap<SecondYear, Station> getSecondYearAllocations() {
        return this.secondYearAllocations;
    }

    public HashMap<FinalYear, Station> getFinalYearAllocations() {
        return this.finalYearAllocations;
    }

    public void addSecondYearStation(String line) {
        Station newStation = new Station(line);
        this.secondYearStations.put(newStation.getId(), newStation);

        for (SecondYear student : this.secondYearStudents) {
            student.addStation(newStation);
        }
    }

    public void addFinalYearStation(String line) {
        Station newStation = new Station(line);
        this.finalYearStations.put(newStation.getId(), newStation);

        for (FinalYear student : this.finalYearStudents) {
            student.addStation(newStation);
        }
    }

    public void addSecondYearStations(File file) {
        ArrayList<Station> tempStations = new ArrayList<Station>();

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Station station = new Station(line);
                tempStations.add(station);
            }
            
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred while reading stations from file.");
            e.printStackTrace();
        }

        for (SecondYear student : this.secondYearStudents) {
            student.addStations(tempStations);
        }

        for (Station station : tempStations) {
            this.secondYearStations.put(station.getId(), station);
        }
    }

    public void addFinalYearStations(File file) {
        ArrayList<Station> tempStations = new ArrayList<Station>();

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Station station = new Station(line);
                tempStations.add(station);
            }
            
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred while reading stations from file.");
            e.printStackTrace();
        }

        for (FinalYear student : this.finalYearStudents) {
            student.addStations(tempStations);
        }

        for (Station station : tempStations) {
            this.finalYearStations.put(station.getId(), station);
        }
    }

    public void addSecondYearStudent(File studentFile, File preferenceOrderFile) {
        SecondYear newStudent = new SecondYear(studentFile, preferenceOrderFile, this.secondYearStations);
        this.secondYearStudents.add(newStudent);
    }

    public void addSecondYearStudent(SecondYear secondYear) {
        this.secondYearStudents.add(secondYear);
    }

    public void addFinalYearStudent(File studentFile, File preferenceOrderFile, String resume) {
        FinalYear newStudent = new FinalYear(studentFile, preferenceOrderFile, this.finalYearStations, resume);
        this.finalYearStudents.add(newStudent);
    }

    public void addFinalYearStudent(FinalYear finalYear) {
        this.finalYearStudents.add(finalYear);
    }
}
