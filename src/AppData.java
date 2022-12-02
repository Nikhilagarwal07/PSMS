import java.util.*;

public class AppData {
    /*
     * This class is used to store all the data that is used by the application.
     * This class has only static fields and methods. It is not instantiated.
     * Its only methods are getters and setters. All other methods are in admin
     * class, and access is provided to them through getters and setters only.
     */

    private static HashMap<Integer, Station> secondYearStations;
    private static HashMap<Integer, Station> finalYearStations;
    private static ArrayList<SecondYear> secondYearStudents;
    private static ArrayList<FinalYear> finalYearStudents;
    private static HashMap<SecondYear, Station> secondYearAllocations;
    private static HashMap<FinalYear, Station> finalYearAllocations;

    public static HashMap<Integer, Station> getSecondYearStations() {
        return AppData.secondYearStations;
    }

    public static void setSecondYearStations(HashMap<Integer, Station> secondYearStations) {
        AppData.secondYearStations = secondYearStations;
    }

    public static HashMap<Integer, Station> getFinalYearStations() {
        return AppData.finalYearStations;
    }

    public static void setFinalYearStations(HashMap<Integer, Station> finalYearStations) {
        AppData.finalYearStations = finalYearStations;
    }

    public static ArrayList<SecondYear> getSecondYearStudents() {
        return AppData.secondYearStudents;
    }

    public static void setSecondYearStudents(ArrayList<SecondYear> secondYearStudents) {
        AppData.secondYearStudents = secondYearStudents;
    }

    public static ArrayList<FinalYear> getFinalYearStudents() {
        return AppData.finalYearStudents;
    }

    public static void setFinalYearStudents(ArrayList<FinalYear> finalYearStudents) {
        AppData.finalYearStudents = finalYearStudents;
    }

    public static HashMap<SecondYear, Station> getSecondYearAllocations() {
        return AppData.secondYearAllocations;
    }

    public static void setSecondYearAllocations(HashMap<SecondYear, Station> secondYearAllocations) {
        AppData.secondYearAllocations = secondYearAllocations;
    }

    public static HashMap<FinalYear, Station> getFinalYearAllocations() {
        return AppData.finalYearAllocations;
    }

    public static void setFinalYearAllocations(HashMap<FinalYear, Station> finalYearAllocations) {
        AppData.finalYearAllocations = finalYearAllocations;
    }
}
