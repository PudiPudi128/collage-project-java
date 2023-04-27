import java.util.ArrayList;

public class Department {
    private String nameDepartment;
    private ArrayList<Lecturer> lecturers;
    private ArrayList<Student> students;

    public Department(String nameDepartment) {
        this.nameDepartment = nameDepartment;
        lecturers = new ArrayList<Lecturer>();
        students = new ArrayList<Student>();
    }

    public Department(Department department) {
        nameDepartment = department.nameDepartment;
        lecturers = new ArrayList<Lecturer>(department.lecturers);
        students = new ArrayList<Student>(department.students);
    }

    public void addLecturer(Lecturer lecturer){
        for (Lecturer lecturerItem  : lecturers) {
            if (lecturerItem.getName().toLowerCase().equals(lecturer.getName().toLowerCase())) {
                System.out.println("There is already such a lecturer in the department!!!");
                return;
            }
        }
        this.lecturers.add(lecturer);
    }

    public void addStudent(Student student) {
        if (students.size() == 500) {
            return;
        }
        if (students.contains(student)) {
            System.out.println("It is already in the system!!  ->-> " + student);
            return;
        }
        Student newStudent = new Student(student);
        students.add(newStudent);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    public void printDepartment(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Department{" +
                "nameDepartment='" + nameDepartment + '\'' +
                ", lecturers=" + lecturers +
                ", students=" + students +
                '}';
    }
}
