import java.io.*;
import java.util.*;

public class App {
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    public static void main(String[] args) throws Exception {
        clearScreen();

        Student student1 = new Student(new File("src\\Student.csv"), new File("src\\PreferenceOrder.csv"));
        Student student2 = new Student(new File("src\\Student.csv"), new File("src\\PreferenceOrder.csv"));
        Student student3 = new Student(new File("src\\Student.csv"), new File("src\\PreferenceOrder.csv"));

        student1.setCgpa(1);
        student2.setCgpa(9.5f);
        student3.setCgpa(8);

        ArrayList<Student> arr = new ArrayList<Student>();
        arr.add(student1);
        arr.add(student2);
        arr.add(student3);

        Collections.sort(arr);

        System.out.println(arr);

        System.out.println(student1.getPreferenceOrder());
    }
}
