import java.util.*;
import java.io.*;

public class SecondYear extends Student {
    public SecondYear(File studentFile, File preferenceOrderFile, HashMap<Integer, Station> stations) {
        super(studentFile, preferenceOrderFile, stations);
    }

    public SecondYear(String name, float cgpa, String id, String branch, ArrayList<String> subjects) {
        super(name, cgpa, id, branch, subjects);
    }
}
