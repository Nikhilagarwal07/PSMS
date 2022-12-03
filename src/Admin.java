import java.util.*;
import java.io.*;

public class Admin implements Runnable {
    /*
     * This is the Admin class. 
     * It is used for allotment, managing students, and managing stations.
     * Only one instance of admin will be available at a time, created at login
     * and destroyed at logout.
     */

    enum State {
        HOME,
        SECOND_YEAR,
        FINAL_YEAR,
        SECOND_YEAR_ALLOTMENT,
        SECOND_YEAR_STUDENTS,
        SECOND_YEAR_STATIONS,
        FINAL_YEAR_ALLOTMENT,
        FINAL_YEAR_STUDENTS,
        FINAL_YEAR_STATIONS,
    }

    public Thread t;
    public Scanner sc;
    private volatile boolean isRunning = true;
    private State state;

    public Admin(Scanner sc) {
        this.sc = sc;
        this.state = State.HOME;
    }

    public void start() {
        if (this.t == null) {
            this.t = new Thread(this, "Admin");
            this.t.start();
        }
    }

    public void run() {
        int choice;

        while (this.isRunning) {
            App.clearScreen();

            switch (state) {
                case HOME:
                    System.out.println("Admin Home");
                    System.out.println("1. Second Year");
                    System.out.println("2. Final Year");
                    System.out.println("3. Logout");
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
                        try {
                            System.out.println("Logging out...");
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
        
                        this.stop();
                    } else {
                        try {
                            System.out.println("Invalid choice");
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                
                case SECOND_YEAR:
                    System.out.println("Second Year Menu");
                    System.out.println("1. Allotment");
                    System.out.println("2. Manage Students");
                    System.out.println("3. Manage Stations");
                    System.out.println("4. Back");
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
                        state = State.SECOND_YEAR_ALLOTMENT;
                    } else if (choice == 2) {
                        state = State.SECOND_YEAR_STUDENTS;
                    } else if (choice == 3) {
                        state = State.SECOND_YEAR_STATIONS;
                    } else if (choice == 4) {
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

                case FINAL_YEAR:
                    System.out.println("Final Year Menu");
                    System.out.println("1. Allotment");
                    System.out.println("2. Manage Students");
                    System.out.println("3. Manage Stations");
                    System.out.println("4. Back");
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
                        state = State.FINAL_YEAR_ALLOTMENT;
                    } else if (choice == 2) {
                        state = State.FINAL_YEAR_STUDENTS;
                    } else if (choice == 3) {
                        state = State.FINAL_YEAR_STATIONS;
                    } else if (choice == 4) {
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
                
                case SECOND_YEAR_ALLOTMENT:
                    System.out.println("Second Year Allotment");
                    System.out.println("1. View Current Allotment");
                    System.out.println("2. Next Iteration");
                    System.out.println("3. Finalize Allotment");
                    System.out.println("4. Back");
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
                        App.clearScreen();
                        System.out.println(this.showSecondYearAllocations());
                        pressEnterToContinue(sc);
                    } else if (choice == 2) {
                        System.out.println("Are you sure you want to get next iteration? (y/n)");
                        String confirm = sc.next();
                        if (confirm.equals("y")) {
                            Allocator.allocate(this.getSecondYearAllocations(), this.getSecondYearStudents());
                            System.out.println("Next Iteration completed.");
                        } else {
                            System.out.println("Cancelled next iteration.");
                        }

                        pressEnterToContinue(sc);
                    } else if (choice == 3) {
                        App.clearScreen();
                        System.out.println(this.getSecondYearAllocations());
                        System.out.println("Are you sure you want to finalize the allotment? (y/n)");
                        String confirm = sc.next();
                        if (confirm.equals("y")) {
                            this.finalizeSecondYearAllocations(new File("FinalSecondYearAllotments.txt"));
                            System.out.println("Allotment finalized.");
                        } else {
                            System.out.println("Allotment not finalized.");
                        }

                        pressEnterToContinue(sc);
                    } else if (choice == 4) {
                        state = State.SECOND_YEAR;
                    } else {
                        try {
                            System.out.println("Invalid choice");
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    break;
                
                case SECOND_YEAR_STUDENTS:
                    break;
                
                case SECOND_YEAR_STATIONS:
                    break;
                
                case FINAL_YEAR_ALLOTMENT:
                    break;
                
                case FINAL_YEAR_STUDENTS:
                    break;
                
                case FINAL_YEAR_STATIONS:
                    break;
            }
        }
    }

    private void finalizeSecondYearAllocations(File file) {
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.showSecondYearAllocations());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        this.isRunning = false;
    }

    public void pressEnterToContinue(Scanner sc) {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
            sc.nextLine();
        } catch(Exception e) {
            e.printStackTrace();
        } 
    }

    public String showSecondYearAllocations() {
        String result = "";
        HashMap<SecondYear, Station> allocations = this.getSecondYearAllocations();
        for (Map.Entry<SecondYear, Station> entry : allocations.entrySet()) {
            result += entry.getKey().getName() + " - " + entry.getValue().getName() + "\n";
        }

        return result;
    }

    public String showFinalYearAllocations() {
        String result = "";
        HashMap<FinalYear, Station> allocations = this.getFinalYearAllocations();
        for (Map.Entry<FinalYear, Station> entry : allocations.entrySet()) {
            result += entry.getKey().getName() + " - " + entry.getValue().getName() + "\n";
        }

        return result;
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
    
    public void addSecondYearStudent(File studentFile, File preferenceOrderFile) {
        SecondYear newStudent = new SecondYear(studentFile, preferenceOrderFile, AppData.getSecondYearStations());
        this.addSecondYearStudent(newStudent);
    }
    
    public void addSecondYearStudent(SecondYear secondYear) {
        ArrayList<SecondYear> secondYearStudents = this.getSecondYearStudents();
        secondYearStudents.add(secondYear);
        this.setSecondYearStudents(secondYearStudents);
    }
    
    public void addFinalYearStudent(File studentFile, File preferenceOrderFile, String resume) {
        FinalYear newStudent = new FinalYear(studentFile, preferenceOrderFile, AppData.getFinalYearStations(), resume);
        this.addFinalYearStudent(newStudent);
    }
    
    public void addFinalYearStudent(FinalYear finalYear) {
        ArrayList<FinalYear> finalYearStudents = this.getFinalYearStudents();
        finalYearStudents.add(finalYear);
        this.setFinalYearStudents(finalYearStudents);
    }
    
    public void endSecondYearAllotment(File file) {
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            HashMap<SecondYear, Station> secondYearAllocations = this.getSecondYearAllocations();
            for (Map.Entry<SecondYear, Station> entry : secondYearAllocations.entrySet()) {
                SecondYear student = entry.getKey();
                student.accept();
                
                Station station = entry.getValue();
                bw.write(student.getName() + " " + student.getId() + " " + station.getName());
                bw.newLine();
            }
            
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error occurred while writing to file.");
            e.printStackTrace();
        }
    }
    
    public void endFinalYearAllotment(File file) {
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            HashMap<FinalYear, Station> finalYearAllocations = this.getFinalYearAllocations();
            for (Map.Entry<FinalYear, Station> entry : finalYearAllocations.entrySet()) {
                FinalYear student = entry.getKey();
                student.accept();
                
                Station station = entry.getValue();
                bw.write(student.getName() + " " + student.getId() + " " + station.getName());
                bw.newLine();
            }
            
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error occurred while writing to file.");
            e.printStackTrace();
        }
    }
}