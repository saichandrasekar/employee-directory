package com.sai.backend.viewobject;

import com.sai.backend.entity.Employee;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Calendar;

public class EmployeeVO {

    private Integer employeeId;

    @NotBlank(message = "The first name is required")
    @Size(min = 2, max = 20, message = "The length of first name must be between 2 and 20")
    private String firstName;
    @NotBlank(message = "The last name is required")
    @Size(min = 2, max = 25, message = "The length of last name must be between 2 and 25")
    private String lastName;
    @Size(min = 0, max = 25, message = "The max length of email is 25")
    @Email(message = "The email address is invalid.", flags = { Pattern.Flag.CASE_INSENSITIVE })
    private String email;
    @Size(min = 0, max = 25, message = "The max length of Phone Number is 25")
    @Pattern(regexp = "^[0-9|-]{0,20}$", message = "The phone number can contain only digits and dashes")
    private String phoneNumber;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Calendar hireDate;
    @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0")
    @Digits(integer=6, fraction=2, message = "Salary value out of bounds (<6 digits>.<2 digits> expected)")
    private BigDecimal salary;
    private Integer managerId;

    private Integer departmentId;


    public EmployeeVO() {

    }

    public EmployeeVO(final Employee employee) {
        this.employeeId = employee.getEmployeeId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
        this.phoneNumber = employee.getPhoneNumber();

        Calendar hireDate = Calendar.getInstance();
        if (employee.getHireDate() == null) {
            hireDate = null;
        } else {
            hireDate.setTime(employee.getHireDate());
        }
        this.hireDate = hireDate;

        this.salary = employee.getSalary();
        this.managerId = employee.getManagerId();
        this.departmentId = employee.getDepartmentId();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Calendar getHireDate() {
        return hireDate;
    }

    public void setHireDate(Calendar hireDate) {
        this.hireDate = hireDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }


    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }


}
