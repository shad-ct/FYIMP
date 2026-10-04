// Create a JSP application demonstrating standard JSP actions such as jsp:include, jsp:forward, jsp:useBean, jsp:setProperty and jsp:getProperty.
package beans;
public class StudentBean {
    private String name = "Amit";
    private int rollNo = 1;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}
