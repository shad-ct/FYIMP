// Write a Java program to demonstrate the implementation of multiple interfaces. Define interfaces Sports and Academics, each containing one method. Create a class Student that implements both interfaces and displays the student's academic and sports information.
public class MultipleInterfaces {
    interface Sports {
        void sportsInfo();
    }
    interface Academics {
        void academicInfo();
    }
    static class Student implements Sports, Academics {
        public void sportsInfo() {
            System.out.println("Sport: Cricket");
        }
        public void academicInfo() {
            System.out.println("Grade: A");
        }
    }
    public static void main(String[] args) {
        Student s = new Student();
        s.academicInfo();
        s.sportsInfo();
    }
}
