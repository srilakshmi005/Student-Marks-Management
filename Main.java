import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n-- Student Marks Management --");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next(); // clear wrong input
                continue;
            }

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = sc.next();

                System.out.print("Enter roll number: ");
                int rollNo;
                try {
                    rollNo = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid roll number! Must be a number.");
                    sc.next();
                    continue;
                }

                int[] marks = new int[3];
                System.out.println("Enter marks for 3 subjects:");
                for (int i = 0; i < 3; i++) {
                    while (true) {
                        System.out.print("Enter mark " + (i + 1) + ": ");
                        try {
                            marks[i] = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a number.");
                            sc.next(); // clear invalid input
                        }
                    }
                }

                Student s = new Student(name, rollNo, marks);
                students.add(s);
                System.out.println("Student added successfully!");

                // Save to file
                try {
                    FileWriter writer = new FileWriter("students.txt", true); // append mode
                    writer.write("Name: " + name +
                                 ", Roll No: " + rollNo +
                                 ", Marks: " + marks[0] + ", " + marks[1] + ", " + marks[2] +
                                 ", Total: " + s.getTotal() +
                                 ", Result: " + s.getResult() + "\n");
                    writer.close();
                    System.out.println("Student saved to file.");
                } catch (IOException e) {
                    System.out.println("An error occurred while saving to file.");
                }

            } else if (choice == 2) {
                if (students.isEmpty()) {
                    System.out.println("No student records found.");
                } else {
                    for (Student s : students) {
                        System.out.println("Name: " + s.name +
                                           " | Roll No: " + s.rollNo +
                                           " | Total: " + s.getTotal() +
                                           " | Result: " + s.getResult());
                    }
                }

            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}