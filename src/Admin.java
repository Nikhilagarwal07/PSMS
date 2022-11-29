import java.util.*;
import java.io.*;

public class Admin {
    private ArrayList<Station> stations;
    private ArrayList<SecondYear> secondYearStudents;
    private ArrayList<FinalYear> finalYearStudents;
    HashMap<Integer, Integer> secondYearAllocations;
    HashMap<Integer, Integer> finalYearAllocations;

    public Admin(ArrayList<Station> stations, ArrayList<SecondYear> secondYearStudents, ArrayList<FinalYear> finalYearStudents) {
        this.stations = stations;
        this.secondYearStudents = secondYearStudents;
        this.finalYearStudents = finalYearStudents;
        this.secondYearAllocations = new HashMap<Integer, Integer>();
        this.finalYearAllocations = new HashMap<Integer, Integer>();
        Collections.sort(this.secondYearStudents);
        Collections.sort(this.finalYearStudents);
    }

    public void addStation(String line) {
        Station newStation = new Station(line);
        this.stations.add(newStation);

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
    }

    public void addSecondYearStudent(File studentFile, File preferenceOrderFile) {
        SecondYear newStudent = new SecondYear(studentFile, preferenceOrderFile);
        this.secondYearStudents.add(newStudent);
        newStudent.addStations(this.stations);
        Collections.sort(this.secondYearStudents);
    }

    public void addFinalYearStudent(File studentFile, File preferenceOrderFile, String resume) {
        FinalYear newStudent = new FinalYear(studentFile, preferenceOrderFile, resume);
        this.finalYearStudents.add(newStudent);
        newStudent.addStations(this.stations);
        Collections.sort(this.finalYearStudents);
    }
}
