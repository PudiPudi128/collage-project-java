import java.util.*;

public class College {
    private ArrayList<Lecturer> lecturers;
    private ArrayList<Department> departments;
    private ArrayList<Student> students;

    public College() {
        lecturers = new ArrayList<Lecturer>();
        departments = new ArrayList<Department>();
        students = new ArrayList<Student>();
    }

    public void addDepartment(Department department) {
        for (Department departmentItem : departments) {
            if (departmentItem.getNameDepartment().toLowerCase().equals(department.getNameDepartment().toLowerCase())) {
                System.out.println("There is already such a department in the college!!!");
                return;
            }
        }
        Department newDepartment = new Department(department);
        departments.add(newDepartment);
        lecturers.addAll(department.getLecturers());
        System.out.println(department.getNameDepartment() + " department has been successfully introduced");
    }

    public void addlecturer(Lecturer lecturer) {
        for (Lecturer lecturerItem : lecturers) {
            if (lecturerItem.getName().toLowerCase().equals(lecturer.getName().toLowerCase())) {
                System.out.println("There is already such a lecturer in the college!!!");
                return;
            }
        }
        Lecturer newLecturer = new Lecturer(lecturer);
        lecturers.add(newLecturer);
        System.out.println(lecturer.getName() + " lecturer has been successfully introduced and his salary is " + lecturer.getSalary());
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

    public ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void assignLecturerToDepartment(Lecturer lecturer, Department department) {
        if (!lecturers.toString().contains(lecturer.getName())) {
            lecturers.add(lecturer);
        }
        if (!departments.toString().toLowerCase().contains(department.getNameDepartment().toLowerCase())) {
            department.getLecturers().add(lecturer);
            departments.add(department);
        } else {
            for(Department departmentItem : departments){
                if (departmentItem.getNameDepartment().toLowerCase() == department.getNameDepartment().toLowerCase()) {
                    department.addLecturer(lecturer);
                }
            }
        }
        System.out.println(lecturer.getName() + " lecturer was successfully admitted to the department " + department.getNameDepartment());
    }

    public void assignStudentToDepartment(Student student, Department department) {
        if (!students.toString().contains(student.getName())) {
            if (students.size() == 500) {
                System.out.println("The student is not in the system.\nThere are 500 students in the college and there is no room!");
                return;
            }
            students.add(student);
        }
        if (!departments.toString().toLowerCase().contains(department.getNameDepartment().toLowerCase())) {
            department.getStudents().add(student);
            departments.add(department);
            System.out.println(student.getName() + " student was successfully admitted to the department " + department.getNameDepartment());
        } else {
            for(Department departmentItem : departments){
                if (departmentItem.getNameDepartment().toLowerCase() == department.getNameDepartment().toLowerCase()) {
                    departmentItem.addStudent(student);
                    System.out.println(student.getName() + " student was successfully admitted to the department " + department.getNameDepartment());
                }
            }
        }
    }

    public Department checkMostStudents() {
        int max = 0;
        Department departmentWithMostStudents = null;
        for (Department department : departments) {
            if (department.getStudents().size() > max) {
                max = department.getStudents().size();
                departmentWithMostStudents = department;
            }
        }
        return departmentWithMostStudents;
    }

    @Override
    public String toString() {
        return "College{" +
                "lecturers=" + lecturers +
                ", departments=" + departments +
                ", students=" + students +
                '}';
    }
}
