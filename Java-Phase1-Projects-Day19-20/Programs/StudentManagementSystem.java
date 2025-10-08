package Programs;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age);
    }
}

public class StudentManagementSystem {
    private static final String FILE_NAME = "students.dat";
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loadFromFile();

        int choice;

        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent(sc);
                case 2 -> viewStudents();
                case 3 -> updateStudent(sc);
                case 4 -> deleteStudent(sc);
                case 5 -> System.out.println("Exiting Student Management System. Goodbye!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }

    // ---------------- CRUD Methods ----------------

    private static void addStudent(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        students.add(new Student(id, name, age));
        saveToFile();
        System.out.println("✅ Student added!");
    }

    private static void viewStudents() {
        System.out.println("\n--- Student List ---");
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) s.display();
    }

    private static void updateStudent(Scanner sc) {
        System.out.print("Enter ID of student to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new Name: ");
                s.setName(sc.nextLine());
                System.out.print("Enter new Age: ");
                s.setAge(sc.nextInt());
                saveToFile();
                System.out.println("✅ Student updated!");
                found = true;
                break;
            }
        }
        if (!found) System.out.println("❌ Student not found!");
    }

    private static void deleteStudent(Scanner sc) {
        System.out.print("Enter ID of student to delete: ");
        int id = sc.nextInt();
        Student toRemove = null;
        for (Student s : students) {
            if (s.getId() == id) {
                toRemove = s;
                break;
            }
        }
        if (toRemove != null) {
            students.remove(toRemove);
            saveToFile();
            System.out.println("✅ Student deleted!");
        } else {
            System.out.println("❌ Student not found!");
        }
    }

    // ---------------- File I/O ----------------

    private static void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No existing data found. Starting fresh.");
            students = new ArrayList<>();
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Object obj = ois.readObject();

            if (obj instanceof ArrayList<?>) {
                ArrayList<?> tempList = (ArrayList<?>) obj;
                boolean allStudents = tempList.stream().allMatch(o -> o instanceof Student);

                if (allStudents) {
                    students = (ArrayList<Student>) tempList;
                    System.out.println("✅ Loaded " + students.size() + " students from file.");
                } else {
                    System.out.println("❌ File contains invalid objects. Starting fresh.");
                    students = new ArrayList<>();
                }
            } else {
                System.out.println("❌ File does not contain an ArrayList. Starting fresh.");
                students = new ArrayList<>();
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading file: " + e.getMessage());
            e.printStackTrace();
            students = new ArrayList<>();
        }
    }
}
