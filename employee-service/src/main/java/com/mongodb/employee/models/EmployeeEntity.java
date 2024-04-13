package com.mongodb.employee.models;

import org.bson.types.ObjectId;

import java.util.Date;
import java.util.Objects;

public class EmployeeEntity {

    private ObjectId id;
    private String firstName;
    private String lastName;
    private String company;
    private Date joined;
    private int salary;

    public EmployeeEntity() {
    }

    public EmployeeEntity(ObjectId id, String firstName, String lastName, String company, Date joined, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.joined = joined;
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (joined != null ? joined.hashCode() : 0);
        result = 31 * result + salary;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (salary != that.salary) return false;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(firstName, that.firstName)) return false;
        if (!Objects.equals(lastName, that.lastName)) return false;
        if (!Objects.equals(company, that.company)) return false;
        return Objects.equals(joined, that.joined);
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getJoined() {
        return joined;
    }

    public void setJoined(Date joined) {
        this.joined = joined;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
