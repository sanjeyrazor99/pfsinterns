import java.util.Scanner;

public class Tester
{
    public static void main(String[] args)
    {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner console = new Scanner(System.in);

        while (true)
        {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = console.nextInt();
            console.nextLine();  // Consume newline

            switch (choice)
            {
                case 1:
                    System.out.print("Enter roll number: ");
                    int rollNumber = console.nextInt();
                    console.nextLine();  // Consume newline
                    System.out.print("Enter name: ");
                    String name = console.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = console.nextLine();
                    sms.addStudent(new Student(rollNumber, name, grade));
                    break;
                case 2:
                    sms.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter roll number of student to update: ");
                    rollNumber = console.nextInt();
                    console.nextLine();  // Consume newline
                    System.out.print("Enter new name: ");
                    name = console.nextLine();
                    System.out.print("Enter new grade: ");
                    grade = console.nextLine();
                    sms.updateStudent(rollNumber, name, grade);
                    break;
                case 4:
                    System.out.print("Enter roll number of student to delete: ");
                    rollNumber = console.nextInt();
                    sms.deleteStudent(rollNumber);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}