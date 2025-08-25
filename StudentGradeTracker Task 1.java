package Java_Programming_Task1;

import java.util.*;

class Student {
    private String name;
    private double[] grades;

    public Student(String name, double[] grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() { return name; }
    public double[] getGrades() { return grades; }

    public double getAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    public double getHighest() {
        double highest = grades[0];
        for (double grade : grades) {
            if (grade > highest) highest = grade;
        }
        return highest;
    }

    public double getLowest() {
        double lowest = grades[0];
        for (double grade : grades) {
            if (grade < lowest) lowest = grade;
        }
        return lowest;
    }
}

public class StudentGradeTracker {
    private List<Student> students;
    private Scanner scanner;

    public StudentGradeTracker() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter number of grades: ");
        int numGrades = scanner.nextInt();
        scanner.nextLine(); // consume newline

        double[] grades = new double[numGrades];
        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
            scanner.nextLine(); // consume newline
        }

        students.add(new Student(name, grades));
        System.out.println("Student added successfully!\n");
    }

    public void displaySummary() {
        if (students.isEmpty()) {
            System.out.println("No students found!\n");
            return;
        }

        System.out.println("\n=== STUDENT GRADE SUMMARY ===");
        System.out.printf("%-20s %-10s %-10s %-10s%n", "Name", "Average", "Highest", "Lowest");
        System.out.println("------------------------------------------------");

        for (Student student : students) {
            System.out.printf("%-20s %-10.2f %-10.2f %-10.2f%n",
                    student.getName(),
                    student.getAverage(),
                    student.getHighest(),
                    student.getLowest());
        }
        System.out.println();
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!\n");
            return;
        }

        System.out.println("\n=== ALL STUDENTS DETAILS ===");
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.print("Grades: ");
            for (double grade : student.getGrades()) {
                System.out.print(grade + " ");
            }
            System.out.println("\nAverage: " + student.getAverage());
            System.out.println("Highest: " + student.getHighest());
            System.out.println("Lowest: " + student.getLowest());
            System.out.println("---------------------------");
        }
    }

    public void run() {
        while (true) {
            System.out.println("=== STUDENT GRADE TRACKER ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Summary Report");
            System.out.println("3. View All Students Details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displaySummary();
                    break;
                case 3:
                    displayAllStudents();
                    break;
                case 4:
                    System.out.println("Thank you for using Student Grade Tracker!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.\n");
            }
        }
    }

    public static void main(String[] args) {
        StudentGradeTracker tracker = new StudentGradeTracker();
        tracker.run();
    }
}