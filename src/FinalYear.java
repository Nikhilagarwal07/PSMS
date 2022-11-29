import java.io.*;

public class FinalYear extends Student {
    private String resume;

    public FinalYear(File studentFile, File preferenceOrderFile, String resume) {
        super(studentFile, preferenceOrderFile);
        this.resume = resume;
    }

    public String getResume() {
        return this.resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}
