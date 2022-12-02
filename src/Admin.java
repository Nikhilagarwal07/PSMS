import java.util.*;
import java.io.*;

public class Admin implements Runnable {
    /*
     * This is the Admin class. 
     * It is used for allotment, managing students, and managing stations.
     * Only one instance of admin will be available at a time, created at login
     * and destroyed at logout.
     */

    public Thread t;

    public Admin() {
        this.t = new Thread(this, "Admin");
    }

    public void run() {
        System.out.println("Admin thread started.");
    }

    public HashMap<Integer, Station> getSecondYearStations() {
        return AppData.getSecondYearStations();
    }

    public void setSecondYearStations(HashMap<Integer, Station> secondYearStations) {
        AppData.setSecondYearStations(secondYearStations);
    }

    public HashMap<Integer, Station> getFinalYearStations() {
        return AppData.getFinalYearStations();
    }

    public void setFinalYearStations(HashMap<Integer, Station> finalYearStations) {
        AppData.setFinalYearStations(finalYearStations);
    }

    public ArrayList<SecondYear> getSecondYearStudents() {
        return AppData.getSecondYearStudents();
    }

    public void setSecondYearStudents(ArrayList<SecondYear> secondYearStudents) {
        AppData.setSecondYearStudents(secondYearStudents);
    }

    public ArrayList<FinalYear> getFinalYearStudents() {
        return AppData.getFinalYearStudents();
    }

    public void setFinalYearStudents(ArrayList<FinalYear> finalYearStudents) {
        AppData.setFinalYearStudents(finalYearStudents);
    }

    public HashMap<SecondYear, Station> getSecondYearAllocations() {
        return AppData.getSecondYearAllocations();
    }

    public void setSecondYearAllocations(HashMap<SecondYear, Station> secondYearAllocations) {
        AppData.setSecondYearAllocations(secondYearAllocations);
    }

    public HashMap<FinalYear, Station> getFinalYearAllocations() {
        return AppData.getFinalYearAllocations();
    }

    public void setFinalYearAllocations(HashMap<FinalYear, Station> finalYearAllocations) {
        AppData.setFinalYearAllocations(finalYearAllocations);
    }

    public void addSecondYearStation(String line) {
        Station newStation = new Station(line);
        HashMap<Integer, Station> secondYearStations = this.getSecondYearStations();
        secondYearStations.put(newStation.getId(), newStation);
        this.setSecondYearStations(secondYearStations);

        ArrayList<SecondYear> secondYearStudents = this.getSecondYearStudents();
        for (SecondYear student : secondYearStudents) {
            student.addStation(newStation);
        }
        this.setSecondYearStudents(secondYearStudents);
    }

    public void addFinalYearStation(String line) {
        Station newStation = new Station(line);
        HashMap<Integer, Station> finalYearStations = this.getFinalYearStations();
        finalYearStations.put(newStation.getId(), newStation);
        this.setFinalYearStations(finalYearStations);

        ArrayList<FinalYear> finalYearStudents = this.getFinalYearStudents();
        for (FinalYear student : finalYearStudents) {
            student.addStation(newStation);
        }
        this.setFinalYearStudents(finalYearStudents);
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

        ArrayList<SecondYear> secondYearStudents = this.getSecondYearStudents();
        for (SecondYear student : secondYearStudents) {
            student.addStations(tempStations);
        }
        this.setSecondYearStudents(secondYearStudents);

        HashMap<Integer, Station> secondYearStations = this.getSecondYearStations();
        for (Station station : tempStations) {
            secondYearStations.put(station.getId(), station);
        }
        this.setSecondYearStations(secondYearStations);
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

        for (FinalYear student : this.getFinalYearStudents()) {
            student.addStations(tempStations);
        }

        HashMap<Integer, Station> finalYearStations = this.getFinalYearStations();
        for (Station station : tempStations) {
            finalYearStations.put(station.getId(), station);
        }

        this.setFinalYearStations(finalYearStations);
    }

    public void addSecondYearStudent(File studentFile, File preferenceOrderFile) {
        SecondYear newStudent = new SecondYear(studentFile, preferenceOrderFile, AppData.getSecondYearStations());
        ArrayList<SecondYear> secondYearStudents = this.getSecondYearStudents();
        secondYearStudents.add(newStudent);
        this.setSecondYearStudents(secondYearStudents);
    }

    public void addSecondYearStudent(SecondYear secondYear) {
        ArrayList<SecondYear> secondYearStudents = this.getSecondYearStudents();
        secondYearStudents.add(secondYear);
        this.setSecondYearStudents(secondYearStudents);
    }

    public void addFinalYearStudent(File studentFile, File preferenceOrderFile, String resume) {
        FinalYear newStudent = new FinalYear(studentFile, preferenceOrderFile, AppData.getFinalYearStations(), resume);
        ArrayList<FinalYear> finalYearStudents = this.getFinalYearStudents();
        finalYearStudents.add(newStudent);
        this.setFinalYearStudents(finalYearStudents);
    }

    public void addFinalYearStudent(FinalYear finalYear) {
        ArrayList<FinalYear> finalYearStudents = this.getFinalYearStudents();
        finalYearStudents.add(finalYear);
        this.setFinalYearStudents(finalYearStudents);
    }
}
