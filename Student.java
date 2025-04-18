public class Student {
    // Attributes of the Student class
    private int prn;
    private String name;
    private String branch;
    private String batch;
    private float cgpa;

    // Constructor to initialize the student object
    public Student(int prn, String name, String branch, String batch, float cgpa) {
        this.prn = prn;
        this.name = name;
        this.branch = branch;
        this.batch = batch;
        this.cgpa = cgpa;
    }

    // Getter and Setter methods for each attribute

    public int getPrn() {
        return prn;
    }

    public void setPrn(int prn) {
        this.prn = prn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    // toString method to display the student object in a readable format
    @Override
    public String toString() {
        return "Student{" +
               "PRN=" + prn +
               ", Name='" + name + '\'' +
               ", Branch='" + branch + '\'' +
               ", Batch='" + batch + '\'' +
               ", CGPA=" + cgpa +
               '}';
    }
}

