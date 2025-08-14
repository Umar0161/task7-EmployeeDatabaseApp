import java.sql.SQLException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Employee Database App ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Department: ");
                        String dept = sc.nextLine();
                        System.out.print("Salary: ");
                        double sal = sc.nextDouble();
                        dao.addEmployee(name, dept, sal);
                        break;

                    case 2:
                        dao.viewEmployees();
                        break;

                    case 3:
                        System.out.print("Employee ID: ");
                        int idUp = sc.nextInt();
                        sc.nextLine();
                        System.out.print("New Name: ");
                        String nameUp = sc.nextLine();
                        System.out.print("New Department: ");
                        String deptUp = sc.nextLine();
                        System.out.print("New Salary: ");
                        double salUp = sc.nextDouble();
                        dao.updateEmployee(idUp, nameUp, deptUp, salUp);
                        break;

                    case 4:
                        System.out.print("Employee ID: ");
                        int idDel = sc.nextInt();
                        dao.deleteEmployee(idDel);
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

