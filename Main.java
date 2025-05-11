import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();

        // Predefined courses
        courses.add(new Course("C101", "Java Programming"));
        courses.add(new Course("C102", "Data Structures"));
        courses.add(new Course("C103", "Web Development"));

        while (true) {
            System.out.println("\n1. Add Student\n2. Show Courses\n3. Enroll in Course\n4. View Students\n5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    students.add(new Student(name, age, id));
                    break;

                case 2:
                    System.out.println("Available Courses:");
                    for (Course c : courses) {
                        c.displayCourse();
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int studentId = sc.nextInt();
                    Student found = null;
                    for (Student s : students) {
                        if (s.getStudentId() == studentId) {
                            found = s;
                            break;
                        }
                    }

                    if (found != null) {
                        System.out.println("Courses:");
                        for (int i = 0; i < courses.size(); i++) {
                            System.out.println((i + 1) + ". " + courses.get(i).getCourseName());
                        }
                        System.out.print("Enter course number to enroll: ");
                        int cIndex = sc.nextInt() - 1;
                        if (cIndex >= 0 && cIndex < courses.size()) {
                            found.enrollCourse(courses.get(cIndex));
                        } else {
                            System.out.println("Invalid course selection.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    for (Student s : students) {
                        s.displayInfo();
                    }
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}
