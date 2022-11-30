import java.util.*;
import java.io.*;

public class Admin {
    private ArrayList<Station> secondYearStations;
    private ArrayList<Station> finalYearStations;
    private ArrayList<SecondYear> secondYearStudents;
    private ArrayList<FinalYear> finalYearStudents;
    HashMap<SecondYear, Station> secondYearAllocations;
    HashMap<FinalYear, Station> finalYearAllocations;

    public Admin() {
        this.secondYearStations = new ArrayList<Station>();
        this.finalYearStations = new ArrayList<Station>();
        this.secondYearStudents = new ArrayList<SecondYear>();
        this.finalYearStudents = new ArrayList<FinalYear>();
        this.secondYearAllocations = new HashMap<SecondYear, Station>();
        this.finalYearAllocations = new HashMap<FinalYear, Station>();
    }

    public void addSecondYearStation(String line) {
        Station newStation = new Station(line);
        this.secondYearStations.add(newStation);

        for (SecondYear student : this.secondYearStudents) {
            student.addStation(newStation);
        }

        for (FinalYear student : this.finalYearStudents) {
            student.addStation(newStation);
        }
    }

    public void addFinalYearStation(String line) {
        Station newStation = new Station(line);
        this.finalYearStations.add(newStation);

        for (SecondYear student : this.secondYearStudents) {
            student.addStation(newStation);
        }

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

        this.secondYearStations.addAll(tempStations);
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

        this.finalYearStations.addAll(tempStations);
    }

    public void addSecondYearStudent(File studentFile, File preferenceOrderFile) {
        SecondYear newStudent = new SecondYear(studentFile, preferenceOrderFile);
        this.secondYearStudents.add(newStudent);
        newStudent.addStations(this.secondYearStations);
        Collections.sort(this.secondYearStudents);
    }

    public void addFinalYearStudent(File studentFile, File preferenceOrderFile, String resume) {
        FinalYear newStudent = new FinalYear(studentFile, preferenceOrderFile, resume);
        this.finalYearStudents.add(newStudent);
        newStudent.addStations(this.secondYearStations);
        Collections.sort(this.finalYearStudents);
    }
}
