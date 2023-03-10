package com.example.car_park.entities.dto;

import com.example.car_park.entities.Employee;

import java.util.Date;

public class EmployeeDTO {
    private long employeeId;
    private String account;
    private String department;
    private String employeeAddress;
    private Date employeeBirthdate;
    private String employeeEmail;
    private String employeeName;
    private String employeePhone;
    private String sex;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public EmployeeDTO(Employee employee){
        this.employeeId = employee.getEmployeeId();
        this.account = employee.getAccount();
        this.department = employee.getDepartment();
        this.employeeAddress = employee.getEmployeeAddress();
        this.employeeBirthdate = employee.getEmployeeBirthdate();
        this.employeeEmail = employee.getEmployeeEmail();
        this.employeePhone = employee.getEmployeePhone();
        this.sex = employee.getSex();
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Date getEmployeeBirthdate() {
        return employeeBirthdate;
    }

    public void setEmployeeBirthdate(Date employeeBirthdate) {
        this.employeeBirthdate = employeeBirthdate;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
