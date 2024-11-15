import java.util.Scanner;

public class test {
    static Scanner sc = new Scanner(System.in);
    static StudentList list = new StudentList();

    static void stuInfor(){
        list.printList();
    }

    static void addStudent(){

        System.out.print("Enter number of student: ");
        int numStu = 0;
        while (numStu <=0){
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Please enter a valid integer value for the number of students: ");
                sc.next();
            }
            numStu = sc.nextInt();
            if (numStu <= 0) {
                System.out.print("Number of students must be greater than 0. Please enter a valid number: ");
            }
        }
        for (int i = 0; i < numStu; i++) {
            String studentId;
            while (true) {
                System.out.print("Enter Student Id: ");
                studentId = sc.next();
                if (!list.contain(new Student(studentId, "", 0))) {
                    break;
                } else {
                    System.out.println("Student with this ID already exists. Please enter a different ID.");
                }
            }

            System.out.print("Enter Student name: ");
            String studentName = sc.next();

            double studentMarks = -1;
            while (studentMarks < 0 || studentMarks > 10) {
                System.out.print("Enter Student marks (0-10): ");
                if (sc.hasNextDouble()) {
                    studentMarks = sc.nextDouble();
                    if (studentMarks < 0 || studentMarks > 10) {
                        System.out.println("Invalid marks. Please enter a value between 0 and 10:");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid double value for marks.");
                    sc.next(); // xoa bo dem dau vao
                }
                System.out.println("-_________-");
            }

            Student student = new Student(studentId, studentName, studentMarks);
            list.add(student);
        }
    }


    static void editStudent() {
        int currentSize = list.size();
        System.out.println("Current number of students: " + currentSize);

        if (currentSize == 0) {
            System.out.println("There are no students to edit.");
            return;
        }

        System.out.println("Students Id list (index: ID):");
        for (int i = 0; i < currentSize; i++) {
            Student student = list.list[i];
            if (student != null) {
                System.out.println((i + 1) + ": " + student.getStudentid());
            }
        }

        System.out.print("Enter Student Id to edit: ");
        String studentIdtoedit = sc.next();

        String newId;
        while (true) {
            System.out.print("Enter new Student Id: ");
            newId = sc.next();
            if (!list.contain(new Student(newId, "", 0))) {
                break;
            } else {
                System.out.println("Student with this ID already exists. Please enter a different ID.");
            }
        }

        if (!list.contain(new Student(studentIdtoedit, "", 0))) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new Name: ");
        String newName = sc.next();

        double newMarks = -1;
        while (newMarks < 0 || newMarks > 10) {
            System.out.print("Enter new Marks (0-10): ");
            if (sc.hasNextDouble()) {
                newMarks = sc.nextDouble();
                if (newMarks < 0 || newMarks > 10) {
                    System.out.println("Invalid marks. Please enter a value between 0 and 10.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid double value for marks.");
                sc.next(); // Clear invalid input
            }
        }

        list.edit(studentIdtoedit, newId, newName, newMarks);
        System.out.println("Student with Id " + studentIdtoedit + " has been edited.");

    }


    static void deleteStudent(){
        int currentSize = list.size();
        System.out.println("Current number of students: " + currentSize);

        if (currentSize == 0) {
            System.out.println("There are no students to delete.");
            return;
        }

        System.out.println("Students Id list (index: ID):");
        for (int i = 0; i < currentSize; i++) {
            Student student = list.list[i];
            if (student != null) {
                System.out.println((i + 1) + ": " + student.getStudentid());
            }
        }

        System.out.print("Enter the index of the student to delete (starting from 1): ");
        int index = sc.nextInt();

        if (index < 1 || index > currentSize) {
            System.out.println("Invalid index. Please enter an index from 1 to " + currentSize + ".");
            return;
        }

        list.delete(index - 1);
        System.out.println("Student at index " + index + " has been deleted.");
    }


    static void sortStudent(){
        int n = list.size();
        if (n == 0) {
            System.out.println("No students to sort.");
            return;
        }
        Student[] studentsArray = new Student[n];
        for (int i = 0; i < n; i++) {
            studentsArray[i] = list.list[i];
        }

        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (studentsArray[j].getMarks() > studentsArray[j + 1].getMarks()) {
                    Student temp = studentsArray[j];
                    studentsArray[j] = studentsArray[j + 1];
                    studentsArray[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        for (int i = 0; i < n; i++) {
            list.list[i] = studentsArray[i];
            list.list[i].setSudentRank(i + 1);
        }
        System.out.println("Students sorted by marks.");
        System.out.println("-_________-");
        list.printList();

    }


    static void searchStudent(){
        System.out.println("-_________-");

        int currentSize = list.size();
        System.out.println("Current number of students: " + currentSize);

        if (currentSize == 0) {
            System.out.println("There are no students in the list.");
            return;
        }

        System.out.print("Enter the index of the student to search (starting from 1): ");
        int studentIndex = sc.nextInt();

        if (studentIndex < 1 || studentIndex > currentSize) {
            System.out.println("Invalid index. Please enter an index from 0 to " + currentSize + ".");
            return;
        }

        Student student = list.list[studentIndex -1];
        if (student != null) {
            System.out.println("Student found:");
            System.out.println("Student Id: " + student.getStudentid() + ", Name: " + student.getName() + ", Marks: " + student.getMarks() + ", Ramk: " + student.getStudentRank());
        } else {
            System.out.println("No student exists at the given index.");
        }
    }
}
