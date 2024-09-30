public class Main {
    public static void main(String[] args) {
        Person person = new Person("Nguyen Van A", 1980);
        Student student = new Student("Le Thi B", 2000, "SV123456");
        Staff staff = new Staff("Tran Van C", 1975);

        System.out.println(person);
        System.out.println(student);
        System.out.println(staff);
    }
}

class Person {
    private String name;
    private int birthYear;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Birth Year: " + birthYear;
    }
}

class Student extends Person {
    private String studentId;

    public Student(String name, int birthYear, String studentId) {
        super(name, birthYear);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return super.toString() + ", Student ID: " + studentId;
    }
}

class Staff extends Person {
    public Staff(String name, int birthYear) {
        super(name, birthYear);
    }

    @Override
    public String toString() {
        return super.toString() + ", Position: Staff";
    }
}

![image](https://github.com/user-attachments/assets/56c9fab1-904b-4f7f-91cc-dcec8c608de2)

