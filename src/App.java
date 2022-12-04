import java.util.*;

public class App {
    enum State {
        HOME,
        ADMIN_LOGIN,
        STUDENT_SELECT,
        ADMIN_HOME,
        SECOND_YEAR,
        FINAL_YEAR,
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
        int choice;

        while (isRunning) {
            clearScreen();

            switch (state) {
                case HOME:
                    System.out.println("Welcome to the Placement Portal");
                    System.out.println("1. Admin Login");
                    System.out.println("2. Student Login");
                    System.out.println("3. Exit");
                    System.out.print("Enter your choice: ");
                    
                    try {
                        choice = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter a number");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ie) {
                            ie.printStackTrace();
                        }

                        sc.nextLine();
                        break;
                    }
                    
                    if (choice == 1) {
                        state = State.ADMIN_LOGIN;
                    } else if (choice == 2) {
                        state = State.STUDENT_SELECT;
                    } else if (choice == 3) {
                        isRunning = false;
                    } else {
                        try {
                            System.out.println("Invalid choice");
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                
                case ADMIN_LOGIN:
                    System.out.println("Admin Login");
                    System.out.print("Enter your password: ");
                    String password = sc.next();

                    if (password.equals("p")) {
                        state = State.ADMIN_HOME;
                    } else {
                        try {
                            System.out.println("Invalid password");
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        state = State.HOME;
                    }
                    break;
                
                case STUDENT_SELECT:
                    System.out.println("Student Login");
                    System.out.println("1. Second Year");
                    System.out.println("2. Final Year");
                    System.out.println("3. Back");
                    System.out.print("Enter your choice: ");

                    try {
                        choice = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter a number");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ie) {
                            ie.printStackTrace();
                        }

                        sc.nextLine();
                        break;
                    }

                    if (choice == 1) {
                        state = State.SECOND_YEAR;
                    } else if (choice == 2) {
                        state = State.FINAL_YEAR;
                    } else if (choice == 3) {
                        state = State.HOME;
                    } else {
                        try {
                            System.out.println("Invalid choice");
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;

                case ADMIN_HOME:
                    Admin admin = new Admin(sc);
                    admin.start();
                    admin.t.join();
                    state = State.HOME;
                    break;
                
                case SECOND_YEAR:
                    System.out.println("Second Year Login");
                    System.out.print("Enter your ID: ");
                    String secondYearId = sc.next();

                    SecondYear secondYear = null;
                    for (SecondYear s : AppData.getSecondYearStudents()) {
                        if (s.getId().equals(secondYearId)) {
                            secondYear = s;
                            break;
                        }
                    }

                    if (secondYear == null) {
                        try {
                            System.out.println("Invalid ID");
                            state = State.STUDENT_SELECT;
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        secondYear.start();
                        secondYear.t.join();
                        state = State.STUDENT_SELECT;
                    }

                    break;

                case FINAL_YEAR:
                    System.out.println("Final Year Login");
                    System.out.print("Enter your ID: ");
                    String finalYearId = sc.next();

                    FinalYear finalYear = null;
                    for (FinalYear s : AppData.getFinalYearStudents()) {
                        if (s.getId().equals(finalYearId)) {
                            finalYear = s;
                            break;
                        }
                    }

                    if (finalYear == null) {
                        try {
                            System.out.println("Invalid ID");
                            state = State.STUDENT_SELECT;
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        finalYear.start();
                        finalYear.t.join();
                        state = State.STUDENT_SELECT;
                    }
                    break;
            }
        }
        
        sc.close();
    }
}
