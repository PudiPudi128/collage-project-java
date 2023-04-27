public class Lecturer {
    private String name;
    private int salary;

    public Lecturer(String name, int salary){
        this.name = name;
        this.salary = salary;
    }

    public Lecturer(Lecturer lecturer){
        name = lecturer.name;
        salary = lecturer.salary;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}
