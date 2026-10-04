// Develop a JSP application using Expression Language (EL) to access JavaBean properties, request parameters and headers.
package beans;
public class StudentBean {
    private String name = "Amit";
    private int marks = 85;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }
}
