import java.io.*;
import java.util.*;

public class App {
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    public static void main(String[] args) throws Exception {
        clearScreen();

        ArrayList<Station> adsfhadshf = new ArrayList<Station>();
        adsfhadshf.add(null);

        Admin admin = new Admin();
        admin.addSecondYearStations(new File("src\\Stations.csv"));

        SecondYear student1 = new SecondYear(new File("src\\Student.csv"), new File("src\\PreferenceOrder.csv"), admin.getSecondYearStations());
        SecondYear student2 = new SecondYear(new File("src\\Student.csv"), new File("src\\PreferenceOrder.csv"), admin.getSecondYearStations());
        SecondYear student3 = new SecondYear(new File("src\\Student.csv"), new File("src\\PreferenceOrder.csv"), admin.getSecondYearStations());

        student1.setCgpa(1);
        student1.setName("Student1");
        student2.setCgpa(9.5f);
        student2.setName("HelloWorld");
        student3.setCgpa(8);

        admin.addSecondYearStudent(student1);
        admin.addSecondYearStudent(student2);
        admin.addSecondYearStudent(student3);

        ArrayList<SecondYear> arr = new ArrayList<SecondYear>();
        arr.add(student1);

        // System.out.println(student1.hasAccepted());
        // System.out.println(student1.hasRejected());
        // System.out.println(student1.hasWithdrawn());

        arr.add(student2);
        arr.add(student3);

        Collections.sort(arr);

        // System.out.println(arr);

        HashMap<SecondYear, Station> prev = new HashMap<SecondYear, Station>();
        HashMap<SecondYear, Station> secondYearAllocations = Allocator.allocate(prev, admin.getSecondYearStudents());
        for (Map.Entry<SecondYear, Station> entry : secondYearAllocations.entrySet()) {
            if (entry.getValue() == null) {
                System.out.println(entry.getKey().getName() + "\t" + entry.getKey().getCgpa() + "\t\t" + "null");
            } else {
                System.out.println(entry.getKey().getName() + "\t" +entry.getKey().getCgpa() + "\t\t" + entry.getValue().getName());
            }
        }

        System.out.println();
        student3.accept();
        student2.withdraw();
        HashMap<SecondYear, Station> newAlloc = Allocator.allocate(secondYearAllocations, admin.getSecondYearStudents());
        for (Map.Entry<SecondYear, Station> entry : newAlloc.entrySet()) {
            if (entry.getValue() == null) {
                System.out.println(entry.getKey().getName() + "\t" +entry.getKey().getCgpa() + "\t\t" + "null");
            } else {
                System.out.println(entry.getKey().getName() + "\t" + entry.getKey().getCgpa() + "\t\t" + entry.getValue().getName());
            }
        }
    }
}
