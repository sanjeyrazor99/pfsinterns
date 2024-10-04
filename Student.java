public class Student
{
   int rollNumber;
   String name;
   String grade;

   public Student(int r, String n, String g)   // r  means roll number, n means name , g means grade
   {
      rollNumber = r;
      name = n;
      grade = g;
   }

   @Override
   public String toString()
   {
      return "Roll Number: " + rollNumber + ", Name: " + name + ", Grade: " + grade;
   }
}
