package controller;

import controller.validation.ValidationTool;
import model.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeController implements ActionForModel, ValidationTool {
    Scanner scanner = new Scanner(System.in);
    List<Employee> employees = new ArrayList<>();
    @Override
    public void display() {
        System.out.println("------DISPLAY EMPLOYEEE------");
        for (Employee employee:employees){
            System.out.println(employee);
        }
    }

    @Override
    public void add() {
        System.out.println("------ADD EMPLOYEE------");
        System.out.println("Enter ID: ");
        String id = scanner.nextLine();
        System.out.println("Enter Role: ");
        String role = scanner.nextLine();
        Employee newEmployee = new Employee(id,role);
        employees.add(newEmployee);
        System.out.println("ADDED SUCCESSFULLY!");
    }

    @Override
    public void remove() {
        System.out.println("------REMOVE EMPLOYEE------");
        System.out.println("Remove this ID: ");
        while (true){
            boolean isAvailable = false;
            String id = scanner.nextLine();
            for (Employee employee:employees){
                if (employee.getId().equals(id)){
                    isAvailable = true;
                    employees.remove(employee);
                    break;
                }
            }
            if(isAvailable){
                System.out.println("EMPLOYEE ID "+id+" HAS BEEN REMOVED SUCCESSFULLY!");
            } else {
                System.out.println("EMPLOYEE ID NOT FOUND! Please re-enter: ");
            }
        }
    }

    @Override
    public void search() {
        System.out.println("------SEARCH EMPLOYEE------");
        System.out.println("Enter ID");
        String searchItem = scanner.nextLine();
        boolean found = false;
        for (Employee employee: employees) {
            if (String.valueOf(employee.getId()).equals(searchItem)) {
                System.out.println("FOUND! " + employee);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("EMPLOYEE NOT FOUND!");
        }
    }

    @Override
    public void writeToFile() {
        System.out.println("------WRITE TO FILE------");
        ObjectOutputStream oos = null;
        String path = "employee.txt";
        try {
            FileOutputStream fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            for (Employee employee : employees) {
                oos.writeObject(employee);
                oos.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("DONE WRITING TO FILE "+ path);
    }

    @Override
    public void readFromFile() {

    }
    public static EmployeeType roleCheck(String employeeId){
        char firstChar = employeeId.charAt(0);

        if (firstChar == 'M' || firstChar == 'm') {
            return EmployeeType.valueOf("MANAGER");
        } else {
            return EmployeeType.valueOf("EMPLOYEE");
        }
    }
}
