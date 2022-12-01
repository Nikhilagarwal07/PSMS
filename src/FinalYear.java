import java.util.*;
import java.io.*;

public class FinalYear extends Student {
    private String resume;

    public FinalYear(File studentFile, File preferenceOrderFile, HashMap<Integer, Station> stations, String resume) {
        super(studentFile, preferenceOrderFile, stations);
        this.resume = resume;
    }

    public String getResume() {
        return this.resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}
