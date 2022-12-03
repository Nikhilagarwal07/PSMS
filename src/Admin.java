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
    public Scanner sc;
    private volatile boolean isRunning = true;

    public Admin(Scanner sc) {
        this.sc = sc;
    }

    public void start() {
        if (this.t == null) {
            this.t = new Thread(this, "Admin");
            this.t.start();
        }
    }

    public void run() {
        while (this.isRunning) {
            // do something
            App.clearScreen();

            System.out.println("Admin Home");
            System.out.println("1. Show Students");
            System.out.println("9. Logout");
            System.out.print("Enter your choice: ");
            
            int adminChoice = sc.nextInt();
            if (adminChoice == 1) {
                App.clearScreen();
                ArrayList<SecondYear> students = getSecondYearStudents();
                for (SecondYear student : students) {
                    System.out.println(student.getName() + "\t" + student.getCgpa());
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Hello world");
            } else if (adminChoice == 9) {
                try {
                    System.out.println("Exiting...");
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
        }
    }

    public void stop() {
        this.isRunning = false;
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

// System.out.println("1. Add Second Year Stations");
// System.out.println("2. Add Second Year Students");
// System.out.println("3. Allocate Second Year Students");
// System.out.println("4. Freeze Second Year Allocations");
// System.out.println("5. Add Final Year Stations");
// System.out.println("6. Add Final Year Students");
// System.out.println("7. Allocate Final Year Students");
// System.out.println("8. Freeze Final Year Allocations");