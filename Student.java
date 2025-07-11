public class Student {
    String name;
    int rollNo;
    int[] marks;

    public Student(String name, int rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public int getTotal() {
        int total = 0;
        for (int m : marks) {
            total += m;
        }
        return total;
    }

    public String getResult() {
        for (int m : marks) {
            if (m < 35) {
                return "Fail";
            }
        }
        return "Pass";
    }
}