package com.vivek.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="projects")
public class Project {

    @Id
    @Column(name="project_id")
    private int id;

    @Column(name="project_name")
    private String name;

    @Column(name="tech")
    private String technology;

    @ManyToMany(mappedBy = "projectList")
    private List<Employee> employeeList;

    public Project() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
