import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StudentList list = new StudentList();

    public static void main(String[] args) {
        while (true) {
            System.out.println(
                    "\nMenu\n-_________- \n0: Student information \n1: Add Student \n2: Edit Student \n3: Delete Student \n4: Sort Student \n5: Search Student \n6: Exit \n-_________-");
            System.out.print("Enter your choice: ");
            int input = sc.nextInt();
            switch (input) {
                case 0:
                    test.stuInfor();
                    break;
                case 1:
                    test.addStudent();
                    break;
                case 2:
                    test.editStudent();
                    break;
                case 3:
                    test.deleteStudent();
                    break;
                case 4:
                    test.sortStudent();
                    break;
                case 5:
                    test.searchStudent();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice (Select only options 1 to 6)");
            }
        }
    }
}
