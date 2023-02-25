package com.vivek.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @Column(name="employee_id")
    private int id;

    @Column(name="employee_name")
    private String name;

    private Gender gender;

    @ManyToMany
    @JoinTable(
            name = "emp_proj",
            joinColumns = {@JoinColumn(name="proj_id")},
            inverseJoinColumns = {@JoinColumn(name = "emp_id")}
    )
    private List<Project> projectList;

    public Employee() {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
