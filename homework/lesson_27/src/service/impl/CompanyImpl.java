package service.impl;

import model.Employee;
import model.SalesManager;
import service.Company;

public class CompanyImpl implements Company {
    private Employee[] employees;
    private int size;

    public CompanyImpl(int capacity) {
        employees = new Employee[capacity];
    }

    private boolean isPresent(Employee employee) {
        if (employee != null) {
            for (Employee e : employees) {
                if (employee.equals(e)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (employees.length > size && employee != null && !isPresent(employee)) {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] == null) {
                    employees[i] = employee;
                    size++;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Employee removeEmployee(int id) {
        Employee employee = findEmployee(id);
        if (isPresent(employee)) {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null
                        && employees[i].equals(employee)) {
                    employees[i] = null;
                    size--;
                }
            }
        }
        return employee;
    }

    @Override
    public Employee findEmployee(int id) {
        Employee employee = null;
        for (Employee e : employees) {
            if (e != null
                    && e.getId() == id) {
                employee = e;
            }
        }
        return employee;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public double totalSalary() {
        double total = 0;
        for (Employee e : employees) {
            if (e != null) {
                total += e.calcSalary();
            }
        }
        return total;
    }

    @Override
    public double avgSalary() {
        return totalSalary() / size;
    }

    @Override
    public double totalSales() {
        double sales = 0;
        for (Employee e : employees) {
            if (e instanceof SalesManager) {
                sales += ((SalesManager) e).getSalesValue();
            }
        }
        return sales;
    }

    @Override
    public void printEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }
}
