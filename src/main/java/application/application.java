package application;

import entities.Address;
import entities.Department;
import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class application {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Employee employee;

        System.out.print("Nome do departamento: ");
        String nameDepartment = sc.nextLine();

        System.out.print("Dia do pagamento: ");
        int dayPayment = sc.nextInt();
        sc.nextLine();

        System.out.print("Email: ");
        String empEmail = sc.nextLine();

        System.out.print("Telefone: ");
        String empTelefone = sc.nextLine();

        System.out.print("Quantos funcionarios tem o departamento? ");
        int numberEmp = sc.nextInt();
        sc.nextLine();

        Address address = new Address(empEmail, empTelefone);
        Department departments = new Department(nameDepartment, dayPayment, address);


        for (int i = 0; i < numberEmp; i++) {

            System.out.println("Dados funcionário " + (i + 1) + ":");

            System.out.print("Nome: ");
            String nameEmp = sc.nextLine();

            System.out.print("Salário: ");
            double salaryEmp = sc.nextDouble();

            employee = new Employee(nameEmp, salaryEmp);
            departments.addEmployee(employee);

            sc.nextLine();
        }

        System.out.println("\nFOLHA DE PAGAMENTO:");

        showReport(departments);

        sc.close();
    }

    private static void showReport (Department departments){

        System.out.printf("Departamento de Vendas = R$ %.2f%n", departments.payRool());
        System.out.println("Pagamento realizado no dia " + departments.getPayDay());
        System.out.println("Funcionários:");

        for (Employee o : departments.getEmployees()) {
            System.out.println(o.getName());
        }

        System.out.println("Para dúvidas favor entrar em contato: " + departments.getAddress().getEmail());

    }
}
