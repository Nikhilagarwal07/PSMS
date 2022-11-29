import java.io.*;

public class App {
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    public static void main(String[] args) throws Exception {
        clearScreen();

        Student student = new Student(new File("src\\Student.csv"), new File("src\\PreferenceOrder.csv"));
        System.out.println(student);
        System.out.println(student.getPreferenceOrder());
    }
}
