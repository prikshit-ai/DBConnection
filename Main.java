import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentOperations operations = new StudentOperations();

        while (true) {
            // Menu options
            System.out.println("\nStudent Data Entry System");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by PRN");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:  // Add Student
                    System.out.print("Enter PRN: ");
                    int prn = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Branch: ");
                    String branch = scanner.nextLine();
                    System.out.print("Enter Batch: ");
                    String batch = scanner.nextLine();
                    System.out.print("Enter CGPA: ");
                    float cgpa = scanner.nextFloat();

                    Student newStudent = new Student(prn, name, branch, batch, cgpa);
                    operations.addStudent(newStudent);
                    break;

                case 2:  // Display All Students
                    operations.displayStudents();
                    break;

                case 3:  // Search Student by PRN
                    System.out.print("Enter PRN to search: ");
                    int searchPrn = scanner.nextInt();
                    Student foundStudent = operations.searchByPrn(searchPrn);
                    if (foundStudent != null) {
                        System.out.println(foundStudent);
                    }
                    break;

                case 4:  // Update Student
                    System.out.print("Enter PRN to update: ");
                    int updatePrn = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Branch: ");
                    String newBranch = scanner.nextLine();
                    System.out.print("Enter new Batch: ");
                    String newBatch = scanner.nextLine();
                    System.out.print("Enter new CGPA: ");
                    float newCgpa = scanner.nextFloat();

                    Student updatedStudent = new Student(updatePrn, newName, newBranch, newBatch, newCgpa);
                    operations.updateStudent(updatedStudent);
                    break;

                case 5:  // Delete Student
                    System.out.print("Enter PRN to delete: ");
                    int deletePrn = scanner.nextInt();
                    operations.deleteStudent(deletePrn);
                    break;

                case 6:  // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}



