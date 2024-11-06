class Student {
    String name;
    String mobileNumber;

    public Student(String name, String mobileNumber) {
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Mobile Number: " + mobileNumber;
    }
}

// Define the StudentLinkedList class to manage student records
class StudentLinkedList {
    // Node inner class to represent each student record in the linked list
    private static class Node {
        Student student;
        Node next;

        public Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    private Node head; // Head of the linked list

    // Method to add a student record
    public void add(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to remove a student record by name
    public void remove(String name) {
        if (head == null) {
            return;
        }

        if (head.student.name.equals(name)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.student.name.equals(name)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    // Method to update a student's mobile number
    public void update(String name, String newMobileNumber) {
        Node current = head;
        while (current != null) {
            if (current.student.name.equals(name)) {
                current.student.mobileNumber = newMobileNumber;
                return;
            }
            current = current.next;
        }
    }

    // Method to search for a student by name
    public Student search(String name) {
        Node current = head;
        while (current != null) {
            if (current.student.name.equals(name)) {
                return current.student;
            }
            current = current.next;
        }
        return null; // Student not found
    }

    // Method to display all student records
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.student.toString());
            current = current.next;
        }
    }
}

// Main class to test the student records management system
public class DSUJproject {
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();

        // Adding students
        studentList.add(new Student("Alice", "1234567890"));
        studentList.add(new Student("Bob", "9876543210"));
        studentList.add(new Student("Charlie", "5678901234"));

        // Displaying all students
        System.out.println("All students:");
        studentList.display();
        System.out.println();

        // Updating Bob's mobile number
        studentList.update("Bob", "9999999999");

        // Displaying all students after update
        System.out.println("All students after update:");
        studentList.display();
        System.out.println();

        // Searching for Alice
        String searchName = "Alice";
        System.out.println("Searching for student '" + searchName + "':");
        Student result = studentList.search(searchName);
        if (result != null) {
            System.out.println("Student found: " + result.toString());
        } else {
            System.out.println("Student not found.");
        }
        System.out.println();

        // Removing Charlie from the list
        studentList.remove("Charlie");

        // Displaying all students after removal
        System.out.println("All students after removal:");
        studentList.display();
    }
}
