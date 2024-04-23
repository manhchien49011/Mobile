import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private String code;
    private double salaryRate;

    public Employee(int id, String name, int age, String department, String code, double salaryRate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.code = code;
        this.salaryRate = salaryRate;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Ho ten: " + name + ", Tuoi: " + age + ", Bo phan: " + department +
               ", Ma nhan vien: " + code + ", Luong: " + salaryRate;
    }
}

public class EmployeeManagement {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void initEmployees() {
        employees.add(new Employee(1, "Nguyen Van A", 30, "HR", "HR001", 9000));
        employees.add(new Employee(2, "Nguyen Van B", 35, "Salles", "Sal002", 7000));
        employees.add(new Employee(3, "Nguyen Van C", 40, "IT", "IT003", 15000));
        employees.add(new Employee(4, "Nguyen Van D", 25, "Marketing", "MAR004", 8000));
        employees.add(new Employee(5, "Nguyen Van E", 28, "Sales", "SAL005", 6500));
        employees.add(new Employee(6, "Nguyen Van F", 32, "HR", "HR006", 8000));
        employees.add(new Employee(7, "Nguyen Van G", 38, "IT", "IT007", 1200));
        employees.add(new Employee(8, "Nguyen Van H", 27, "Marketing", "MAR008", 6500));
        employees.add(new Employee(9, "Nguyen Van J", 32, "IT", "IT008", 1400));
        employees.add(new Employee(10, "Nguyen Van K", 27, "Marketing", "MAR006", 6500));


    }

    public void displayEmployees() {
        System.out.println("Danh sach nhan vien:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Them nhan vien thanh cong.");
    }

    public void removeEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                employees.remove(emp);
                System.out.println("Xoa thanh cong nhan vien " + id + " .");
                return;
            }
        }
        System.out.println("Khong tim thay nhan vien " + id + " .");
    }

    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement();
        management.initEmployees();

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nHe thong quan ly nhan vien:");
            System.out.println("1. Hien thi danh sach nhan vien");
            System.out.println("2. Them nhan vien moi");
            System.out.println("3. Xoa nhan vien");
            System.out.println("4. Thoat");
            System.out.print("Ban muon lam gi: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    management.displayEmployees();
                    break;
                case 2:
                    System.out.println("Them thong tin:");
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Ho ten: ");
                    String name = scanner.nextLine();
                    System.out.print("Tuoi: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Bo phan: ");
                    String department = scanner.nextLine();
                    System.out.print("Ma nhan vien: ");
                    String code = scanner.nextLine();
                    System.out.print("Luong: ");
                    double salaryRate = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    management.addEmployee(new Employee(id, name, age, department, code, salaryRate));
                    break;
                case 3:
                    System.out.print("Nhap ID nhan vien: ");
                    int removeId = scanner.nextInt();
                    management.removeEmployee(removeId);
                    break;
                case 4:
                    System.out.println("Thoat ...");
                    break;
                default:
                    System.out.println("Nhap lai.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
