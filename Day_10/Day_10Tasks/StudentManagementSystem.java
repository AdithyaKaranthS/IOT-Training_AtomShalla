import java.util.*;

class Student {
    int id;
    String name;
    String department;
    double marks;

    Student(int id, String name, String department, double marks) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Department: " + department +
               ", Marks: " + marks;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Student))
            return false;

        Student s = (Student) obj;

        return this.id == s.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {

        Student s1 = new Student(101, "Adithya", "CSE", 95);
        Student s2 = new Student(102, "Rahul", "ME", 92);
        Student s3 = new Student(103, "Ananya", "ECE", 92);
        Student s4 = new Student(104, "Kiran", "ISE", 78);
        Student s5 = new Student(105, "Megha", "ECE", 88);
        Student s6 = new Student(101, "Arjun", "ME", 75);  // Same id as s1

        ArrayList<Student> students = new ArrayList<>();

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);

        System.out.println("Students before sorting:");
        for (Student s : students) {
            System.out.println(s);
        }

        Comparator<Student> marksComparator = (a, b) -> {
            if (a.marks != b.marks) {
                return Double.compare(b.marks, a.marks);
            }

            int nameCompare = a.name.compareTo(b.name);

            if (nameCompare != 0) {
                return nameCompare;
            }

            return Integer.compare(a.id, b.id);
        };

        students.sort(marksComparator);

        System.out.println("\nStudents after sorting:");
        for (Student s : students) {
            System.out.println(s);
        }

        Comparator<Student> departmentComparator = (a, b) -> {
            int departmentCompare =
                    a.department.compareTo(b.department);

            if (departmentCompare != 0) {
                return departmentCompare;
            }

            int marksCompare =
                    Double.compare(b.marks, a.marks);

            if (marksCompare != 0) {
                return marksCompare;
            }

            return Integer.compare(a.id, b.id);
        };

        TreeSet<Student> set =
                new TreeSet<>(departmentComparator);

        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s5);
        set.add(s6);

        System.out.println("\nTreeSet:");
        for (Student s : set) {
            System.out.println(s);
        }
    }
}
