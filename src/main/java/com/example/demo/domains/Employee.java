package com.example.demo.domains;

import java.math.*;
import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    /*
     * EMPLOYEE_ID bigint PK
     * FIRST_NAME varchar(20)
     * LAST_NAME varchar(25)
     * EMAIL varchar(45)
     * SALARY decimal(18,4)
     * TOTAL_WORK_PERCENTAGE double
     * MEMBERSHIP_COUNT bigint
     * DEPARTMENT_ID bigint
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long employee_id;

    @Column(length = 20)
    String first_name;

    @Column(length = 20)
    String last_name;

    @Column(length = 45)
    String email;

    @Column(precision = 18, scale = 4)
    BigDecimal salary;

    double total_work_percentage;
    Long membership_count;
    Long department_id;

    // @Column(name ="leader_id", nullable = false
    /*
     * ORM
     */

    @OneToMany(
        mappedBy = "leader", // Mappatura dell'attributodi classe della chiave esterna
        cascade = { CascadeType.ALL }, 
        orphanRemoval = true
    )

    //@JsonIgnore 
    Set<Project> projects; // Insieme univoco di progetti gestiti da un solo impiegato

    public Employee() {
    }

    public Employee(Long employee_id, String first_name, String last_name, String email, BigDecimal salary,
            double total_work_percentage, Long membership_count, Long department_id, Set<Project> projects) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.salary = salary;
        this.total_work_percentage = total_work_percentage;
        this.membership_count = membership_count;
        this.department_id = department_id;
        this.projects = projects;
    }

    public Long getEmployee_id() {
        return this.employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public double getTotal_work_percentage() {
        return this.total_work_percentage;
    }

    public void setTotal_work_percentage(double total_work_percentage) {
        this.total_work_percentage = total_work_percentage;
    }

    public Long getMembership_count() {
        return this.membership_count;
    }

    public void setMembership_count(Long membership_count) {
        this.membership_count = membership_count;
    }

    public Long getDepartment_id() {
        return this.department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public Set<Project> getProjects() {
        return this.projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Employee employee_id(Long employee_id) {
        setEmployee_id(employee_id);
        return this;
    }

    public Employee first_name(String first_name) {
        setFirst_name(first_name);
        return this;
    }

    public Employee last_name(String last_name) {
        setLast_name(last_name);
        return this;
    }

    public Employee email(String email) {
        setEmail(email);
        return this;
    }

    public Employee salary(BigDecimal salary) {
        setSalary(salary);
        return this;
    }

    public Employee total_work_percentage(double total_work_percentage) {
        setTotal_work_percentage(total_work_percentage);
        return this;
    }

    public Employee membership_count(Long membership_count) {
        setMembership_count(membership_count);
        return this;
    }

    public Employee department_id(Long department_id) {
        setDepartment_id(department_id);
        return this;
    }

    public Employee projects(Set<Project> projects) {
        setProjects(projects);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(employee_id, employee.employee_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_id);
    }

    @Override
    public String toString() {
        return "{" +
                " employee_id='" + getEmployee_id() + "'" +
                ", first_name='" + getFirst_name() + "'" +
                ", last_name='" + getLast_name() + "'" +
                ", email='" + getEmail() + "'" +
                ", salary='" + getSalary() + "'" +
                ", total_work_percentage='" + getTotal_work_percentage() + "'" +
                ", membership_count='" + getMembership_count() + "'" +
                ", department_id='" + getDepartment_id() + "'" +
                ", projects='" + getProjects() + "'" +
                "}";
    }
}
