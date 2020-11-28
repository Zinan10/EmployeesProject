package org.example.DTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeDTO
{

    private int employeeId;
    private String name_Prefix;
    private String first_Name;
    private String middle_initial;
    private String last_Name;
    private String gender;
    private String email;
    private LocalDate dob;
    private LocalDate doj;
    private int salary;

    public EmployeeDTO(int employeeId, String name_Prefix, String first_Name, String middle_initial, String last_Name, String gender, String email, LocalDate dob, LocalDate doj, int salary) {
        this.employeeId = employeeId;
        this.name_Prefix = name_Prefix;
        this.first_Name = first_Name;
        this.middle_initial = middle_initial;
        this.last_Name = last_Name;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        this.doj = doj;
        this.salary = salary;
    }

    public EmployeeDTO(String[] theEmployees) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
        this.employeeId = Integer.parseInt(theEmployees[0]);
        this.name_Prefix = theEmployees[1];
        this.first_Name = theEmployees[2];
        this.middle_initial = theEmployees[3];
        this.last_Name = theEmployees[4];
        this.gender = theEmployees[5];
        this.email = theEmployees[6];
        this.dob = LocalDate.parse(theEmployees[7], dtf);
        this.doj = LocalDate.parse(theEmployees[8], dtf);
        this.salary = Integer.parseInt(theEmployees[9]);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getAll()

    {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(employeeId));
        sb.append(" ");
        sb.append(name_Prefix);
        sb.append(" ");
        sb.append(first_Name);
        sb.append(" ");
        sb.append(middle_initial);
        sb.append(" ");
        sb.append(last_Name);
        sb.append(" ");
        sb.append(gender);
        sb.append(" ");
        sb.append(email);
        sb.append(" ");
        sb.append(dob.toString());
        sb.append(" ");
        sb.append(doj.toString());
        sb.append(Integer.toString(salary));

        return sb.toString();
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName_Prefix() {
        return name_Prefix;
    }

    public void setName_Prefix(String name_Prefix) {
        this.name_Prefix = name_Prefix;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getMiddle_initial() {
        return middle_initial;
    }

    public void setMiddle_initial(String middle_initial) {
        this.middle_initial = middle_initial;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
