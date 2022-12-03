import java.util.*;

public class App {
    enum State {
        HOME,
        ADMIN_LOGIN,
        STUDENT_LOGIN,
        ADMIN_HOME
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void main(String[] args) throws Exception {
        /*
        ArrayList<Station> adsfhadshf = new ArrayList<Station>();
        adsfhadshf.add(null);

        Admin admin = new Admin();
        admin.t.start();
        admin.addSecondYearStations(new File("src\\Stations.csv"));

        SecondYear student1 = new SecondYear(new File("src\\Student.csv"), new File("src\\PreferenceOrder.csv"), admin.getSecondYearStations());
        SecondYear student2 = new SecondYear(new File("src\\Student.csv"), new File("src\\PreferenceOrder.csv"), admin.getSecondYearStations());
        SecondYear student3 = new SecondYear(new File("src\\Student.csv"), new File("src\\PreferenceOrder.csv"), admin.getSecondYearStations());

        student1.t.start();
        student2.t.start();
        student3.t.start();

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

        // Collections.sort(arr);

        // System.out.println(arr);

        // HashMap<SecondYear, Station> prev = new HashMap<SecondYear, Station>();
        admin.setSecondYearAllocations(Allocator.allocate(admin.getSecondYearAllocations(), admin.getSecondYearStudents()));
        for (Map.Entry<SecondYear, Station> entry : admin.getSecondYearAllocations().entrySet()) {
            if (entry.getValue() == null) {
                System.out.println(entry.getKey().getName() + "\t" + entry.getKey().getCgpa() + "\t\t" + "null");
            } else {
                System.out.println(entry.getKey().getName() + "\t" +entry.getKey().getCgpa() + "\t\t" + entry.getValue().getName());
            }
        }

        System.out.println();
        student3.accept();
        student2.withdraw();

        admin.setSecondYearAllocations(Allocator.allocate(admin.getSecondYearAllocations(), admin.getSecondYearStudents()));
        for (Map.Entry<SecondYear, Station> entry : admin.getSecondYearAllocations().entrySet()) {
            if (entry.getValue() == null) {
                System.out.println(entry.getKey().getName() + "\t" +entry.getKey().getCgpa() + "\t\t" + "null");
            } else {
                System.out.println(entry.getKey().getName() + "\t" + entry.getKey().getCgpa() + "\t\t" + entry.getValue().getName());
            }
        }

        */
        
        System.out.print("\033[H\033[2J");  
        System.out.flush();

        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        State state = State.HOME;

        while (isRunning) {
            clearScreen();

            switch (state) {
                case HOME:
                    System.out.println("Welcome to the Placement Portal");
                    System.out.println("1. Admin Login");
                    System.out.println("2. Student Login");
                    System.out.println("3. Exit");
                    System.out.print("Enter your choice: ");
                    
                    int choice = sc.nextInt();
                    
                    if (choice == 1) {
                        state = State.ADMIN_LOGIN;
                        clearScreen();
                    } else if (choice == 2) {
                        state = State.STUDENT_LOGIN;
                        clearScreen();
                    } else if (choice == 3) {
                        isRunning = false;
                        clearScreen();
                    } else if (choice == 4) {
                        clearScreen();
                    } else {
                        clearScreen();
                        System.out.println("Invalid choice");
                    }

                    break;
                
                case ADMIN_LOGIN:
                    System.out.println("Admin Login");
                    System.out.print("Enter your password: ");
                    String password = sc.next();

                    if (password.equals("p")) {
                        state = State.ADMIN_HOME;
                        clearScreen();
                    } else {
                        System.out.println("Invalid password");
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        state = State.HOME;
                        clearScreen();
                    }

                    break;
                
                case STUDENT_LOGIN:
                    System.out.println("Student Login");
                    break;

                case ADMIN_HOME:
                    Admin admin = new Admin(sc);
                    admin.start();
                    admin.t.join();
                    state = State.HOME;
                    break;
                
                default:
                    break;
            }
        }
        
        sc.close();
    }
}
