import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean menuRunning = true;
        College college = new College();
        while (menuRunning) {
            System.out.println
                    ("------------------------------------------------------------------------------------------------\n" +
                            " Please select option:\n" +
                            " 1. Add new department\n" +
                            " 2. Add new lecturer\n" +
                            " 3. Assign lecturer to department\n" +
                            " 4. Add student to college and assign to department\n" +
                            " 5. Show all students by department\n" +
                            " 6. Show the name of the department that has the most students and how many students it has\n" +
                            " 7. Exit\n" +
                            " ------------------------------------------------------------------------------------------------");
            int choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("You choose option 1");
                    System.out.println("Please enter a name for new department:");
                    college.addDepartment(new Department(in.nextLine()));
                    break;
                case 2:
                    System.out.println("You choose option 2");
                    System.out.println("Please enter the new lecturer and the salary of this lecturer:");
                    college.addlecturer(new Lecturer(in.nextLine(), in.nextInt()));
                    break;
                case 3:
                    System.out.println("You choose option 3");
                    System.out.println("Please enter the name of the lecturer");
                    String lecturerNameChoice = in.nextLine();
                    Lecturer lecturerChoice = null;
                    for (Lecturer lecturer : college.getLecturers()) {
                        if (lecturer.getName().toLowerCase().equals(lecturerNameChoice.toLowerCase())) {
                            lecturerChoice = lecturer;
                        }
                    }
                    if (lecturerChoice == null) {
                        System.out.println("There is no such lecturer in the college, if you want you can add a lecturer, you can add from the menu and press 2");
                        break;
                    }
                    System.out.println("Please enter the name of the department");
                    String departmentNameChoice = in.nextLine();
                    Department departmentChoice = null;
                    for (Department department : college.getDepartments()) {
                        if (department.getNameDepartment().toLowerCase().equals(departmentNameChoice.toLowerCase())) {
                            college.assignLecturerToDepartment(lecturerChoice, department);
                            departmentChoice = department;
                            break;
                        }
                    }
                    if(departmentChoice == null){
                        System.out.println("There is no such department in the college, if you want you can add a department, you can add from the menu and press 1");
                    }
                    break;
                case 4:
                    System.out.println("You choose option 4");
                    System.out.println("Please enter your name and your ID:");
                    Student s1 = new Student(in.nextLine(), in.nextInt());
                    in.nextLine();
                    Boolean departmentExists = false;
                    System.out.println("Please enter the name of the department you want to assign");
                    String departmentNameAssign = in.nextLine();
                    for(Department department: college.getDepartments()){
                        if(department.getNameDepartment().toLowerCase().equals(departmentNameAssign.toLowerCase())){
                            college.assignStudentToDepartment(s1,department);
                            departmentExists = true;
                            break;
                        }
                    }
                    if(departmentExists == false){
                        System.out.println("There is no such department in the college, if you want you can add a department, you can add from the menu and press 1");
                    }
                    break;
                case 5:
                    System.out.println("You choose option 5");
                    if(college.getDepartments().size() == 0){
                        System.out.println("There are no departments in the college!!!");
                        break;
                    }
                    System.out.println("Please enter the name of the department:");
                    String departmentName = in.nextLine();
                    Boolean departmentChoiceExists = false;
                    for (Department department : college.getDepartments()) {
                        if (department.getNameDepartment().toLowerCase().equals(departmentName.toLowerCase())) {
                            departmentChoiceExists = true;
                            System.out.println("This is all the students in department " + department.getNameDepartment() + " " + department.getStudents());
                            break;
                        }
                    }
                    if(departmentChoiceExists == false){
                        System.out.println("There is no such department in the college, if you want you can add a department, you can add from the menu and press 1");
                    }
                    break;
                case 6:
                    System.out.println("You choose option 6");
                    Department mostStudentsDepartment = college.checkMostStudents();
                    if(mostStudentsDepartment == null){
                        System.out.println("There are no departments or students in the college!!!");
                        break;
                    }
                    System.out.println(mostStudentsDepartment.getNameDepartment() + " is the department that have the most students");
                    System.out.println("The amount of students is: " + mostStudentsDepartment.getStudents().size());
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    menuRunning = false;
                    break;
                default:
                    System.out.println("Please enter number from the menu!!!");
            }
        }
        in.close();
    }
}
//    public static Department loopOnDepartment(College college, String departmentName){
//        for(Department department: college.getDepartments()){
//            if(department.getNameDepartment().toLowerCase().equals(departmentName.toLowerCase())){
//                college.assignStudentToDepartment(s1,department);
//                departmentExists = true;
//                break;
//            }
//        }
//        return
//    }