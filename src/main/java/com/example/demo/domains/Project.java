package com.example.demo.domains;

import java.time.*;
import java.util.*;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "projects")
public class Project {
    /*
     * Table: projects
     * Columns:
     * PROJECT_ID bigint PK
     * PROJECT_NAME varchar(25)
     * LEADER_ID bigint
     * PROJECT_STATUS varchar(1)
     * PROJECT_START_DATE date
     * PROJECT_END_DATE date
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long project_id;

    @Column(length = 25)
    String project_name;

    // Long leader_id;
    @Column(length = 1)
    String project_status;

    LocalDate project_start_date;
    LocalDate project_end_date;

    // @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    // @JoinColumn(name = "leader_id", nullable = false)
    // @JsonIdentityReference
    // private Employee leader_id;
    // @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    // @JoinColumn(name = "leader_id", referencedColumnName = "employee_id",
    // nullable = false)

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })

    // Constraint - Foreign Key
    @MapsId("employee_id") 
    @JoinColumn(
        name = "leader_id", 
        nullable = false, 
        foreignKey = @ForeignKey(name = "fk_projects_leader_id")
    )

    @JsonIgnore 
    //@JsonIdentityReference
    private Employee leader; // Attributo di classe

    public Project() {
    }

    public Project(Long project_id, String project_name, String project_status, LocalDate project_start_date,
            LocalDate project_end_date, Employee leader) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.project_status = project_status;
        this.project_start_date = project_start_date;
        this.project_end_date = project_end_date;
        this.leader = leader;
    }

    public Long getProject_id() {
        return this.project_id;
    }

    public void setProject_id(Long project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return this.project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_status() {
        return this.project_status;
    }

    public void setProject_status(String project_status) {
        this.project_status = project_status;
    }

    public LocalDate getProject_start_date() {
        return this.project_start_date;
    }

    public void setProject_start_date(LocalDate project_start_date) {
        this.project_start_date = project_start_date;
    }

    public LocalDate getProject_end_date() {
        return this.project_end_date;
    }

    public void setProject_end_date(LocalDate project_end_date) {
        this.project_end_date = project_end_date;
    }

    public Employee getLeader() {
        return this.leader;
    }

    public void setLeader(Employee leader) {
        this.leader = leader;
    }

    public Project project_id(Long project_id) {
        setProject_id(project_id);
        return this;
    }

    public Project project_name(String project_name) {
        setProject_name(project_name);
        return this;
    }

    public Project project_status(String project_status) {
        setProject_status(project_status);
        return this;
    }

    public Project project_start_date(LocalDate project_start_date) {
        setProject_start_date(project_start_date);
        return this;
    }

    public Project project_end_date(LocalDate project_end_date) {
        setProject_end_date(project_end_date);
        return this;
    }

    public Project leader(Employee leader) {
        setLeader(leader);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Project)) {
            return false;
        }
        Project project = (Project) o;
        return Objects.equals(project_id, project.project_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project_id);
    }

    @Override
    public String toString() {
        return "{" +
                " project_id='" + getProject_id() + "'" +
                ", project_name='" + getProject_name() + "'" +
                ", project_status='" + getProject_status() + "'" +
                ", project_start_date='" + getProject_start_date() + "'" +
                ", project_end_date='" + getProject_end_date() + "'" +
                ", leader='" + getLeader() + "'" +
                "}";
    }
}
