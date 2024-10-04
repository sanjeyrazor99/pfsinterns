public class StudentManagementSystem
{
    Student[] students = new Student[100];
    int studentCount = 0;

    public void addStudent(Student student)
    {
        if (studentCount < students.length)
        {
            students[studentCount++] = student;
        } else
        {
            System.out.println("Student list is full.");
        }
    }

    public void viewStudents()
    {
        for (int i = 0; i < studentCount; i++)
        {
            System.out.println(students[i]);
        }
    }

    public void updateStudent(int rollNumber, String newName, String newGrade)
    {
        for (int i = 0; i < studentCount; i++)
        {

            if (students[i].rollNumber == rollNumber)
            {
                students[i].name = newName;
                students[i].grade = newGrade;
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteStudent(int rollNumber)
    {
        for (int i = 0; i < studentCount; i++)
        {
            if (students[i].rollNumber == rollNumber)
            {
                students[i] = students[--studentCount]; // Replace with last student
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
