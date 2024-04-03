package controller;

import controller.validation.ValidationTool;
import model.Action;
import model.Employee;
import model.EmployeeType;

import java.util.ArrayList;
import java.util.List;

public class EmployeeController implements Action, ValidationTool {
    List<Employee> employees = new ArrayList<>();
    @Override
    public void display() {
        System.out.println("------DISPLAY------");
        for (Employee employee:employees){
            System.out.println(employee);
        }
    }

    @Override
    public void add() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void search() {

    }

    @Override
    public void writeToFile() {

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
