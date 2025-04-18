import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentOperations {

    // Add new student record
    public void addStudent(Student student) {
        String query = "INSERT INTO students (PRN, Name, Branch, Batch, CGPA) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, student.getPrn());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getBranch());
            stmt.setString(4, student.getBatch());
            stmt.setFloat(5, student.getCgpa());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    // Display all students
    public void displayStudents() {
        String query = "SELECT * FROM students";
        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Student student = new Student(
                    rs.getInt("PRN"),
                    rs.getString("Name"),
                    rs.getString("Branch"),
                    rs.getString("Batch"),
                    rs.getFloat("CGPA")
                );
                System.out.println(student);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching students: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    // Search student by PRN
    public Student searchByPrn(int prn) {
        String query = "SELECT * FROM students WHERE PRN = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, prn);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(
                    rs.getInt("PRN"),
                    rs.getString("Name"),
                    rs.getString("Branch"),
                    rs.getString("Batch"),
                    rs.getFloat("CGPA")
                );
            } else {
                System.out.println("No student found with PRN: " + prn);
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Error searching student: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            return null;
        }
    }

    // Update student details
    public void updateStudent(Student student) {
        String query = "UPDATE students SET Name = ?, Branch = ?, Batch = ?, CGPA = ? WHERE PRN = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, student.getName());
            stmt.setString(2, student.getBranch());
            stmt.setString(3, student.getBatch());
            stmt.setFloat(4, student.getCgpa());
            stmt.setInt(5, student.getPrn());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student updated successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    // Delete student record
    public void deleteStudent(int prn) {
        String query = "DELETE FROM students WHERE PRN = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, prn);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}


