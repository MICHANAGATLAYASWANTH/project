package com.yashvanth.employee.Model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Attendance {

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(LocalTime loginTime) {
		this.loginTime = loginTime;
	}

	public LocalTime getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(LocalTime logoutTime) {
		this.logoutTime = logoutTime;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private LocalTime loginTime;
    private LocalTime logoutTime;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    @JsonBackReference  // Prevent the serialization of Employee from Attendance
    private Employee employee;
    
    @Override
    public String toString() {
        return "Attendance{id=" + id + ", date=" + date + ", loginTime=" + loginTime + ", logoutTime=" + logoutTime + "}";
    }
}
