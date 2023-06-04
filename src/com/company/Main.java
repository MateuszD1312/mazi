package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Employee employee1 = new Employee("John", "Doe", "Manager", 75000);
        Employee employee2 = new Employee("Jane", "Smith", "Accountant",  60000);
        Employee employee3 = new Employee("Michael", "Johnson", "Accountant",  55000);
        Employee employee4 = new Employee("Emily", "Jones", "Marketing Specialist",  50000);
        Employee employee5 = new Employee("David", "Brown", "Accountant",  45000);
        Employee employee6 = new Employee("Laura", "Taylor", "Human Resources Manager", 70000);
        Employee employee7 = new Employee("Kevin", "Wilson", "IT Specialist",  60000);
        Employee employee8 = new Employee("Samantha", "Davis", "Customer Service Representative",  40000);

        HashMap<Integer,Employee> employeeHashMap = new HashMap<>();
        EmployeeManager employeeManager = new EmployeeManager(employeeHashMap);
        employeeManager.addEmployee("John", "Doe", "Manager", 75000);
        employeeManager.addEmployee("Jane", "Smith", "Accountant",  60000);
        employeeManager.addEmployee("Michael", "Johnson", "Accountant",  55000);
        employeeManager.addEmployee("Emily", "Jones", "Marketing Specialist",  50000);
        employeeManager.addEmployee("David", "Brown", "Accountant",  45000);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            System.out.println("1.Dodaj pracownika");
            System.out.println("2.Usuń pracownika");
            System.out.println("3.Zaktualizuj dane o pracowniku");
            System.out.println("4.Wyświetl liste wszystkich pracownikow");
            System.out.println("5.Wyszukaj pracownika po nazwisku");
            System.out.println("Inna wartosc zakonczy program");
            int input = Integer.parseInt(bufferedReader.readLine());
            switch (input){
                case 1:
                    employeeManager.addEmployee("Kevin", "Wilson", "IT Specialist",  60000);
                    break;
                case 2:
                {
                    int id = Integer.parseInt(bufferedReader.readLine());
                    employeeManager.removeEmployee(employeeManager.searchEmployeeByID(id));
                    break;
                }
                case 3:
                {
                    int id = Integer.parseInt(bufferedReader.readLine());
                    Employee employee = employeeManager.searchEmployeeByID(id);
                    if(employee != null){
                    employee.setSalary(10000);
                    employeeManager.updateEmployee(id,employee.getPosition(),employee.getSalary());}
                    break;

                }
                case 4:
                {
                    employeeManager.listAllEmployees();
                    break;
                }
                case 5:
                {
                    String lastname = bufferedReader.readLine();
                    HashSet<Employee> employeeHashSet = employeeManager.searchEmployeesByLastName(lastname);
                    for (Employee employee: employeeHashSet
                         ) {
                        System.out.println(employee);
                    }
                    break;

                }
                default:
                    System.exit(0);
            }
        }
    }
}
