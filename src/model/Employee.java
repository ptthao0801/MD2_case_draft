package model;

import java.io.Serializable;

public class Employee implements Serializable {
    private String id;
    private String role;

    public Employee(String id,String role) {
        this.id = id;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
